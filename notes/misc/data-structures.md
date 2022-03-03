# Common & Important Data Structures


## Array
An array is probably the simpliest data structure. An array is a contiguous block of memory filled with elements. The width of each element is the same and any element can be found by giving an index. You get the element at some index by offsetting from the beginning of the array: `addressOfArray + index * width = location of element`  
  
Arrays in most languages have a defined size, and you cannot grow it. Instead you must create a new larger array and copy the old array into it, then you can add more elements. In some languages arrays are dynamically sized, but under the hood this copy operation is being done for you.

## Vector
A vector is a dynamically resizing array. When the array is filled and a new element gets added, the vector creates a new larger array and copies the old array into it before discarding the original. This may sound just like Java's ArrayList, and that's because a Java ArrayList is a vector. Confusingly, Java also has a collection called vector, which is simply a thread-safe ArrayList. Some languages have dynamically resizing arrays, you can consider these to be implementations of the vector data structure.

## Linked List
Another simple data structure, a linked list is made up of nodes which reference the next node in the list. Unlike arrays, these nodes do not need to be contiguous. A doubly-linked list is one where the nodes have references to both the next and previous nodes. A linked list has a head, and a doubly-linked list has a head and a tail. These are the first and last nodes in the list.  
  
Linked lists are very good for insertion and removal of nodes, as the operation to splice a node in or out is constant time O(1). Finding the node in question, however, is linear time O(n) as you must search the list to find the index where the splice happens. So, while a linked list add/remove operation is O(1), there is some overhead. Still we consider the operation to be constant time.


## Stack
A stack is a Last In First Out (LIFO) data structure. This means that the last element added to the stack is the first one retrieved, and the first element added is the last one to be retrieved. This limitation is due to how the stack works, the only way to add and get elements from the stack is to do push and pop. Push operation adds an element to the top of the stack, pop removes and returns the top element in the stack. Think of it like a stack of plates. You stack them from the bottom up, adding (or "pushing") one plate at a time. When it's time to get the plates off the stack, you remove (or "pop") them one at a time from the top.  
  
Under the hood a stack may be implemented as contiguous memory like an array where the elements are all next to eachother in memory. Or, it may be implemented with nodes like a linked list where one or more elements are next to eachother and have references to neighbors located elsewhere in memory.


## Queue
A queue is FIFO, First In First Out. The first element added is the first element removed. Think of it like waiting in line at the bank. The first person to get in line will be the first person served once the wait is over. The last person to enter the queue is the last to be served. 

Just like the stack, the queue may be implemented in a contiguous or non-contiguous fashion. 

## Dequeue
Dequeue, or Double Ended Queue, is like a queue where you can add and remove elements from both the front and back. This best-of-both-worlds dequeue can be used to implement both a stack and a queue in a single implmentation. The push_back, push_front, pop_back, and pop_front operations are all O(1) time just like in queues and stacks, which means you can often use a dequeue structure anywhere you might want a stack or queue. Just keep in mind that dequeue has operations that aren't necessarily valid for queue or stack, which may cause confusion.  
  
And again, this can be implemented in a contiguous or non-contiguous fashion. 


## Hash Table
A hash function is an operation that transforms some value into a different value. Often what we want to do is take some set and be able to hash it into a smaller set. For instance, a very simple hash function to transform from the set of all positive integers to the set of integers 0-9 could be done with the modulo operator: `x % 9 = y`. Any positive integer input to this hash function will result in an integer between 0 and 9 inclusive. A hash table is basically an array where some hash function is used to get the index. If you can hash any input to get an array index, then you can hash the value of the element itself to find it's index. This way if you want to find the index of some element, you simply hash the element. The key to a hash table is that for any element you can rapidly find it's index, and thus retrieve it from the array.

#### Handling Collisions
When we transform one set into a smaller set, we will probably get something called collisions. In the example above both `5 % 9 = 5` and `14 % 9 = 5`. If both 5 and 14 would be stored in index 5, what do we do? There are two main ways to handle this, linking and open addressing. With linking, each "bucket" is a linked list, and adding a new element where one already exists just means appending it to the end of the list. In order to find an element, you can hash it to find an index, and search through that linked list for the individual matching element. Open addressing means that if a "bucket" is filled, you simply move onto another bucket. When you find an empty bucket, you add the element. If you were to search for that element and found the element at the hashed index did not match, you would follow the same steps to go looking for where that element ended up.


## Tree
A tree is similar to a linked list in that it is made up of nodes which reference other nodes. Unlike a linked list, nodes can be linked to more than 1 other node (or 2 for a doubly linked list). Trees also have a hierarchy to the nodes where the links establish parent/child relationships. There are many types of tree, for excample Binary Search Tree, Red-Black Tree, and General Tree to name a few. There are many types of tree, and each will have some characteristics that make it idealy suited for a particular use.  
  
Every tree has a root, which is the parent most node. Nodes are connected to other nodes, and this is commonly visualized as simple shapes with lines connecting them. The shapes are "nodes" or "vertices" and the lines connecting them are "edges". Nodes that have no children are called "leaf nodes". The root node is the only node in a tree with no parent.

#### General Tree
Lacks many additional characteristics, and is the most simple tree.
#### Binary Tree 
A node can have 0, 1, or 2 children. 
#### Binary Search Tree
A type of binary tree that mantains a sorted order and categorizes child nodes as left and right. Every left child must have a value that is less than the parent node, and every right child must have a value that is greater than the parent. These rules make this structure extremely good at searching for an element.
#### AVL Tree
Named after it's creators Adelson, Velski & Landis, this binary tree mantains a balance where for any node it's two sub trees (formed by considering each child to be the root node of a subtree) cannot have a difference in depth greater than the "balance factor", which is 1. If for some reason the tree is in a state where it is unbalanced, operations called "rotations" must be preformed to re-balance it.
#### Red-Black Tree
This tree is self-balanced binary tree just like AVL, but each node is "painted" either red or black. This characteristic is used to help maintain the balance. Root and leaf nodes are all considered black, when a node is inserted it is considered red, and a red node may not have a red child. If these rules are violated the tree must re-balance using rotations or by re-painting. There is quite a bit to these operations and you should look up more in-depth material if you are interested.

## Heap
A heap is a type of binary tree in which the parent nodes are compared to their children. This allows the values within the nodes to be arranged accordingly. Heaps can be represented as trees, but they can also be represented as binary arrays.  
  
There are two types of heaps. In a min heap, the parent’s key is less than or equal to the keys of its children. In a max heap, the parent’s key is greater than or equal to the keys of its children.  
  
Heaps are often used in algorithms to create priority queues, and to find the smallest or largest value in an array.  

## Graph
Much like a tree, a graph is made up of "nodes" or "vertices" connected by "edges". Some graphs are directed, in that the edges only go one way, and some are undirected which means the edges are all bi-directional. Graphs don't have a hierarchy, the edges do not form parent/child relationships. Graphs are often used to represent networks like circuits or roads.


