import java.util.Scanner;

public class PrimeNumbers {

    public static boolean isPrime(int n) {
        /*
         * A prime number is a number which is divisible by only two numbers: 1 and
         * itself. So, if any number is divisible by any other number, it is not a prime
         * number.
         */
        boolean prime = true;
        if (n > 1) {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    prime = false;
                    break;
                }

            }
        }

        else {
            prime = false;
        }

        return prime;
    }

    public static int nextPrime(int n) {
        boolean prime = isPrime(n);
        if (prime) {
            return n;

        } else {

            boolean nextPrimeNo = false;
            while (!nextPrimeNo) {
                n++;
                nextPrimeNo = isPrime(n);
            }
            return n;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number ::");
        int num = input.nextInt();
        boolean primeTest = isPrime(num);
        if (primeTest) {
            System.out.println(num + " is a prime number");

        } else {
            System.out.println(num + " is  NOT a prime number");
        }
        System.out.println("Next prime number is: " + nextPrime(num));
        // test cases
        primeTest = isPrime(17);
        if (primeTest) {

            System.out.println("PASS");
        } else {

             System.out.println("FAIL");
        }
        int result=nextPrime(5);
        if (result==5) {

            System.out.println("PASS");
        } else {

             System.out.println("FAIL");
        }
        result=nextPrime(4);
        if (result==5) {

            System.out.println("PASS");
        } else {

             System.out.println("FAIL");
        }

    }

}