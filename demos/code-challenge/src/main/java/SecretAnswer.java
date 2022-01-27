import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SecretAnswer {
    /*
    This is a reference solution. Looking at this is cheating!  :P
    This exists not only so you can take a look at it, but also to check your work.
    This will run my solution against the problem and produce the secret answer.
    You want your answer to be equal to mine.
     */

    public static Integer secret(ArrayList<Integer> arrayList, int N, int K) {
        List<Integer> copy = new ArrayList<>(arrayList);
        Collections.copy(copy, arrayList);
        Collections.sort(copy);
        for(int i = 0; i < K; i++) {
            copy.remove(0);
        }
        Integer munchMunchMunch = 0;
        for (Integer integer:copy) {
            munchMunchMunch += integer;
        }
        return munchMunchMunch;
    }
}
