Binary Tree
==============
Insertion complexity
----------------------
Avg Case O(log n)
This is for balanced tree

Worst Case O(n)
Worst case happens of on unbalanced tree where a tree starts behaving like a linked list

Tree DFSTraversal
===============

Complexity O(n)

Pre Order
---------
Node is visited before its children
Usage to create copy of the tree

In Order
---------
Left child is visited before the node and then right child
Usage take action on sorted order

Post Order
-----------
Left and right children are visited before the node
Usage delete children first and then the node

Search
=========

DFSTraversal complexity
---------------------

Avg Case O(log n)
WorstCase O(n)

Deletion
=========

DFSTraversal complexity
---------------------

Avg Case O(log n)
WorstCase O(n)

Node without leaf: Simply remove
Node with one leaf: Remove node and put the child node on its place
Node with two leaves: Remove Node and replace it with its leftmost child of the right node child. If it has further right child leaf then locate it to its parent's place
