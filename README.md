# matchmaker

A simple implementation of the [Gale–Shapley algorithm](http://www.econ.ucsb.edu/~tedb/Courses/Ec100C/galeshapley.pdf) as a solution to the [Stable marriage problem](https://en.wikipedia.org/wiki/Stable_marriage_problem). The code is fairly ugly at the moment, but I hope to clean it up and add configurable groups to allow for practical use in the future.

## Usage

    $ lein run

## Example Output

> Results:
> A ==> j
> B ==> s
> C ==> z
> D ==> h
> E ==> f
> F ==> r
> G ==> x
> H ==> i
> I ==> g
> J ==> u
> K ==> e
> L ==> d
> M ==> o
> N ==> v
> O ==> p
> P ==> y
> Q ==> q
> R ==> b
> S ==> n
> T ==> k
> U ==> a
> V ==> c
> W ==> l
> X ==> m
> Y ==> w
> Z ==> t
>
> Group 1's matches with respect to preference:
> A ==> n | u | y | h | p | **j** | m | r | w | a | l | d | g | z | i | v | t | c | x | f | e | k | q | s | o | b
> B ==> **s** | d | p | a | j | v | b | t | m | g | c | h | y | e | x | l | f | o | n | u | k | w | i | r | z | q
> C ==> e | y | g | **z** | l | m | u | s | v | o | h | w | r | d | k | i | b | t | q | c | a | f | j | p | n | x
> D ==> v | t | e | r | **h** | l | x | p | b | w | o | j | c | m | a | d | y | g | k | u | s | q | n | z | f | i
> E ==> **f** | r | m | i | x | p | h | d | v | q | t | u | y | n | a | b | g | c | e | z | w | s | j | l | o | k
> F ==> v | k | z | g | m | p | n | d | i | f | t | e | b | **r** | s | w | x | y | h | u | l | o | a | j | q | c
> G ==> l | p | t | y | c | **x** | a | n | i | z | g | o | q | r | w | v | f | k | b | m | d | e | u | h | s | j
> H ==> p | x | m | u | z | a | **i** | r | v | b | c | o | q | h | s | y | t | j | k | l | g | e | d | n | f | w
> I ==> v | p | **g** | k | n | h | s | b | d | f | l | y | m | e | x | r | u | c | o | z | j | i | w | t | q | a
> J ==> b | w | d | h | **u** | t | e | c | q | g | a | r | v | s | z | l | p | f | m | o | j | x | n | y | i | k
> K ==> n | w | g | m | p | **e** | u | y | x | z | k | a | f | c | h | l | s | i | b | j | r | d | o | v | t | q
> L ==> a | h | y | **d** | x | c | j | z | n | g | f | v | w | s | t | p | q | e | o | l | k | i | r | u | b | m
> M ==> q | w | j | v | k | h | e | m | b | z | l | d | **o** | x | c | y | t | n | g | i | r | s | a | p | f | u
> N ==> y | s | a | d | h | **v** | x | g | i | c | f | q | p | k | r | t | o | j | e | n | w | m | u | z | b | l
> O ==> w | **p** | q | e | x | j | t | m | f | i | k | o | s | l | n | r | a | u | v | z | d | h | g | b | c | y
> P ==> **y** | t | m | a | f | c | v | j | s | l | h | i | w | k | x | g | u | z | e | p | o | d | b | q | n | r
> Q ==> g | c | y | a | v | n | m | **q** | s | z | k | o | x | e | h | u | i | j | p | b | d | l | r | f | t | w
> R ==> c | **b** | d | g | z | o | i | a | l | h | j | m | r | q | p | s | v | u | f | n | w | y | x | e | k | t
> S ==> v | c | q | **n** | l | w | x | h | d | a | p | z | t | o | m | g | u | y | r | f | k | b | e | i | j | s
> T ==> w | p | i | **k** | a | x | c | y | g | j | z | o | q | m | e | f | b | d | v | u | h | t | r | n | l | s
> U ==> s | w | p | q | l | **a** | v | g | b | e | j | f | o | c | y | t | r | z | x | h | k | i | m | d | u | n
> V ==> d | j | z | l | n | b | p | t | h | **c** | a | o | q | g | m | e | v | k | u | r | y | i | s | f | x | w
> W ==> z | x | n | **l** | g | j | y | u | v | p | m | o | q | h | a | e | b | s | r | w | t | d | k | f | i | c
> X ==> g | c | y | z | x | **m** | h | l | r | t | d | q | p | o | n | b | a | v | i | s | e | j | w | u | f | k
> Y ==> i | v | x | c | d | e | h | l | z | **w** | y | o | g | t | r | f | j | u | p | n | q | k | s | b | a | m
> Z ==> l | **t** | e | q | y | j | d | p | x | c | v | n | h | r | w | m | b | i | o | s | u | f | a | z | g | k
>
> Group 2's matches with respect to preference:
> a ==> **U** | E | O | B | L | K | S | H | D | Y | T | V | N | M | Z | W | I | X | A | F | P | J | C | G | Q | R
> b ==> P | S | Q | **R** | N | H | D | A | B | K | W | V | X | L | J | Y | U | F | T | M | I | Z | C | G | E | O
> c ==> A | T | F | P | **V** | Z | D | Y | R | S | I | B | E | W | J | X | N | Q | U | H | K | M | O | G | L | C
> d ==> G | W | H | C | X | T | **L** | E | V | Y | F | U | R | K | M | N | I | B | Z | J | Q | D | O | A | S | P
> e ==> S | N | Z | **K** | A | V | E | I | W | D | X | C | F | H | B | R | T | U | G | Q | Y | O | M | J | L | P
> f ==> A | C | B | N | Y | Q | W | P | **E** | X | U | G | S | F | D | M | J | Z | O | V | R | K | H | L | T | I
> g ==> B | A | U | T | D | H | Y | **I** | F | G | R | K | W | J | M | V | N | Z | L | S | X | C | Q | O | E | P
> h ==> F | I | **D** | V | C | T | S | Z | M | O | R | Q | P | A | E | N | U | X | L | H | J | Y | W | G | K | B
> i ==> W | C | R | O | D | B | V | **H** | I | U | J | X | K | Q | G | L | Y | S | E | M | N | T | P | F | A | Z
> j ==> E | S | K | G | **A** | Z | D | L | J | X | Y | N | P | T | Q | C | M | U | V | R | H | B | O | W | I | F
> k ==> C | S | K | Q | A | H | **T** | P | O | J | V | M | G | W | Y | L | B | R | F | X | N | E | U | Z | I | D
> l ==> **W** | V | L | Z | U | K | A | Q | R | O | B | N | F | M | H | I | S | X | Y | D | E | G | J | P | T | C
> m ==> D | Z | G | **X** | Y | A | E | I | M | P | W | B | K | N | C | L | S | H | O | V | T | J | R | F | U | Q
> n ==> H | D | T | L | C | **S** | K | A | F | Z | W | I | Q | R | X | G | J | B | V | U | E | O | Y | P | N | M
> o ==> O | R | **M** | W | Y | K | F | X | N | V | B | P | S | T | H | E | Q | I | U | Z | D | G | C | J | A | L
> p ==> W | C | Q | **O** | Z | Y | V | P | S | N | M | K | A | L | G | D | T | F | X | I | U | R | J | B | H | E
> q ==> **Q** | Z | K | T | D | N | V | I | P | F | S | L | B | M | J | A | H | O | U | C | G | Y | X | R | W | E
> r ==> Q | S | Z | T | B | **F** | Y | J | M | A | V | D | G | H | P | X | R | C | U | L | N | K | W | O | E | I
> s ==> A | L | F | E | P | J | **B** | W | H | Q | R | K | T | Z | C | G | X | D | O | N | I | U | V | M | S | Y
> t ==> L | B | H | J | **Z** | U | C | I | R | E | Y | P | W | F | D | X | Q | A | G | S | K | N | M | O | T | V
> u ==> D | Z | R | E | P | **J** | K | B | G | O | Q | N | C | S | W | T | U | I | L | Y | X | F | A | V | M | H
> v ==> A | **N** | G | E | F | C | K | T | I | R | M | D | H | Q | Z | U | J | X | L | Y | V | B | O | P | S | W
> w ==> C | R | N | X | D | A | E | **Y** | Q | I | H | T | G | M | S | F | K | W | J | Z | L | P | O | V | B | U
> x ==> Z | M | P | I | F | J | **G** | H | U | T | N | D | K | L | S | C | A | E | W | X | Q | R | Y | V | B | O
> y ==> **P** | I | E | S | R | Z | V | L | A | Y | T | M | N | B | H | C | G | Q | K | X | U | W | F | D | J | O
> z ==> R | Z | **C** | B | U | K | W | T | E | I | G | S | J | V | M | A | D | L | N | O | P | F | Q | X | H | Y

## License

Copyright © 2015 David Busse

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
