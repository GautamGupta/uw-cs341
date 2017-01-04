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