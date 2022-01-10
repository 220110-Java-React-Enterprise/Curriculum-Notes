# Control Flow in Java
## Branching
### If-Then
The most basic control flow statement is the if-then statement. This statement evaluates if some predicate is true or false, and if the predicate evaluates to true the code in the block is executed, otherwise it is skipped.
```
if(x == 5 /*predicate statement*/ ) {
    //do something
}
```

### If-Then-Else
An else clause can be added to the basic if-then to get an if-then-else statement. This statement evaluates if a predicate is true or false just like above. If true, the first block is executed, if false the else block is executed.
```
if(x == 5) {
    //do something
} else {
    //do something else
}
```
These stataments can be further expanded by chaining else-if statements. We simply add another if-then after the else and we can chain alternatives as long as we want.
```
if(x == 5) {
    //do something
} else if(x == 6) {
    //do something else
} else if(x >= 7) {
    //do a different thing
} else {
    //finally, if all else fails do this
}
```
Eventually we can optionally end the if-then-else-if chain with a single else that only executes if none of the other predicates were true. In the above example only one of the blocks of code will ever be executed.

### Switch
Switch statements are very similar to the above chain of if-then-else-ifs. We consider one variable and enter a block depending on its value.
```
switch(x) {
    case 5:
        //do something
        break;
    case 6:
        //do something
        break;
    case 7:
        //do something
        break;
    default:
        //finally, if all else fails do this
        break; //break is not strictly necessary here
}
```
Here we can see we are considering some variable x, and we execute code under one of the `case` statements depending on the value of x. If x is neither 5, 6, nor 7 we execute the code under the `default` statement. Inside each case the `break` keyword is used. This keyword breaks you out of any control flow block and skips the remainder of it. Execution continues after the end of the block. In this case each of the `break` keywords causes execution to skip the remainder of the block and begin again after the closing `}`. We must use `break` in switches unless we want to "fall-through" where we continue to execute the code in the other cases.

## Loops
### While Loop
The while loop executes a block of code over and over as long as some predicate holds true. Keep in mind that we must include some way for the loop to end, or else it will continue endlessly until the program terminates.
```
while(x < 5) {
    x++;
}
```
In this example as long as x is less than 5 the loop will continue, but eventually x will be greater than 5 as with each loop 5 increases by one. Once x is equal to or greater than 5 the predicate will be false and the loop will exit. Note that the while loop won't execute one last time, even though the check is at the top of the code, once it is false the block of code is exited imedately and execution continues after the `}`.

### Do-While Loop
Similar to the while loop, the do-while loop has it's predicate check at the end of the block of code. This type of loop will always execute at least once, as the first execution happens before any check is done. Otherwise it behaves similar to the plain while loop. Once the predicate is false looping stops and execution continues after the block.
```
do {
    x++;
} while (x < 5)
```

### For Loop
One of the most common types of loop, the for loop is bounded by beginning and end conditions. Eventually (hopefully) the conditions are met to cease looping and execution continues after the block. The logic that controls looping has three parts, separated by `;`. 
```
for(i = 0; i < 10; i++) {
    //do something 10 times
}
```
In this example i is set to 0, looping continues as long as i is less than 10, with each iteration i is increased by one. Note that there is no logic inside the block to stop iterating, that is all contained within the conditional statement. The first section is initialization, the second is the looping condition, and lastly is advancement.

### For-Each Loop
The for-each loop, sometimes called the enhanced for-loop loops once through a collection of elements. Any collection that implements the `Iterable` interface can be looped through in this way. A for-each loop executes a block of code once for each element in a collection.
```
for(type element : collection) {
    //do something
}
```
This example just shows the parts of the statement, and is not valid. Here is a working example:
```
for (Integer i : integerList) {
    i *= 2;
}
```
For each Integer object in a collection of Integers, take that Integer and double it. Once every member of the collection has been acted upon, the loop is complete end execution continues after the `}`.

## Jumps
### Break
We saw break earlier, commonly used in switch statements to avoid fall-through execution. Break can also be used to break out of any loop or switch statement. Break will cause execution inside the block to stop and execution to continue after the block ends.
```
while(true) {
    x++;
    if(x > 5) {
        break;
    }
}
```
This example is silly, but shows the use of break to conditionally break out of a while loop.

### Continue
Continue is similar to break in that it will cause the current execution inside a loop to cease, however instead of breaking out of the loop, it continues with the next iteration.
```
for(i = 0; i < 5; i++) {
    System.out.println("Hello");
    continue;
    System.out.println("Goodbye");
}
```
This example will print "Hello" 5 times, and will never print "Goodbye". Note that the use of continue still increments i normally.
