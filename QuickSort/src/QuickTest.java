import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class QuickTest {

	@Test
	void testsort() {
		Integer[] a = new Integer[] {4,2,3,1,8,5,0,9,7,6};
		Integer[] result = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		Quick.sort(a);
		assertArrayEquals(result, a);
		
		int n = 100;
		Double[] a2 = new Double[n];
		for(int i = 0; i < n; i++) {
			a2[i] = Math.floor(Math.random()*99)+1;
		}
		Double[] result2 = Arrays.copyOf(a2, n);
		Arrays.sort(result2);
		Quick.sort(a2);
		assertArrayEquals(result2, a2);
	}
}
