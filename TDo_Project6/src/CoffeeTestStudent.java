import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeTestStudent {

	Coffee c1;
	Coffee c2;
	@BeforeEach
	void setUp() throws Exception {
		c1 = new Coffee("N1", Size.SMALL, false, false);
		c2 = new Coffee("n1",Size.MEDIUM, true, false);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		c1 =c2 =null;
	}

	@Test
	public void testCalcPrice() {
		assertEquals(2.00, c1.calcPrice());
		assertEquals(3.50, c2.calcPrice());
	}
	
	@Test 
	public void testEquals() {
		assertFalse(c1.equals(c2));
	}
	
	@Test
	public void testGetExtraShot() {
		assertTrue(c2.getExtraShot());
		assertFalse(c1.getExtraShot());
	}
	
	@Test
	public void testGetExtraSyrup() {
		assertFalse(c2.getExtraSyrup());
		assertFalse(c1.getExtraSyrup());
	}
	
	

}
