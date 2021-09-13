
import java.util.Scanner;
@SuppressWarnings("unchecked")

public class HighLow {

    public static int guess(int low, int high) {
        Scanner scan = new Scanner(System.in);
        boolean numberguessed = true;
        int numberofRounds = 0;
        String i = null;
        int midpoint =0;
        while(numberguessed)
        {
            midpoint = (low+high)/2;
            numberofRounds++;
            System.out.println("Is your number " + midpoint + " please say lower or higher or correct");
            if (scan.hasNext()) {
                i = scan.next();
            }
            if (i.equalsIgnoreCase("higher")) {
                low = midpoint;
            }
            if (i.equalsIgnoreCase("lower")) {
                high = midpoint;
                low = 0;
            }
            if (i.equalsIgnoreCase("correct")) {
                System.out.println("the number of rounds in this game is" + numberofRounds);
                return midpoint;
            }
        }

    return midpoint;
    }

    public static void main(String[] args) {
        System.out.println("Think of a number");
        Scanner scan = new Scanner(System.in);
        int high = 0;
        int low = 0;

        //Get the input from the player
        System.out.println("Please your maximum value");

        if (scan.hasNext()) {
            high = scan.nextInt();
        }

        System.out.println("Please input your min value");
        if (scan.hasNext()) {
            low = scan.nextInt();
        }
        int result=guess(low,high);
        System.out.println("The number is "+result);



    }
}
