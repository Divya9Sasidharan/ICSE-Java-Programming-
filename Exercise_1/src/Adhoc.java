import java.util.Scanner;

public class Adhoc{
    public static int sqdigitsum(int m) {
        // To implementation here
        int n, result=0;
        while(m > 0)
        {
            n = m % 10;
            result = (int) (result + Math.pow(n, 2));
            m = m / 10;
        }

        return result;
    }


    public static Boolean isHappy(int dec) {

        boolean happy=false;
                int sum=0;
         while (!happy ){
             sum=sqdigitsum(dec);
             dec=sum;
             System.out.println(sum);
             if (sum==1 ){
                 happy=true;
             }
             else if(sum<10)
             {
                 happy=false;
                 return false;
             }
         }
        return happy;
    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number ::");
        int num = input.nextInt();
        System.out.println(isHappy(num));
        //test cases

    }
}
