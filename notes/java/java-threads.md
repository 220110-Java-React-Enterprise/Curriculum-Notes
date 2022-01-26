# Module - Java Threads

## Intro to Concurrency
**Concurrency** refers to breaking up a task or piece of computation into different parts that can be executed independently, out of order, or in partial order without affecting the final outcome. One way - but not the only way - of achieving concurrency is by using multiple threads in the same program.

Operating systems use concurrency to manage the many different programs that run on them. The GUI - graphical user interface - for example, is run at the same time as other processes. Without this, any process that took too long in the background, like reading / writing to files or making an HTTP request, would block the GUI and prevent any other user input.

### Multi-core Processing
Most computers these days have multiple cores or CPUs, which means that calculations at the hardware level can be done in parallel. Without multiple cores, operating systems can still achieve concurrency with a process called **time splicing** - this means running one process for a short time, then switching to another, and back very rapidly. This ensures that no process or application is completely blocked.

On multi-core systems, different processes can be run on different CPUs entirely. This enables true parallelization and is a key benefit of writing multithreaded programs.

## Introduction to Threads
A thread is a subset of a process that is also an independent sequence of execution, but threads of the main process run in the same memory space, managed independently by a scheduler. So, we can think of a thread as a "path of execution", but they can access the same objects in memory.

Every thread that is created in a program is given its own call stack, where it stores local variables references. However, all threads share the same heap, where the objects live in memory. Thus, two threads could have separate variable references on two different stacks that still point to the same object in the heap.

### Multithreading
Multithreading extends the idea of multitasking into applications where you can subdivide operations in a single application into individual, parallel threads. Each thread can have its own task that it performs. The OS divides processing time not just with applications, but between threads. Multi-core processors can actually run multiple different processes and threads concurrently, enabling true parallelization.

In Java, multithreading is achieved via the [`Thread`](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html) class and/or the [`Runnable`](https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html) interface.

#### A Note on Best Practices
In general, it is best to avoid implementing multithreading yourself if possible. The benefit of multithreaded applications is better performance due to non-blocking execution. However, you should always measure or attempt to estimate the performance benefit you will get by using threads versus the tradeoff in complexity and subtle bugs that might be generated. Usually there are frameworks, tools, or libraries that have implemented the problem you are trying to solve, and you can leverage those instead of trying to build your own solution. For example, web servers like Apache Tomcat have multithreading built-in and provide APIs for dealing with network requests without having to worry about threads.

### Thread methods
A few important methods in the `Thread` class include:
* getters and setters for id, name, and priority
* `interrupt()` to explicitly interrupt the thread
* `isAlive()`, `isInterrupted()` and `isDaemon()` to test the state of the thread
* `join()` to wait for the thread to finish execution
* `start()` to actually begin thread execution after instantiation

A few important `static` methods are also defined:
* `Thread.currentThread()` which returns the thread that is currently executing
* `Thread.sleep(long millis)` which causes the currently executing thread to temporarily stop for a specified number of milliseconds

### Lifecycle of a Thread
At any given time, a thread can be in one of these states:
1. **New**: newly created thread that has not started executing
2. **Runnable**: either running or ready for execution but waiting for its resource allocation
3. **Blocked**: waiting to acquire a monitor lock to enter or re-enter a synchronized block/method
4. **Waiting**: waiting for some other thread to perform an action without any time limit
5. **Timed_Waiting**: waiting for some other thread to perform a specific action for a specified time period
6. **Terminated**: has completed its execution

