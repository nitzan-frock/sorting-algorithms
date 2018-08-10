import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class QuickTest {

	@Test
	void testsort() {
		Integer[] a = new Integer[] {4,2,3,1,8,5,0,9,7,6};
		Integer[] result = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		Quick.sort(a);
		assertArrayEquals(result, a);
		
		String[] duplicates = new String[] {"a", "a", "b", "b", "c", "a", "a", "v", "b", "b", "b", "c", "c", "c", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"};
		String[] quickDupes = Arrays.copyOf(duplicates, duplicates.length);
		String[] resultDupes = Arrays.copyOf(duplicates, duplicates.length);
		
		long startTime = System.nanoTime();
		ThreeWayPartitioning.sort(duplicates);
		long endTime = System.nanoTime();
		double duplicatesTime = (double) Math.floor((endTime - startTime));
		
		long startTimeQuick = System.nanoTime();
		Quick.sort(quickDupes);
		long endTimeQuick = System.nanoTime();
		double resultTime = (double) Math.floor((endTimeQuick - startTimeQuick));

		
		System.out.println("quicksort: "+resultTime+ " 3-way-partition: " + duplicatesTime);
		assertArrayEquals(duplicates, quickDupes);
		
		for(String chr : duplicates) {
			System.out.print(chr+" ");
		}
		
		int n = 1000;
		Double[] a2 = new Double[n];
		for(int i = 0; i < n; i++) {
			a2[i] = Math.floor(Math.random()*10)+1;
		}
		
		Double[] result2 = Arrays.copyOf(a2, n);
		//Arrays.sort(result2);
		//Quick.sort(a2);
		//assertArrayEquals(result2, a2);
		
		long startTime2 = System.nanoTime();
		ThreeWayPartitioning.sort(a2);
		long endTime2 = System.nanoTime();
		double duplicatesTime2 = (double) Math.floor((endTime2 - startTime2));
		
		long startTimeQuick2 = System.nanoTime();
		Quick.sort(result2);
		long endTimeQuick2 = System.nanoTime();
		double resultTime2 = (double) Math.floor((endTimeQuick2 - startTimeQuick2));
		
		System.out.println("\nquicksort: "+resultTime2+ " 3-way-partition: " + duplicatesTime2);
		assertTrue(resultTime2 > duplicatesTime2);
	}
}
