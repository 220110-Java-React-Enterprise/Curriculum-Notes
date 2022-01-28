import java.net.HttpCookie;
import java.sql.Connection;

@CustomClassAnnotation(something = "thing")
public class CustomReflectiveClass {
    public static int pubStatInt;
    private static boolean privStatBool;
    protected char protChar;
    double defDouble;
    private HttpCookie privCookie;
    private final String privFinString;

    public CustomReflectiveClass() {
        protChar = 'A';
        privFinString = "";
    }

    public CustomReflectiveClass(String str) {
        privFinString = str;
    }

    @CustomMethodAnnotation(something = "thing")
    public static void pubStatVoidMethod(boolean bool) {
        privStatBool = bool;
    }

    @Override
    @CustomMethodAnnotation(something = "thing")
    public String toString() {
        return "CustomReflectiveClass{" +
                "protChar=" + protChar +
                ", defDouble=" + defDouble +
                ", privCookie=" + privCookie +
                ", privFinString='" + privFinString + '\'' +
                '}';
    }

    private class nestedClass {
        private int privNestedInt;
        public void setPrivInt(int i) {
            privNestedInt = i;
        }
    }


}
