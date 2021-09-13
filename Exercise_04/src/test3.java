import java.util.Arrays;

public class test3 {
    //-----------------------------------------------------------------//
// helper methods for recursive sorting by merging sorted arrays
    private static void _mergeSort(String a[], String copy[], int start, int end) {
        if (start < end) {
            //System.out.println(Arrays.toString(a));
            //System.out.println(Arrays.toString(copy));
            int mid = (start + end) / 2;
            _mergeSort(a, copy, start, mid);
            _mergeSort(a, copy, mid + 1, end);
            merge(a, copy, start, mid, end);
        }
    }

    //-----------------------------------------------------------------//
    private static void merge(String a[], String copy[], int start, int m, int end) {

        int i = 0, j = start, k;
        while (j <= m)
            copy[i++] = a[j++];
        i = 0;
        k = start;
        while (k < j && j <= end) {
            if (copy[i].length() <=a[j].length())
                a[k++] = copy[i++];
            else
                a[k++] = a[j++];
        }
        while (k < j)
            a[k++] = copy[i++];
        //System.out.println("----merge-----");
        //System.out.println(Arrays.toString(a));
        //System.out.println(Arrays.toString(copy));
    }

    //-----------------------------------------------------------------//
    public static  void mergeSort(String[] a) {
        //System.out.println(Arrays.toString(a));
        _mergeSort(a, new String[a.length], 0, a.length - 1);
    }
    public static void main(String[] args) {
        String[] strings = { "Apple:101", "Apple:100","Banana", "Carrot", "Dumplings", "Egg", "Food" };
        mergeSort(strings);
        System.out.println(Arrays.toString(strings));
    }
}
