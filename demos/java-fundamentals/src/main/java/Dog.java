public class Dog extends Animal{
    public Dog(String name){
        //super refers to the parent. If I wanted to invoke a parent member I could say super.methodName();
        //here we are referring to the constructor, we don't need to explicitly say so, super(); is a shortcut to refer to
        //the constructor for that class.
        super(name);
        sound = "Woof!";
    }

    @Override//This annotation is not explicitly required to override a method, this is syntactic sugar
    public void makeSound() {
        System.out.println(sound);
    }
}
