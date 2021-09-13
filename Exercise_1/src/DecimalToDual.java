import java.util.Scanner;

public class DecimalToDual {

  public static String transformToDual(int dec) {
    String base2Value = "";
    while (dec > 0) {
      if (dec % 2 == 0) {
        base2Value = 0 + base2Value;//writing in reverse order

      } else {
        base2Value = 1 + base2Value;//writing in reverse order
      }
      dec /= 2;

    }
    return base2Value;
  }

  

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a number ::");
    int num = input.nextInt();
    System.out.println("transformToDual output is: " + transformToDual(num));
    //test cases
    if (transformToDual(13).contentEquals("1101")) {
      System.out.println("PASS ");

    } else {
      System.out.println("FAIL ");

    }
  }
}
