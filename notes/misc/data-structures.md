# Common & Important Data Structures


## Array
An array is probably the simpliest data structure. An array is a contiguous block of memory filled with elements. The width of each element is the same and any element can be found by giving an index. You get the element at some index by offsetting from the beginning of the array: `addressOfArray + index * width = location of element`  
  
Arrays in most languages have a defined size, and you cannot grow it. Instead you must create a new larger array and copy the old array into it, then you can add more elements. In some languages arrays are dynamically sized, but under the hood this copy operation is being done for you.

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

## Heap

## Graph

## Set

## Vector
