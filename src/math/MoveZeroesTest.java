package math;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoveZeroesTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		int[][] numsArry = { { 0, 1, 0, 0, 12, 0, 24 }, { 0, 1, 0, 3, 5 }, { 0, 1, 0, 3, 12 }, { 1, 0 }, { 2, 1 } };
		int[][] resultArry = {
				{1, 12, 24, 0, 0, 0, 0 },
				{1, 3, 5, 0, 0},
				{1, 3, 12, 0, 0 },
				{1, 0 },
				{2, 1 }};
		
		MoveZeroes mz = new MoveZeroes();
		for (int i = 0; i < numsArry.length; i++ ) {
			mz.moveZeroes(numsArry[i]);
			//assertEquals(resultArry[i],numsArry[i] );
			System.out.print("{");
			for (int n : numsArry[i]) {
				System.out.print( n + ", ");
			}
			System.out.println("},");
			
		}
		
	
		

	}

}