![Thread lifecycle](https://www.javatpoint.com/images/thread-life-cycle.png)

### Thread Priorities
Priorities signify which order threads are to be run. The Thread class contains a few `static` variables for priority:
* MIN_PRIORITY = 1
* NORM_PRIORITY = 5, default
* MAX_PRIORITY = 10

### Creating Threads
There are two options to create and execute a `Thread` in Java:
1. Create a class that implements the `Runnable` functional interface
* implement the `run()` method
* pass an instance of your class to a `Thread` constructor
* call the `start()` method on the thread
	
```java
	public class MyRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println("Inside the MyRunnable class");
		}
	}
```

2. Create a class that extends `Thread`
* implement the `run()` method
* instantiate your class
* call the `start()` method
	
```java
	public class MyThread extends Thread {
		@Override
		public void run() {
			System.out.println("Inside the MyThread class");
		}
	}
```

```java
	public class ThreadDemo {
		public static void main(String[] args) {
			Thread myRunnable = new Thread(new MyRunnable());
			Thread myThread = new MyThread();
			myRunnable.start();
			myThread.start();
		}
	}
```
### run() vs. start()
Start creates a thread, run starts execution. 
Let's say we create a Thread object, obj, with a runnable parameter. If we call obj.run() the run() method begins executing *in the current thread*. It does not spawn a new thread, it simply jumps to that execution and continues until complete, much like any method invokation. start() actually spins up a new thread of execution, and calls it's run() method to begin executing instrucitons. This does result in a new thread running, and execution in the original thread continues, both running in parallel.


### Runnable and Lambda Expressions
Because `Runnable` is a *functional* interface, we can use a lambda expression to define thread behavior inline instead of implementing the interface in a separate class. We pass a lambda expression as the `Runnable` type required in the `Thread` constructor. For example:

```java
public class ThreadLambda {
  public static main(String[] args) {
    Thread willRun = new Thread(() -> {
	  System.out.println("Running!");
	});
	willRun.start();
  }
}
```

## Deadlock
The term "deadlock" describes a situation where 2 or more threads are blocked trying to access the same resource, waiting for the other. Neither thread can continue execution, so the program halts indefinitely.

### `synchronized` keyword
In a multithreaded environment, a race condition occurs when 2 or more threads attempt to access the same resource. Using the `synchronized` keyword on a piece of logic enforces that only one thread can access the resource at any given time. `synchronized` blocks or methods can be created using the keyword. Also, one way a class can be "thread-safe" is if all of its methods are `synchronized`.

## Producer-Consumer Problem

The Producer-Consumer problem is a classic example of a multi-process synchronization problem. Here, we have  a *fixed-size buffer* and two classes of threads - *producers* and *consumers*. Producers produces the data to the queue and Consumers consume the data from the queue. Both producer and consumer shares the same fixed-size buffer as a queue.

**Problem** - The producer should produce data only when the queue is not full. If the queue is full, then the producer shouldn't be allowed to put any data into the queue. The consumer should consume data only when the queue is not empty. If the queue is empty, then the consumer shouldn't be allowed to take any data from the queue.

We can solve the Producer-Consumer problem by using `wait()` & `notify()`methods to communicate between producer and consumer threads. The `wait()` method to pause the producer or consumer thread depending on the queue size. The `notify()` method sends a notification to the waiting thread.

Producer thread will keep on producing data for Consumer to consume. It will use `wait()` method when Queue is full and use `notify()` method to send notification to Consumer thread once data is added to the queue.

Consumer thread will consume the data form the queue. It will also use `wait()` method to wait if queue is empty. It will also use `notify()` method to send notification to producer thread after consuming data from the queue.


```java
//ProducerConsumer.java
public class ProducerConsumer {
    private final Queue<String> buffer;
    private final boolean running;
    private final int MAX_SIZE;

    public ProducerConsumer(int maxSize) {
        MAX_SIZE = maxSize;
        running = true;
        buffer = new ConcurrentLinkedDeque<>();
    }

    public void produce() throws InterruptedException {
        while(running) {

            synchronized (this) {

                while (buffer.size() >= MAX_SIZE) {
                    wait();
                }

                String rand = Integer.toString((int) (Math.random() * 100));
                buffer.add(rand);
                System.out.println("Producing...  " + rand);

                notify();
                Thread.sleep(500); //This is unnecessary, just here to slow the console output and make it easier to read


            }
        }
    }

    public void consume() throws InterruptedException {
        while(running) {
            synchronized (this) {
                while (buffer.isEmpty()) {
                    wait();
                }

                String str = buffer.poll();
                System.out.println("Consuming...  " + str + "\n");

                notify();
                Thread.sleep(500); //This is unnecessary, just here to slow the console output and make it easier to read
            }
        }
    }
}
```

```java
//Main.java
public class Main {
    public static void main(String[] args) {


        ProducerConsumer pc = new ProducerConsumer(10);

        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
```
