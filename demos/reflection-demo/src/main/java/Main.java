import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


//DECLARED seems to mean ALL, getFields gets public fields, getDeclaredFields() gets everything.
public class Main {
    public static void main(String[] args) {
        Object obj = new CustomReflectiveClass();

        //Class name
        System.out.println("Class: ");
        String className = obj.getClass().getCanonicalName();
        System.out.println(className);

        //Parent class
        System.out.println("Parent: ");
        Class parentClass = obj.getClass().getSuperclass();
        System.out.println(parentClass);

        //Package
        System.out.println("Package: ");
        Package classPackage =  obj.getClass().getPackage();
        System.out.println(classPackage);

        //Constructors
        System.out.println("Constructors: ");
        Constructor[] constructors = obj.getClass().getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i]);
            Class[] parameters = constructors[i].getParameterTypes();
            for (int j = 0; j < parameters.length; j++) {
                System.out.println("   - parameter: " + parameters[j]);
            }
        }


        //Implemented Interfaces:
        System.out.println("Implemented Interfaces: ");
        Class[] interfaces = obj.getClass().getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            System.out.println(interfaces[i]);
        }

        //Fields
        System.out.println("Fields: ");
        Field[] fields = obj.getClass().getFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i]);
        }

        //Declared Fields
        System.out.println("Declared Fields: ");
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            System.out.println(declaredFields[i]);
        }

        //Methods
        System.out.println("Methods: ");
        Method[] methods = obj.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
            if(methods[i].isAnnotationPresent(CustomMethodAnnotation.class)) {
                System.out.println("   - Custom Annotation Present!!!");
            }

        }

        //Annotations
        System.out.println("Annotations: ");
        Annotation[] annotations = obj.getClass().getDeclaredAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);
        }

        //Is Annotation Present:
        System.out.println("Is the custom annotation present? ");
        boolean isAnnotationPresent = obj.getClass().isAnnotationPresent(CustomClassAnnotation.class);
        System.out.println(isAnnotationPresent);

        //What are declared classes? I think nested classes
        System.out.println("Declared Classes (Members?): ");
        Class[] classes = obj.getClass().getClasses();
        for (int i = 0; i < classes.length; i++) {
            System.out.println(classes[i]);
        }


    }
}
