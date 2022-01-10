### Stack and Heap
Inside the JVM, our application memory is divided into the [stack](https://en.wikipedia.org/wiki/Stack_\(abstract_data_type\)) and the [heap](https://en.wikipedia.org/wiki/Heap_\(data_structure\)). The stack is where method invocations and reference variables are stored in stack frames. For example, when the JVM invokes the `main` method a stack frame is created for it and placed on the stack. Multiple stacks are possible - for example, when a thread is created it is given its own stack.

The heap, in contrast, is a central location in memory where all objects are stored. New objects are created via the `new` keyword and (optionally) assigned to a reference variable, which can then be re-assigned to reference different objects later. Thus, multiple reference variables could point to the same object in memory.

**Note:** Errors at runtime can be thrown if a program runs out of memory addresses for new stack frames (`StackOverflowError`), or if no memory is available in the heap for object creation (`OutOfMemoryError`).
