package dfs;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ParlindromePartitionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
			ParlindromePartition pt = new ParlindromePartition();
			final String s = "aab";
			String[] arr1 = {"a", "a", "b"};
			String[] arr2 = {"aa","b"};
			List<String> list1 = Arrays.asList(arr1);
			List<String> list2 = Arrays.asList(arr2);
			
			List<List<String>> res = new ArrayList<List<String>>();
			res.add(list1);
			res.add(list2);
			
			assertEquals(res,  pt.partition(s));

		
	}

}
