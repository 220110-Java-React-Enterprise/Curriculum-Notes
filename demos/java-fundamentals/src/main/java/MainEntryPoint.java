import com.sun.istack.internal.NotNull;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.util.List;


public class MainEntryPoint{
    //Almost every program will need a main method, and everything in java exists inside a class.
    //Here's our main method, note that the signature will almost always be exactly this:
    public static void main(String ...args) {
        //public because it must be accessible from outside this file
        //static because we aren't yet instantiating objects, so it must be associated with the class itself
        //void because the main method never returns anything
        //String[] in the parameter list, this is where command line args go

        //This loop iterates through the string array of command line args and prints them.
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        if(args.length >= 2 && args[0].equals("dog")) {
            Dog myDogSasha = new Dog(args[1]);//Here we are creating and using a string object.
            myDogSasha.makeSound();
        }


        for(int x = 0; x < 10; x++) {
            System.out.println(x);
        }


        //Runtime Polymorphism - We can have a reference to Animal that points to a dog.
        Animal myPetJimmy = new Dog("Jimmy");//Here we are simply using what's called a "string literal"

        //We can then change this object later, this is polymorphism.
        //(This is a very basic example that frankly serves no purpose.
        myPetJimmy = new Cat("Jimmy");



        myPetJimmy.makeSound();

        StaticExample objA = new StaticExample();
        StaticExample objB = new StaticExample();

        System.out.println("Non-static members: " + objA.getNonStaticInt() + ", " + objB.getNonStaticInt());
        System.out.println("Static member: " + objA.getStaticInt() + ", " + objB.getStaticInt());


        objA.setNonStaticInt(6);
        objB.setNonStaticInt(7);
        objB.setStaticInt(20);
        objA.setStaticInt(10);


        System.out.println("Non-static members: " + objA.getNonStaticInt() + ", " + objB.getNonStaticInt());
        System.out.println("Static member: " + objA.getStaticInt() + ", " + objB.getStaticInt());


        //primitives, wrappers, and boxing
        int i = 5;
        Integer myInteger = i;

        ArrayList<Integer> myArrayList = new ArrayList<>();
        myArrayList.add(i);
        myArrayList.add(5);
        myArrayList.add(myInteger);


        String str1 = "my string";
        str1 = str1.concat(" is the best!");

        int[] myArr = new int[]{0,1,2};
        System.out.println(myArr.length);//3   n   0 - n-1




        //runtime polymorphism
        List<String> ourClass = new ArrayList<>();
        ourClass.add("Tiffany");
        ourClass.add("Ahmad");
        ourClass.add("Alvin");

        List<String> tempList = new LinkedList<>();
        for (String str : ourClass) {
            tempList.add(str);
        }
        ourClass = tempList;

        //ourClass is now a reference to a linkedlist
        ourClass.forEach(happyfacesunhinetimes -> System.out.println(happyfacesunhinetimes));


//        //Exceptions:
//        try {
//            myPetJimmy.throwAnimalException(false);
//
//        } catch(AnimalException | AnotherException e) {
//            //we can totally nest exceptions into the catch blocks, we just have to handle them in their own try/catch
//            try {
//                throw new Exception("nested exception thrown inside try block!!!");
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        finally {
//            System.out.println("This is the finally block");
//        }

        String myString = "test";
        if(myString.equals("test")) {
            //this would be true!
        }

        Thingy myThingy = Thingy.THINGY;

        if(myThingy.equals(Thingy.THINGY)) {
            System.out.println("Thingy!!!");
        }

        List<List<Integer>> myListOfLists = new ArrayList<>();
        List<Integer> myIntList = new LinkedList<>();
        myListOfLists.add(myIntList);

        Scanner sc = new Scanner(System.in);
        //System.out.printf("Scanner stuff: \n\n\n\n\n\n\n Enter your name: ");
        //String name = sc.nextLine();

        //System.out.println("Your name is: " + name);
        //System.out.printf("Your name is: %s\n", name);
        System.out.printf("Some numbers: %s, %d, %f\n", "one", 1, 1.0f);
        System.out.printf("$%.2f\n", 55.55f);
        System.out.println("Account Bal: $" + 55.55f + ". Have a nice day!");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"));
            bw.write("Hello, world!\n");
            bw.write("This is a file called \n \\ \"file.txt\"\n");
            bw.close();

            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
            int count = 0;
            while(br.ready()) {
                count++;
                System.out.println(br.readLine());
            }
            System.out.println("count = " + count);
            br.close();


        } catch(Exception e) {
            e.printStackTrace();
        }

        int[][] sizeInitialized = new int[3][4];
        int[][] initializerList = new int[][]{
                {1,2,3},//0
                {4,5,6},//1
                {7,8,9},//2
                {55, 99, 134},//3
        };

        System.out.println(initializerList[0][0]);
        System.out.println(initializerList[1][1]);
        System.out.println(initializerList[3][2]);

    }
}
