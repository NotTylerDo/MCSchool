import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlcoholTestStudent {

	Alcohol alcoholOne, alcoholTwo;
	
	@BeforeEach
	void setUp() throws Exception {
		alcoholOne = new Alcohol("Beer", Size.MEDIUM, true);
		alcoholTwo = new Alcohol("Wine", Size.LARGE, false);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		alcoholOne = alcoholTwo = null;
	}

	@Test
	public void testCalcPrice() {
		assertEquals(3.60,alcoholOne.calcPrice(), 0.001);
		assertEquals(4.00,alcoholTwo.calcPrice(), 0.001);
	}
	
	@Test
	public void testEquals() {
		assertFalse(alcoholOne.equals(alcoholTwo));
	}
	
	@Test
	public void testIsWeekend() {
		assertTrue(alcoholOne.isWeekend());
		assertFalse(alcoholTwo.isWeekend());
	}
	
	

}
