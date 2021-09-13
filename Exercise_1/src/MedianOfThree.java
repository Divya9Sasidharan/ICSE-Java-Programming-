import java.util.Scanner;
public class MedianOfThree {

  public static int median(int a, int b, int c) {

    /*
     * using logical conditions like && and ||
     */

    if ((b >=a && b <= c) || (b <= a && b >= c)) {
      return b;
    } else if ((c >= a && c <= b) || (c <= a && c >= b)) {
      return c;
    } else {
      return a;
    }
  }

  public static int median2(int a, int b, int c) {
    /*
     * more of sorting from largest to smallest only using '>'
     */
    if (a > b) {
      if (a > c) {
        if (b > c) {
          return b;
        } else {
          return c;
        }
      } else {
        return a;
      }
    } else {
      if (b > c) {
        if (a > c) {
          return a;
        } else {
          return c;
        }
      } else {
        return b;
      }
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Input first number: ");
    int num1 = in.nextInt();
    System.out.print("Input second number: ");
    int num2 = in.nextInt();
    System.out.print("Input third number: ");
    int num3 = in.nextInt();
    System.out.println("Median is: " + median(num1, num2, num3));
    System.out.println("Median2 is: " + median2(num1, num2, num3));
    //test cases
    int result = median(25, 11, 33);
    if (result==25) {
      System.out.println("PASS");
      
    } else {
      System.out.println("FAIL");
      
    }
    result = median(1, 1, 2);
    if (result==1) {
      System.out.println("PASS");
      
    } else {
      System.out.println("FAIL");
      
    }
    result = median2(2, 1, 1);
    if (result==1) {
      System.out.println("PASS");
      
    } else {
      System.out.println("FAIL");
      
    }

  }
}
