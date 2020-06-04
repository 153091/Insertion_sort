/** %java InsertionSortX.java input.txt
 Note: InsertionSort.java uses unchecked or unsafe operations.
 Note: Recompile with -Xlint:unchecked for details.
 A E E L M O P R S T XElapsed time = 0.0

 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Comparator;

public class InsertionSortX {

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i<n; i++)
            for (int j = i; j>0; j--)
                if (less(a[j], a[j-1])) exch(a , j, j-1);
        assert isSorted(a);
    }

    //sort for Comparator
    public static void sort(Object[] a, Comparator comparator) {
        int n = a.length;
        for (int i=1; i<n; i++)
            for(int j=i; j>0 && less(a[j], a[j-1], comparator); j--)
                exch(a, j, j-1);
        assert isSorted(a, comparator);
    }


    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    //exch for Comparator
    private static void exch(Object[] a, int i, int j){
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w)<0;
    }

    //less for Comparartor
    private static boolean less(Object v, Object w, Comparator comparator){
        return comparator.compare(v, w)<0;
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i=1; i<a.length; i++)
            if(less(a[i], a[i-1])) return false;
            return true;
    }

    //isSorted for Comparator
    private static boolean isSorted(Object[] a, Comparator comparator){
        for (int i=1; i<a.length; i++)
            if (less(a[i], a[i-1], comparator)) return false;
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
