# Module - Java File I/O

## File I/O
"I/O" refers to the nature of how data is accessed, either by reading it from a resource (input) or writing it to a resource (output). In Java, File I/O objects fall into one of two categories:
* `Streams` are for reading or writing **bytes**
* `Reader/Writer` are for reading or writing **characters**

Some Common File I/O classes are
* `FileInputStream` - reads raw bytes from a file
* `FileOutputStream` - writes raw bytes to a file
* `FileReader` - reads characters from a file
* `FileWriter` - writes characters to a file
* `BufferedReader` - reads a file line by line, needs an instance of a `FileReader` with a path to the resource to be read in the constructor
* `BufferedWriter` - writes to a file line by line, needs an instance of a `FileWriter` with a path to the destination file in the constructor
* `Scanner` - can read from an `InputStream`, useful methods for character reading

Character files are read line by line, either until a carriage return (`\r`) or a newline (`\n`), depending on your operating system. When using I/O classes to read and write, you should **always close your resources** with the `.close()` method. This prevents exceptions from being thrown later, memory leaks, and system overutilization of unused resources.

### Reading User Input from Console
The `Scanner` class can be used to read user input from the command line:

```java
Scanner sc = new Scanner(System.in);
while (true) {
  String input = sc.readLine();
  System.out.println("Your input: " + input);
}
```

When the code above is run, the program acts to "echo" back any input given from `stdin`.

## Serialization
Serialization is the process of writing the state of an object to a byte stream; the reverse is called deserialization. In order for an object to be serialized, it must implement the `Serializable` interface.

### Marker Interfaces
`Serializable` is a **marker interface**, which is an interface with no methods. The point of such an interface is to *provide metadata* to the compiler - in this case, it tells the compiler that this class can be serialized.

### Serializing an object
To serialize an Object, you need a `FileOutputStream` instance inside the constructor of an `ObjectOutputStream`, passing in the file path of where you want the Object to be serialized
* Call the `ObjectOutputStream.writeObject(yourObject)` method

### Deserializing an object
To deserialize an Object, you need a `FileInputStream` instance inside the constructor of an `ObjectInputStream`, passing in the file path of where the serialized object is
* Call the `ObjectInputStream.readObject()` method, casting it to a bean of your type
