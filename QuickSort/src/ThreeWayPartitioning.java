
public class ThreeWayPartitioning {
	
	public static void sort(Comparable[] a) {
		shuffle(a);
		sort(a, 0, a.length-1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		
		int lt = lo, gt = hi, i = lo;
		while(i <= gt) {			
			int cmp = a[i].compareTo(a[lt]);
			
			if (cmp < 0) exch(a, lt++, i++);
			else if (cmp > 0) exch(a, i, gt--);
			else i++;
		}
		sort(a, lo, lt-1);
		sort(a, gt+1, hi);
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
