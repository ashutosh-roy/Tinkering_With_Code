## Perfect Binary Tree

A perfect binary tree is one where all internal nodes have two children, and all leaf nodes are at the same level. In such a tree, the number of nodes can be derived using the properties of geometric progression.

### Minimum Levels in perfect binary tree
log N+1 levels at least
where N = no. of leaves
_____

### Total Number of leaf Nodes 
N = 2^h
Where:
- h is the height of the tree.

_____

### Total Number of Nodes

N = 2^(h+1) - 1

Where:
- h is the height of the tree.
- N is the total number of nodes in the tree.


#### Geometric Progression Explanation

In a perfect binary tree:
- At level 0 (the root), there is 1 node.
- At level 1, there are 2 nodes (each child of the root).
- At level 2, there are 4 nodes (each child of the nodes at level 1).
- At level k, there are 2^k nodes.

This progression follows a geometric progression where each level has twice as many nodes as the previous level. The total number of nodes in a perfect binary tree is the sum of the nodes across all levels.

#### Formula for Total Nodes

Given that a perfect binary tree of height h has h + 1 levels (starting from level 0), the total number of nodes N is the sum of the nodes across all levels:

N = 1 + 2 + 4 + 8 + ... + 2^h

This is a geometric series with the first term a = 1 and the common ratio r = 2. The sum of the first h + 1 terms of a geometric series is given by:

N = (2^(h+1) - 1) / (2 - 1)

Which simplifies to:

N = 2^(h+1) - 1

### Example

For a perfect binary tree with height 3:

N = 2^(3+1) - 1 = 2^4 - 1 = 16 - 1 = 15

So, a perfect binary tree of height 3 has 15 nodes in total.

### Conclusion

The total number of nodes in a perfect binary tree of height h is given by the formula:

N = 2^(h+1) - 1

Where:
- h is the height of the tree.
- N is the total number of nodes in the tree.