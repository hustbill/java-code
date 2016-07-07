/**
 * 
 */
package architect;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author huazhang
 *
 */
public class TestTableCovertor {
	private static HashMap<String, Boolean[]> map;
	final static String[] operators = { "and", "and not", "or" };
	TableConvertor covertor = new TableConvertor();
	
    @Rule
    public ExpectedException thrown= ExpectedException.none();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testConvertCase1() {
		map = new LinkedHashMap<String, Boolean[]>();
		map.put("A", new Boolean[] { true, false, false });
		map.put("B", new Boolean[] { true, false, false });
		map.put("C", new Boolean[] { false, false, true });
		assertEquals("(A and B) or C", covertor.convertMapToExpression(map));
	}

	@Test
	public void testConvertCase2() {
		map = new HashMap<String, Boolean[]>();
		map.put("A", new Boolean[] { true, false, false });
		map.put("B", new Boolean[] { true, false, false });
		map.put("C", new Boolean[] { true, false, false });
		assertEquals("(A and B) and C", covertor.convertMapToExpression(map));
	}

	@Test
	 public void throwsException() {
	     thrown.expect(NullPointerException.class);
	     thrown.expectMessage("happened");
	     throw new NullPointerException("What happened?");
	 }
	
	@Test
	public void testConvertCase3() {
		map = new HashMap<String, Boolean[]>();
		map.put("A", new Boolean[] { true, false, false });
		map.put("B", new Boolean[] { true, false, false });
		map.put("C", new Boolean[] { false, false, true });
		map.put("D", new Boolean[] { false, true, false });
		map.put("E", new Boolean[] { false, true, false });		
		// arrange
	    thrown.expect(IllegalArgumentException.class);
	    thrown.expectMessage("Error: 'Not' has at most one");
	    // act
	    covertor.convertMapToExpression(map);
	    
	}
	
	// A or B and not C
	@Test
	public void testConvertCase4() {
		map = new HashMap<String, Boolean[]>();
		map = new HashMap<String, Boolean[]>();
		map.put("A", new Boolean[] { false, false, true });
		map.put("B", new Boolean[] { false, false, true });
		map.put("C", new Boolean[] { false, true, false });
		assertEquals("(A or B) and not C", covertor.convertMapToExpression(map));
	}
	

}
