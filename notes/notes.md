Algorithms
==========

## Analysis

Correctness and how efficient an algorithm is.

Efficiency:

 - Asymptotic complexity: O(n^2) etc
 - Exact number of steps
 - Average case vs worst case
 - Lower bound 
 - NP-completeness: NP problems can't be solved in polynomial time
 - Undecidable problem: Unsolvable by any algo

 ## Design

  - Divide and conquer
  - Greedy
  - etc

### Examples

**Correctness of "finding max" problem**

 - Find a loop invariant, eg. at end of iteration `i(i = 2, .., n)`, `max` is maximum of elements in `A[1] ... A[i]`.
 - Prove by induction, eg. claim is true for `i = j` where `2 <= j <= n-1` and prove for `i = j+1`. When `j=n`, we're done.

**Efficiency of "finding max" problem**

 - Complexity is `θ(n)`
 - Exactly `n-1` steps
 - Optimal with respect to the number of comparisons of array elements, ie. any algo that correctly solves the prob for `n` elements requires at least `n-1` comparisons of array elements:

For any algo that solves find max, and for any `A`, we can construct a graph on `n` vertices. Construct an edge `ij` if `A[i]` is compared to `Aj[j]` when the algorithm is `mn`.

Proof by contradiction: Suppose `< n-1` comparisons are done. Then the graph has fewer than `n-1` edges. => The graph is not connected.
Let c1 and c2 be two connected components, and because there is no comparison between them, we don't know which one's bigger. => We have a contradiction.

**Efficiency of "finding max-min" problem**

 - Exactly `2(n-1)` steps if two `if`s in the loop. Can be optimized with `if-else`

 A more significant improvement which will reduce # comparisons by 25%: Look two at a time, see slides TODO. `3n/2 - 2` comparisons in worst case.

 **3SUM problem**

 Instance: `A` of `n` distinct elements,
 Question: Do there exist three elements in A that sum to 0?

  - Trivial solution of doing all comparisons is `O(n^3)`
  - Instead of 3 loops, suppose we have 2 and we search for `A[k]` for which sum is 0. If we try all `k` values, we get the previous algo. Instead, we can sort the array and do a binary search. Complexity is `O(n*log n + n^2*log n) == O(n^2*log n)`
  - Further improved: For giving `i`, simultaneiously scan from both ends of A looking for `A[j] + A[k] = -A[i]` starting with `j = i+1 and k=n`. At any stage we either inc `j` or decr `k`. Similar to merging two sorted arrays. Complexity is `O(n^2)`.

 Example: `-11 -10 -7 -3 2 4 8 10`, try doing iterations.

 * Lecture 2, Jan 5, Slide 32 / 191*

 # Problems

 `Size(I)` = # bits required to store the instance I.

Integers 

 - "Fixed size", eg. occupy 1 word of memory
 - "Large" - no bound on their size

Sorting

I = Array of n integers,
Size(I) = 32n bits. Ignore `32n` constant factor

*Slide 35 / 191*

We can determine the complexity of an algorithm without writing a program to implement it.

Running time calculation is dependent on  implementing a program, complexity can be done at a higher level using the pseudocode.

Example:

  - Alg A complexity `theta(n)` running time `20n`
  - Alg B complexity `theta(n^2)` running time `n^2`

  A running time <= B's if n >= 20. B <= A if n <= 20

 Complexity doesn't tell the crossover point, running time.

*Slide 37*

Typically, `f(n)` is complicated, eg. `2n^2 - 7n + 30` is `O(n^2)`. `g(n)` is simple, eg. `n^2` is `O(2n^2  -- 7n + 30)

Idea: ignore constant factors and lower order terms

`f(n)` is `O(g(n))` or `f(n)` belongs to `O(g(n))`. `=` is bad notation.

# Symbols

O || <=
Ω || >=
θ || =
o || <
ω || >

```
f(n) = n^2 - 7n - 30
g(n) = n^2
```

## `f(n)` is `O(g(n))` from first principles

Strategy: Pick c, then figure out a suitable value for n_0,
We want:

```
f(n) <= c * g(n)
Take c = 1
Then n^2 - 7n - 30 <= n^2 forall n >= 0
Also, 0 <= f(n)
```

We need

```
f(n) = (n-10)(n+3)
f(n) >= 0 if n >= 10

Let n_0 = max = {0, 10} = 10
Then 0 <= f(n) <= g(n) if n >= n_0 = 10
```

## Prove `f(n)` is `Ω(g(n))`

We want `cn^2  <= n^2 - 7n - 30`. What values of c should work? Any c < 1 will work, eg. 1/2 then figure out n_0.

## O

```
f(n) = n^2 + n
g(n) = n
```

Prove `f(n)` is not `O(g(n))`

What do we want to prove?

For every `c > 0` and for every `n_0 > 0` there exists `n >= n_0` such that `f(n) > c*g(n)`.

```
f(n) > c*g(n) iff n^2 + n > c*n
iff n+1 > c (n > 0)
iff n > c - 1

Let n = max{c, n_0}
and the inequality holds.
```

*Slide 39*

Can try l'hopital rule

In general, `(ln n)^c`  belongs to o(n^𝛿)` for any `c > 0` (no matter how big) and for any `𝛿 > 0` (no matter how small).

Also `n^c` belongs to `o(d^n)` for all `c > 0` and `d > 1`.

If theorem doesn't apply [limit doesn't exist], eg. in

```
f(n) = (3+ (-1)^n)n
g(n) = n

f(n) = {
	4n if n is even,
	2n if n is odd
}

f(n)/g(n) = {4 even, 2 odd}. So lim n->infinity f(n)/g(n) doesn't exist.
```

However `f(n)` is θ(g(n))` because we can take `c_1 = 2, c_2 = 4, n_0 = 0` and the definition is satisfied.

*Slide 41*

Suppose `f(n) is theta(g(n))` (prove g(n) is theta(f(n))), there exists c_1 > 0, c_2 > 0, n_0 > 0 st `0 <= c_1 g(n) <= f(n) <= c_2g(n)` for n >= n_0

So `0 <= 1/2 c_2 f(n) <= g(n) <= 1/c_1 f(n)` for n >= n_0

Let c1' = 1/c_2, c_2' = 1/c_1, n_0' = n_0, then 0 <= c_1' f(n) <= g(n) <= c_2' f(n) for n >= n_0'

Summation rules only apply to finite sums (I is a finite set)

Start with this

sum i=1 to n O(i) = O(sum i=1 to n i) = O(n (n+1) / 2) = O(n^2)