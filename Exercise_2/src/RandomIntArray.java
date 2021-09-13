
import java.util.Arrays;
import java.util.Scanner;

public class RandomIntArray {

    public static int[] createRandom(int n) {

        int rand_number[] = new int[n];
        // Each element of the array should be a random integer number from the range
        // [5,99]
        int max = 99;
        int min = 5;
        for (int i = 0; i < rand_number.length; i++) {
            // https://dzone.com/articles/random-number-generation-in-java
            // (Math.random() * ( max - min )) + min --> Standard expression for random
            // Numbers within a Given Range
            //First, multiply the magnitude of the range of values you want to cover by the result that Math.random() produces.
            //Step1-------
            //Math.random() * ( max - min ) returns a value in the range [0, max – min] where max is excluded.
            // For example, if you want [5,10], you need to cover 5 integer values so you can use Math.random()*5.
            // This would return a value in the range [0,5], where 5 is not included.
            //Step2-------
            // Next, shift this range up to the range that you are targeting. You do this by adding the min value.
            // (Math.random() * ( max - min )) + min
            //But this still does not include the maximum value.
            // step 3----
            //To get the max value included, you need to add 1 to your range parameter (max - min).
            // This will return a random double within the specified range.
            //step 4---
            // typecast to (int)
            rand_number[i] = (int) ((Math.random() * ((max - min) + 1)) + min);
        }
        return rand_number;
    }

    public static String toString(int[] a)
    {
        String a_new="[" + a[0];
        for (int i = 1; i < a.length; i++) {
            a_new+=", ";
            a_new+=a[i];
        }
        a_new+="]";
        return a_new;
    }

    public static int posMin(int[] a) {
        int min = a[0];
        int index=0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {//If that element occurs more than once in the array, TRUE only the first index.
                min = a[i];
                index = i;
            }
        }
        return index;
    }

    public static void swap(int[] a) {
        int temp = a[0];
        a[0] = a[a.length - 1];
        a[a.length - 1] = temp;
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter size of array ::");
        int size = input.nextInt();
        int[] array=createRandom(size);
        System.out.println(Arrays.toString(array));
        System.out.println(posMin(array));
        swap(array);
        int[] array_2=createRandom(size);
        String array_2_new=toString(array_2);
        if (array_2_new.equals(Arrays.toString(array_2)))
        {
            System.out.println("PASS");
        }
        else {
            System.out.println("FAIL");
        }

    }

}
