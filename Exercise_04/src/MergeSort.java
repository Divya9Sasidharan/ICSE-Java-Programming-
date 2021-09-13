/*
//reference:-http://www.learntosolveit.com/java/GenericQuickSort.html
            https://www.softwaretestinghelp.com/merge-sort-java/
 1) Explain the mergesort algorithm and how it works on the array int[] a = {5, 3, 4, 7, 1, 2}! Write down all intermediate steps.
 int[] a = {5, 3, 4, 7, 1, 2}

 Now according to the Merge sort algorithm, we will split this array at its mid element into two sub-arrays.
 Then we will continue splitting the sub-arrays into smaller arrays till we get a single element in each array.

Once each sub-array has only one element in it, we merge the elements.
 While merging, we compare the elements and ensure that they are in order in the merged array.
 So we work our way up to get a merged array that is sorted.
 {5, 3, 4, 7, 1, 2}----divide
 {5, 3, 4} {7, 1, 2}----divide
 {5} {3,4} {7} {1,2}----divide
 {5} {3} {4} {7} {1} {2}----divide
  {5} {3,4} {7} {1,2}-----merge+conquer
  {3,4,5} { 1, 2,7,}-----merge+conquer
  {1,2,3,4,5,7}-----merge+conquer

2)
    1)Explain the divide-and-conquer principle!

    The algorithm divides the array in two halves, recursively sorts them and finally merges the two sorted halves.
    Divide And Conquer have three parts:
    Divide: This involves dividing the problem into some sub problem.
    Conquer: Sub problem by calling recursively until sub problem solved.
    Combine: The Sub problem Solved so that we will get find problem solution.


    2)Does this version of mergesort require more, less or the same amount of memory compared to the algorithm presented in the lecture?
     Lecture - recursively divides the input list into smaller sublists until the sublists are trivially sorted, and then merges the sublists while returning up the call chain.
     The algorithm here we need additional array of same length as main array . hence amount of memory will be high.


3) Is the above version of mergesort stable? Justify your answer!
Merge sort is stable since sorting is done by insertion and not by swapping elements.

*/

import java.util.Arrays;
import java.util.Comparator;
@SuppressWarnings("unchecked")
public class MergeSort {

  public static <T> void mergeSort(T[] a, Comparator<T> c) {
    int na=a.length/2;
    int nb= a.length-na;
    T[] aLeft;
    aLeft = (T[])new Object[na];
    T[] aRight = (T[])new Object[nb];
    for (int i = 0; i < na; i++) {

      aLeft[i]=a[i];
    }
    System.out.println(Arrays.toString(aLeft));
    for (int j = 0; j <nb ; j++) {

      aRight[j]=a[j+na];
    }
    System.out.println(Arrays.toString(aRight));
    if (aLeft.length>1) mergeSort(aLeft,c);
    if (aRight.length>1) mergeSort(aRight,c);
    merge(aLeft,aRight,a,c);
  }
  static <T> void merge(T[] arrayLeft, T[] arrayRight, T[] arrayOut, Comparator<T> c) {
    int i = 0; // index subarray arrayLeft
    int j = 0; // index subarray arrayRight
    int k = 0; // index subarray arrayOut

    while (k < arrayOut.length) {
      if (i >= arrayLeft.length)
        arrayOut[k++] = arrayRight[j++];
      else if (j >= arrayRight.length)
        arrayOut[k++] = arrayLeft[i++];
      else if (c.compare(arrayLeft[i], arrayRight[j]) <= 0)
        arrayOut[k++] = arrayLeft[i++];
      else
        arrayOut[k++] = arrayRight[j++];
    }
    System.out.println("-----merge---");
    System.out.println(Arrays.toString(arrayOut));

  }

//-------------------------------------------------------------------//
  public static void main(String[] args) {
    String[] strings = { "Apple:100", "Apple:101","Banana", "Carrot", "Dumplings", "Egg", "Food" };
    MergeSort.mergeSort(strings, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if(o1.length() == o2.length())
          return 0;
        else if (o1.length()>o2.length())
          return 1;
        else
          return -1;
      }
    });
    System.out.println(Arrays.toString(strings));

    MergeSort.mergeSort(strings, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if(o1.length() == o2.length())
          return 0;
        else if (o1.length()>o2.length())
          return -1;
        else
          return 1;
      }
    });
    System.out.println(Arrays.toString(strings));
  }


}
