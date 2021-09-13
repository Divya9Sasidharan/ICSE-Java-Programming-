import java.util.Arrays;

/*********************************************************
 * reference:-https://www.geeksforgeeks.org/quick-sort/
 Insert your answers for subtasks 1 and two here

1)Explain how quicksort works on the example array int[] a = {5, 3, 4, 8, 7, 1, 2}. Write down the values of the array after each partitioning.

 a =        {5, 3, 4, 8, 7, 1, 2} pivot element = 5 --start---
 Indexes:    0  1  2  3  4  5  6

 a =        {2, 3, 4, 8, 7, 1, 5} pivot element = 5 -- swap --
 Indexes:    0  1  2  3  4  5  6

 a =        {2, 3, 4, 1, 7, 8, 5} pivot element = 5 -- swap --
 Indexes:    0  1  2  3  4  5  6

 a =        {2, 3, 4, 1, 7, 8, 5} pivot element = 2-- pivot update--
 Indexes:    0  1  2  3  4  5  6

 a =        {1, 3, 4, 2, 7, 8, 5} pivot element = 2 --swap--
 Indexes:    0  1  2  3  4  5  6

 a =        {1, 3, 4, 2, 7, 8, 5} pivot element = 3 -- pivot update--
 Indexes:    0  1  2  3  4  5  6

 a =        {1, 2, 4, 3, 7, 8, 5} pivot element = 3-- swap--
 Indexes:    0  1  2  3  4  5  6

 a =        {1, 2, 4, 3, 7, 8, 5} pivot element = 4 -- pivot update--
 Indexes:    0  1  2  3  4  5  6

 a =        {1, 2, 3, 4, 7, 8, 5} pivot element = 4 -- swap--
 Indexes:    0  1  2  3  4  5  6

 a =        {1, 2, 3, 4, 7, 8, 5} pivot element = 7 -- pivot update--
 Indexes:    0  1  2  3  4  5  6

 a =        {1, 2, 3, 4, 5, 8, 7} pivot element = 7 -- swap--
 Indexes:    0  1  2  3  4  5  6

 a =        {1, 2, 3, 4, 5, 8, 7} pivot element = 8 -- pivot update--
 Indexes:    0  1  2  3  4  5  6

 a =        {1, 2, 3, 4, 5, 7, 8} pivot element = 8-- swap--
 Indexes:    0  1  2  3  4  5  6


 2) Explain which complexity class quicksort belongs to (best case, worst case and average case). Discuss, how the choice of the pivot elements influences the number of required comparisons. Construct a worst case scenario.

 Worst Case: The worst case occurs when the partition process always picks greatest or smallest element as pivot.
 If we consider above partition strategy where first element is always picked as pivot,
 the worst case would occur when the array is already sorted in increasing or decreasing order.
 In that case one sub array will have 1 element and the other will have n-1 elements.
 Then complexity becomes O(n^2).

 Best Case: The best case occurs when the partition process always picks the middle element as pivot.O(nlog2n)

 Average complexity of quick sort: O(nlog2n)

 Pivot element influences the number of comparisons made as it can lead to the worst case scenario of complexity.
 worse cases
 [1,2,3,4,5,6,7,8,9,10] - when the array is sorted
 [10,9,8,7,6,5,4,3,2,1] - when the array is reversed
 [1,1,1,1,1,1,1,1,1,1] - when the array is the same values
 [1,1,1,2,2,2,3,3,3,3] - when there are few and unique keys
**********************************************************/


public class QuickSort {
    public static <T extends Comparable<T>> void quickSort(T[] a) {
        qsort(a, 0, a.length - 1);

    }
    private static <T extends Comparable<T>> void qsort(T[] a, int low, int high) {

        if (low < high) {
            int pi = partition(a, low, high);
            qsort(a, low, pi);
            qsort(a, pi+1 , high);
        }
    }

    private static <T extends Comparable<T>> int partition(T a[], int low, int high) {

        T pivot=a[low];
        int i = low -1;
        int j = high + 1;
        while (true) {
            do {
                j--;
            } while (a[j].compareTo(pivot) > 0);
            do {
                i++;
            }while (a[i].compareTo(pivot)<0);
            if (i < j) {
                T temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }else
                return j;
        }

    }

    public static boolean isSorted(Clock [] clocks) {
        int i;
        boolean result=true;
        System.out.println("isSorted(Clock [] clocks)"+Arrays.toString(clocks));
        for (i = 0; i < clocks.length-2; i++)
        {

            if (clocks[i].compareTo(clocks[i + 1]) > 0) {
                System.out.println("i "+i);
                System.out.println("compareTo i "+(clocks[i]));
                System.out.println("compareTo i+1 "+(clocks[i+1]));
                result=false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Clock[] c = new Clock[20];
        for (int j = 0; j < c.length; j++) {
            c[j] = new Clock((int) (Math.random() * 1000));
        }
        System.out.println("before quickSort(clocks)"+ Arrays.toString(c));
        quickSort(c);
        System.out.println("after quickSort(clocks)"+Arrays.toString(c));
        System.out.println(isSorted(c));

        Integer[] a_1 ;
        a_1 = new Integer[]{5, 3, 4, 8, 7, 1, 2};
        System.out.println("before quickSort(a)"+ Arrays.toString(a_1));
        quickSort(a_1);
        System.out.println("after quickSort(a)"+Arrays.toString(a_1));
    }
}