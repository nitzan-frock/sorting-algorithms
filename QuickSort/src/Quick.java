import java.util.Random;

/*
 * Project: QuickSort
 * Class: QuickSort
 * Author: Nitzan Frock
 * 
 * Description: Implementation of QuickSort algorithm.
 */
public class Quick {
	/*
	 * partition class takes in a list of Comparables, a, an integer, lo, for the partition,
	 * and an integer, hi, for the last element in the list. It will partition all the elements
	 * less than the partition to the left, and all the elements greater will be moved to the right.
	 * 
	 * The partitioning continues recursively until all the elements are sorted.
	 */
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi+1;
		
		while (true) {
			// scan from left to right while a[i] < a[lo]
			while (less(a[++i], a[lo])) {
				if (i == hi) break;
			}

			// scan from right to left while a[j] > a[lo]
			while (less(a[lo], a[--j])) {
				if (j == lo) break;
			}
			
			// check if pointers swap
			if (i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	
	public static void sort(Comparable[] a) {
		shuffle(a);
		sort(a, 0, a.length-1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
	private static void shuffle(Comparable[] a) {
		for (int i = a.length-1; i > 0; i--) {
			int j = (int) Math.floor(Math.random()*i);
			exch(a, i, j);
		}
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}
