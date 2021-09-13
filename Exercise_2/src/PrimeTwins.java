import java.util.Arrays;
import java.util.Scanner;

public class PrimeTwins {
    public static boolean isPrime(int n) {
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

    public static int[][] primeTwins(int number) {
        int p=3;
        int q=p+2;
        int [][] prime_twins= new int[number][2];
        prime_twins[0][0]=p;
        prime_twins[0][1]=q;
        for (int i = 1; i <number; i++) {
            p=nextPrime(q);
            while (!isPrime(p)){
                p=nextPrime(p);
            }
            q=p+2;
            while (!isPrime(q)){
                p=nextPrime(q);
                q=p+2;
            }
            for (int j = 0; j < 2; j++) {
                if (j==0){
                    prime_twins[i][j]=p;
                }
                else {
                    prime_twins[i][j]=q;
                }
            }
            q=p+2;
        }
        return prime_twins;
    }
    public static int[][] primeTriplets(int n) {
        int i=0;
        int row=0;
        int [][] prime_triplets= new int[n][3];
        while (row <n){
            int p = i;
            int q = i + 2;
            int r = i + 6;
            if(isPrime(p) && isPrime(q) && isPrime(r)) {
                prime_triplets[row][0]=p;
                prime_triplets[row][1]=q;
                prime_triplets[row][2]=r;
                row++;
            }
            p = i;
            q = i + 4;
            r = i + 6;

            if(isPrime(p) && isPrime(q) && isPrime(r)) {
                prime_triplets[row][0]=p;
                prime_triplets[row][1]=q;
                prime_triplets[row][2]=r;
                row++;
            }
            i++;
        }

        return prime_triplets;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter size of array ::");
        int size = input.nextInt();
        System.out.println(Arrays.deepToString(primeTwins(size)));
        System.out.println(Arrays.deepToString(primeTriplets(size)));
    }
}
