import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static Integer problem(ArrayList<Integer> arrayList, int N, int K) {

        //Write your code here



        //the monster eats the rest of the children in the Array List:
        //Note, the answer is the sum of ages of the remaining children.
        Integer yummyChildrenEaten = 0;
        for (Integer integer:arrayList) {
            yummyChildrenEaten += integer;
        }
        return yummyChildrenEaten;
    }
}
