/*
selection sort works by searching the array and looking for the lowest value that we haven't sorted yet.
Then we move that element to the start of the array, swapping places with the element there. Here's a breakdown
of the algorithm:

1. track the number of swaps we have made, - int swaps
2. Search the array for the lowest element - use temp variables
3. swap that element with the first element in the array
4. swaps++
5. search a sub-array bounded by swaps - n
6.    repeat this process until swaps == n

 */



public class IntegerSelectionSort {
    public static void sort(int[] array) {
        int tempInt;
        int indexOfLeastInt;

        for(int i = 0; i < array.length; i++) {
            indexOfLeastInt = i;

            for(int j = i; j < array.length; j++) {
                if(array[j] < array[indexOfLeastInt]) {
                    indexOfLeastInt = j;
                }
            }

            tempInt = array[i];
            array[i] = array[indexOfLeastInt];
            array[indexOfLeastInt] = tempInt;

        }

    }
}
