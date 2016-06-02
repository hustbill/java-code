package javase;



import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyHashMapTest {

	MyHashMap<Object, Object> map = new MyHashMap<Object, Object>();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {

		map.put(1, 90);
		map.put(2, 95);
		map.put(17, 85);

		assertEquals(90, map.get(1));
		assertEquals(95, map.get(2));
		assertEquals(85, map.get(17));
		assertEquals(null, map.get(null));

	}

}
