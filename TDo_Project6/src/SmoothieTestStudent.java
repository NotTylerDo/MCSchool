import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmoothieTestStudent {

	Smoothie s1, s2;
	@BeforeEach
	void setUp() throws Exception {
		s1 =new Smoothie("S1", Size.MEDIUM, 3, true);
		s2 = new Smoothie("S2", Size.LARGE, 0, false);
	}

	@AfterEach
	void tearDown() throws Exception {
		s1=s2=null;
	}

	@Test
	public void testCalcPrice() {
		assertEquals(6.00, s1.calcPrice());
		assertEquals(4.00, s2.calcPrice());
	}
	
	@Test
	public void testEquals() {
		assertFalse(s1.equals(s2));
	}
	
	@Test
	public void testAddProtein() {
		assertFalse(s2.getAddProtein());
		assertTrue(s1.getAddProtein());
	}
	
	@Test
	public void testGetNumOfFruits() {
		assertEquals(3, s1.getNumOfFruits());
		assertEquals(0, s2.getNumOfFruits());
	}

}
