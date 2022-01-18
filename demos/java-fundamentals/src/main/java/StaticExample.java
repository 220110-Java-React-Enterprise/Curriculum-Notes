public class StaticExample {

    //note these fields are private, see comments about encapsulation below
    private static int staticInt = 5;
    private int nonStaticInt = 5;



    //Keep in mind the definition of encapsulation, which includes having a class be in charge of changes to its own internal state.
    //In this case we do this by making the fields private (so they cannot be manipulated by code outside this file) and we make
    //"getters" and "setters" public. In order to manipulate the classes' state, one must invoke these public methods.
    public int getStaticInt() {
        return staticInt;
    }

    public void setStaticInt(int staticInt) {
        StaticExample.staticInt = staticInt;
    }

    public int getNonStaticInt() {
        return nonStaticInt;
    }

    public void setNonStaticInt(int nonStaticInt) {
        this.nonStaticInt = nonStaticInt;
    }
}
