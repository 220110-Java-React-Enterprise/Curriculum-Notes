import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
         You are at a local youth soccer game. There are a bunch of children of all ages
         running around chasing a ball in a field. A giant Lovecraftian horror suddenly
         appears and begins to feast upon all the adorable little children. You have only a limited
         time to save as many children as possible, and you decide to try and save the youngest
         ones. You can save one child per minute and are given only K minutes. you will be given an
         array of length N which represents the soccer field full of children,
         and K minutes. Your goal is to search the array for the youngest children and save them by removing
         them from the array. After you have removed K children, the monster eats the rest.

         Remember, you want to save the youngest children.
         Write your answer in the Solution class.
         */

        //Constraints:
        //N will be a number between 50 and 100
        int N = (int)(Math.random() * 50) + 50;

        //K will be a number between 1 and 20
        int K = (int)(Math.random() * 19) + 1;

        //the array will contain N elements with values between 1 and 10.
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            arrayList.add((int)(Math.random() * 9) + 1);
        }

        System.out.println("This time there are "
                + N + " children and you have "
                + K + " minutes to save as many as you can!");

        Integer secret = SecretAnswer.secret(arrayList, N, K);
        Integer solution = Solution.problem(arrayList, N, K);



        System.out.println("You earned " + solution + " points! "
                + "The best possible score was " + secret
                +  " (Lower numbers are better!)\n");
        if(solution.equals(secret)) {
            System.out.println("You did it! You saved the youngest children possible!\n");
        } else {
            System.out.println("You saved some children, but with a better solution you may have made this tragedy a little less tragic. " +
                    "Remember you want to save the youngest children possible, so your score is as low as possible.");
        }
    }
}
