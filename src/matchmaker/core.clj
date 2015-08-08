(ns matchmaker.core
  (:require [clojure.set :refer :all])
  (:gen-class))

(def group-1 [:A :B :C :D :E :F :G :H :I :J :K :L :M :N :O :P :Q :R :S :T :U :V :W :X :Y :Z])
(def group-2 [:a :b :c :d :e :f :g :h :i :j :k :l :m :n :o :p :q :r :s :t :u :v :w :x :y :z])

(defn generate-random-prefs [g1 g2]
  (into {} (for [i g1] [i (shuffle g2)])))

(defn remove-matched-members [group-prefs matches]
  (apply dissoc group-prefs (vals matches)))

(defn bump-prefs [prefs]
  (into {} (for [[k v] prefs] [k (rest v)])))

(defn better-match? [prefs prev-match member]
  (or (nil? prev-match)
      (< (.indexOf prefs member) (.indexOf prefs prev-match))))

(defn make-proposal [targets-prefs matches member prefs]
  (let [target       (first prefs)
        target-prefs (targets-prefs target)
        prev-match   (matches target)]
    (if (better-match? target-prefs prev-match member)
      (assoc matches target member)
      matches)))

(defn match [group-1-prefs group-2-prefs]
  (loop [group-1-prefs group-1-prefs
         matches       {}]
    (if (= (count matches) (count group-2-prefs))
      matches
      (let [available-members (remove-matched-members group-1-prefs matches)]
        (recur (merge group-1-prefs (bump-prefs available-members))
               (reduce-kv (partial make-proposal group-2-prefs)
                          matches
                          available-members))))))

(def color-codes
  {:green  "\u001B[1;32m"
   :blue   "\u001B[34m"
   :yellow "\u001B[1;33m"})

(defn colorize-str [string color]
  (str (color-codes color) string "\u001B[m"))

(defn format-prefs-output [prefs matches member]
  (map #(if (= (matches %) member)
          (str "\u001B[4m" (colorize-str (name %) :yellow) "\u001B[24m")
          (name %))
       prefs))

(defn print-group-results [group-prefs matches]
  (doseq [[member prefs] (sort group-prefs)]
    (println (colorize-str (name member) :green)
             "==>"
             (clojure.string/join " | " (format-prefs-output prefs matches member)))))

(defn print-results [group-1-prefs group-2-prefs matches]
  (println "Results:")
  (doseq [[m1 m2] (sort (map-invert matches))]
    (println (colorize-str (name m1) :green) "==>" (colorize-str (name m2) :yellow)))
           
  (println "\nGroup 1's matches with respect to preference:")
  (print-group-results group-1-prefs matches)
  (println "\nGroup 2's matches with respect to preference:")
  (print-group-results group-2-prefs (map-invert matches)))

(defn -main [& args]
  (let [group-1-prefs (generate-random-prefs group-1 group-2)
        group-2-prefs (generate-random-prefs group-2 group-1)]
    (print-results group-1-prefs
                   group-2-prefs
                   (match group-1-prefs group-2-prefs))
    (println "\n\nSame algorithm with groups swapped:")
    (print-results group-2-prefs
                   group-1-prefs
                   (match group-2-prefs group-1-prefs))))
