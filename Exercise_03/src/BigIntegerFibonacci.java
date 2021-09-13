/***********************************************
 * // reference:-https://stackoverflow.com/questions/29617340/fibonacci-calculator-with-bigintegers
 * // reference:-  http://zetcode.com/java/fibonacci/
 * 2) Show how the number of function calls increases using the example fib1(5).
 * Explain what tree recursion is.
 * Provide your solution using the comment block at the top of the template file.
 *
 *
 * 		 Fibonacci of 5, n=5
 * 		 Function call: return value
 * 	    i=  0::1  The number of method calls :: 1
 *          1::1  The number of method calls :: 2
 *          2::2  The number of method calls :: 5
 *          3::3  The number of method calls :: 10
 *          4::5  The number of method calls :: 19
 *          5::8  The number of method calls :: 34
 *          
 *
 *
 * If a method call itself. This functionality is known as recursion.
 * two main requirements of a recursive function:
 *      A Stop Condition - the function returns a value when a certain condition is satisfied, without a further recursive call
 *      The Recursive Call - the function calls itself with an input
 ***********************************************/

import java.math.*;

public class BigIntegerFibonacci {
    static int counter = 0;
    static int itr = 0;
    public static BigInteger fib1(int n){
        counter++;
        if(n == 0 || n == 1){
            //System.out.println("n :: "+n);
            return BigInteger.ONE;
        }
        else
        {
            //System.out.println("n :: "+n);
            BigInteger n0=fib1(n - 1);
            //System.out.println("n1 :: "+n0+" n :: "+n);
            BigInteger n1=fib1(n - 2);
            //System.out.println("n1 :: "+n0+" n2 :: "+n1+" n :: "+n);
            return  n1.add(n0);
        }
    }

    public static BigInteger fib2(int n){

        if (n == 0 || n == 1) {
            //System.out.println("n :: "+n);
            //itr++;
            return BigInteger.ONE;
        }

        BigInteger n0 = BigInteger.ZERO, n1 = BigInteger.ONE, sum;

        for (int i = 2; i <=n+1; i++) {

            sum = n0.add(n1);
            n0 = n1;
            n1 = sum;
            itr++;
            //System.out.println("n0 :: "+n0+" n1 :: "+n1+" n :: "+n);
        }

        return n1;
    }
    public static void main(String[] args) {
        //  test scenarios
        for (int i = 0; i <15 ; i++) {
            System.out.println("Fibonacci value of recursive function fib1(i) for i= "+i+" is "+fib1(i));
            System.out.println("Fibonacci value of      loop function fib2(i) for i= "+i+" is "+fib2(i));
        }
        counter = 0;
        itr=0;
        System.out.println("++++++++++++++++  fib1 ++++++++++++++++++  ");
        for (int i = 0; i < 23; i++) {
            System.out.println((i)+" i  :: Fibonacci value is = "+fib1(i));
            System.out.println("The number of method calls :: "+counter);
            System.out.println("======================================= ");
        }

        System.out.println("++++++++++++++++++++  fib2 +++++++++++++++++++++++  ");
        for (int i = 0; i < 23; i++) {
            System.out.println((i)+" i  :: Fibonacci value is = "+fib2(i));
            System.out.println("The number of loop iterations for fib2 :: "+itr);
            System.out.println("======================================= ");
        }


    }

}