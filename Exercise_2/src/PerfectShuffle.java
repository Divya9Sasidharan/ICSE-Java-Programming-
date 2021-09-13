import java.util.Arrays;
public class PerfectShuffle {

  public static int[] interleave(int[] a1, int[] a2) {
    int[] interleave_data = new int[(a1.length + a2.length)];
    int i=0;
    int j=0;
    for (int k = 0; k < interleave_data.length; k++) {
      if(k % 2 != 0) {
        interleave_data[k] = a2[j];
        j++;
      }
      else
      {
        interleave_data[k] = a1[i];
        i++;
      }
    }
    return interleave_data;
  }

  public static int[] perfectShuffle(int[] a) {
    int[] perfect_shuffle = a;
    int l = a.length;
    if (l%2==0) // input array is even
    {
      int[] a1 = Arrays.copyOfRange(a, 0, (l + 1)/2);
      int[] a2 = Arrays.copyOfRange(a, (l + 1)/2, l);
      perfect_shuffle=interleave(a1,a2);
    }
    return perfect_shuffle;
  }

  public static int shuffleNumber(int n) {
    if (n % 2 != 0)
      return -1;
    int [] a=new int[n];
    int count=1;
    for (int i=0;i <n;i++){
      a[i]=i;
    }
    int[] a3=perfectShuffle(a);//Each array has to be shuffled at least once!
    while(!Arrays.equals(a,a3))
    {
      a3=perfectShuffle(a3);
      count++;
    }
    return count;
  }


  public static void main(String[] args) {
    if (shuffleNumber(8) == 3)
      System.out.println("true");
    if (shuffleNumber(24) == 11)
      System.out.println("true");
    if (shuffleNumber(52) == 8)
      System.out.println("true");
    if (shuffleNumber(3) == -1)
      System.out.println("true");
    if (shuffleNumber(100) == 30)
      System.out.println("true");
    if (shuffleNumber(1020) == 1018)
      System.out.println("true");
    if (shuffleNumber(1024) == 10)
      System.out.println("true");
    if (shuffleNumber(10000) == 300)
      System.out.println("true");
  }
}
