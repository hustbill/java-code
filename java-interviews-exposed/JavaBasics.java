import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class JavaBasics {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void finalReferenceChanges() {
		final int i = 42;
		//i = 43 ; // <- uncommeting this line would result in a compiler error
		// java.lang.Error: Unresolved compilation problem: 
		//The final local variable i cannot be assigned. 
		//It must be blank and not using a compound assignment

		

		
		final List<String>  list = new ArrayList<>(20);
		// list  = new ArrayList(50); // <- uncommeting this line would result in a compiler error
		assertEquals(0, list.size());
		
		list.add("adding a new value into my list");
		assertEquals(1, list.size());
		
		list.clear();
		assertEquals(0, list.size());
	
	}

}
