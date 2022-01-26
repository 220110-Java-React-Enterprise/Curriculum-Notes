import sun.awt.image.ImageWatched;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /* streams */

//        List<String> stringList = new LinkedList<>();
//        stringList.add("Kyle");
//        stringList.add("Tiffany");
//        stringList.add("Cody");
//        stringList.add("Shabana");
//        stringList.add("Alvin");
//        stringList.add("Kai");
//        stringList.add("Cheryl");
//        stringList.add("Mahmood");
//        stringList.add("Ibrahima");
//
//        List<String> intermediateList1 = new LinkedList<>();
//        for (String s : stringList) {
//            if(s.contains("a")) {
//                intermediateList1.add(s);
//            }
//        }
//        List<String> intermediateList2 = new LinkedList<>();
//        for (String s : intermediateList1) {
//            if(s.length() >= 4){
//                intermediateList2.add(s);
//            }
//        }
//
//        intermediateList2.sort(Comparator.naturalOrder());
//        for (String s : intermediateList2) {
//            System.out.println(s);
//        }
//        intermediateList1 = null;
//        intermediateList2 = null;
//
//
//
//
//        stringList.stream()
//                .filter(s -> s.contains("a"))
//                .filter(s -> s.length() >= 4)
//                .sorted().forEach(s -> System.out.println(s));
//
//
//
//
//        List<Integer> intList = new ArrayList<Integer>();
//        intList.add(2);
//        intList.add(1);
//        intList.add(3);
//
//
//        Consumer<List<Integer>> doubleIt = (list) -> {
//            for (int i = 0; i < list.size(); i++)
//                list.set(i, 2 * list.get(i));
//        };
//
//        Consumer<List<Integer>> printList = (list) -> {
//            list.stream().forEach(a -> System.out.print(a + " "));
//        };
//
//        doubleIt.andThen(printList).accept(intList.stream().sorted().collect(Collectors.toList()));



        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(5);

        integerList.stream().forEach((i) -> System.out.println(i * 2));
        integerList.stream().forEach(Main::doubleIt);


    }

    public static void doubleIt(int a) {
        System.out.println(a * 2);
    }

    public void halfIt(int a) {
        System.out.println(a/2);
    }
}
