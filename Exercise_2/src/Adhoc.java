import java.util.Scanner;
import java.util.Arrays;

public class Adhoc{
    public static String [] fizzbuzz(int m, int n) {
        // To implementation here
        String [] a=new String[101];
        for (int i = 0; i <=100; i++) {
            if (i==0){
                System.out.println("do nothing");
                //a[i]=  "1";
            }
            else if (i%m==0 && i%n==0) {//If that element occurs more than once in the array, TRUE only the first index.
                 a[i]= "FIZZ BUZZ";
            }
            else if(i%m==0)
            {
                a[i]= "FIZZ";
            }
            else if ( i%n==0)
            {
                a[i]= "BUZZ";
            }

            else {
                a[i]= Integer.toString(i);
            }
        }
        String[] modifiedArray = Arrays.copyOfRange(a, 1, a.length);

        return modifiedArray;
    }






    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number ::");
        int num1 = input.nextInt();
        System.out.println("Enter a number ::");
        int num2 = input.nextInt();
        System.out.println(Arrays.toString(fizzbuzz(num1,num2)));
        //test cases

    }
}
