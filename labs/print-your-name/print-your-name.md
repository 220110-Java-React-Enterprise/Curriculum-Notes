# Print Your Name

## Instructions

Now that you know how to write a simple program to print, "Hello World", we will modify the program to print your name. 

1\. Open your IDE (Eclipse). On first startup, Eclipse will ask for your default workspace. Go ahead and click on the checkbox that reads "**Use this as the default and do not ask again**". Then click **Launch**. 

![eclipse launcher dialog](images/eclipse-launcher-dialog.jpg)

When Eclipse loads, it'll show a workspace like the following image:

![Eclipse Dashboard](images/eclipse-dashboard.jpg)

To start a new project, you'll need to locate the top menu bar. Then select File > New > Java Project. 

![Eclipse - Menu Bar - File New Java Project](images/eclipse-menu-bar-new-java-project.jpg)

Provide the name, **NameConsole** and click **Finish**.

![Eclipse Project Name](images/eclipse-project-name.jpg)

If Eclipse asks you to create a module, go ahead and click on **Don't Create**. We won't use modules in this course. 

![Eclipse dialog - create module](images/eclipse-dialog-create-module.jpg)

Once the project loads, right-click on the newly created project and select New > Class.

![Eclipse - Create class](images/eclipse-create-class.jpg)

Provide the class the name, **MyClass** and click **Finish**.

![Eclipse New Java Class dialog](images/eclipse-new-java-class-dialog.jpg)

Now edit the file so that it looks like the following:

```java
public class MyClass {

    public static void main(String[] args){
            System.out.println("My Name");
    }
}
```

Replace the words, "My Name" with your actual name.

![Eclipse - Edited Class](images/eclipse-edited-class.jpg)

Now run the program and note the output! It should display your name on the console!

![Eclipse Run Button](images/eclipse-run-button.jpg)

If Eclipse asks which way to run the program, then select **Java Application**. 

![Eclipse run as java application](images/eclipse-run-as-a-java-app.jpg)

The console should display in Eclipse and show the information that you added to print. 

![Eclipse Console Output](images/eclipse-console-output.jpg)

That's all there is to writing and running small Java programs in Eclipse!

This concludes the lab.