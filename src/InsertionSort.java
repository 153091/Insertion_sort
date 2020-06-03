/** %java InsertionSort.java input.txt
 Note: InsertionSort.java uses unchecked or unsafe operations.
 Note: Recompile with -Xlint:unchecked for details.
 A E E L M O P R S T XElapsed time = 0.0

 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class InsertionSort {

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i<n; i++)
            for (int j = i; j>0; j--)
                if (less(a[j], a[j-1])) exch(a , j, j-1);
        assert isSorted(a);
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w)<0;
    }
    private static boolean isSorted(Comparable[] a) {
        for (int i=1; i<a.length; i++)
            if(less(a[i], a[i-1])) return false;
            return true;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        String[] a = in.readAllStrings();
        sort(a);
        for (String s : a) StdOut.print(" " + s);
        Stopwatch sw = new Stopwatch();
        double time = sw.elapsedTime();
        StdOut.println("Elapsed time = " +time);
    }
}
