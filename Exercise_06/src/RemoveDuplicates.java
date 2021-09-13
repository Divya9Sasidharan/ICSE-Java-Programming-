/*
* Reference :- https://stacktips.com/tutorials/java/how-to-remove-duplicate-in-arraylist-using-comparator
* https://facingissuesonit.com/2019/03/21/java-how-to-remove-duplicate-objects-from-list/
* */

import java.util.*;
@SuppressWarnings("unchecked")


public class RemoveDuplicates {


    public static <T extends Comparable<T>> List<T> removeDuplicates(T[] input)
    {
        List<T> list ;
        list= new  ArrayList<T>(Arrays.asList(input.clone()));
        for (int i = 0; i < list.size(); i++)
        {
            for (int j = i+1; j < list.size(); j++)
            {
                if (list.get(i).compareTo(list.get(j))==0) {
                    list.remove(j);
                    j--;
                }
            }
        }

        return list;

    }

    public static <T> List<T> removeDuplicates_1(T[] input)
    {

        List<T> list = new ArrayList<T>(Arrays.asList(input.clone()));
        for (int i = 0; i < list.size(); i++)
        {
            for (int j = i+1; j < list.size(); j++)
            {

                if (list.get(i) == list.get(j)) {
                    list.remove(j);
                    j--;
                }
            }
        }
        return list;

    }


    public static void main(String[] args) {
        Integer[] a_1 ;
        a_1 = new Integer[]{5, 5, 4, 8, 1, 1, 2};
        System.out.println("before removing duplicates"+ Arrays.toString(a_1));
        System.out.println(removeDuplicates_1(a_1));
        System.out.println(removeDuplicates(a_1));
        String[] a_2 ;
        a_2 = new String[]{"a","b","c","a","c"};
        System.out.println("before removing duplicates"+ Arrays.toString(a_2));
        System.out.println(removeDuplicates_1(a_2));
        System.out.println(removeDuplicates(a_2));
    }

}
