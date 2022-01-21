import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RecursiveListCopier {
    //recursive function:
    //Need to have the same input parameters for each iteration
    //What do we need for the first iteration?
        //we need the old list, the new list
    //What is our base case? when the iterator has run out of elements - hasNext() returns false


    public static LinkedList<String> copyList(List<String> source, Iterator<String> iter) {
        //I almost always have an if statement right at the top to check for and act on the base case
        if(!iter.hasNext()) {
            return new LinkedList<>();
        }

        String str = iter.next();
        LinkedList<String> temp = copyList(source, iter);//this is the recursion here, recalling this function again
        //now we wait
        temp.addFirst(str);
        return temp;

    }
}
