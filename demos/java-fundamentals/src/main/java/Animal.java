public abstract class Animal {//note here with no "extends" keyword, this class implicitly extends the Object class

    //note the use of protected keyword here. This is an access modifier like private and public.
    //protected means this is accessible by inheriting classes. private would mean it is only accessible
    // from within this file, and public means it's accessible anywhere.
    protected String name;
    protected String sound = "I'm some kind of animal?";

    //This is a constructor, note that it's name or identifier is in PascalCase,
    // just like the class name. The constructor MUST match the class name exactly.
    public Animal(String name) {
        //The use of the "this" keyword here refers to the class, and helps the compiler not be confused
        // by the two identifiers called "name"
        this.name = name;
    }

    public void makeSound(){
        System.out.println(sound);
    }

    public String getSound(){
        return sound;
    }

    public void throwAnimalException(boolean b) throws AnotherException, AnimalException {
        if(b) {
            AnimalException e = new AnimalException("AnimalException thrown");
            throw e;
        } else {
            throw new AnotherException("AnotherException thrown");
        }

    }
}
