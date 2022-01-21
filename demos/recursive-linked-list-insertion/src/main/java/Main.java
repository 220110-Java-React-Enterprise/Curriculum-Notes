import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String ...args) {
        //linked list
        //some group of items to add to that linked list
        //recursive method to fill the linked list with our items.

        List<String> oldList = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            oldList.add("String number " + i);
        }
        System.out.print("Old List: ");
        for (String str : oldList) {
            System.out.print(str + ". ");
        }
        System.out.println();

        Iterator<String> iter = oldList.iterator();

        //recursive function:
        //Need to have the same input parameters for each iteration
        List<String> newList =  RecursiveListCopier.copyList(oldList, iter);
        System.out.print("New List: ");
        for (String str : newList) {
            System.out.print(str + ". ");
        }
        System.out.println();

    }
}
