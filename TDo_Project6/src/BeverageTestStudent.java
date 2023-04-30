import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BeverageTestStudent {
	Alcohol b1;
	Smoothie b2;
	Coffee b3;
	
	@BeforeEach
	void setUp() throws Exception {
		b1 = new Alcohol("n1", Size.LARGE, false);
		b2 = new Smoothie("n2", Size.MEDIUM, 3, true);
		b3 = new Coffee("n3",Size.SMALL, true, true);
	}

	@AfterEach
	void tearDown() throws Exception {
		b1 =null;
		b2 =null;
		b3 = null;
	}

	@Test
	public void testAddSizePrice() {
		assertEquals(1.00, b1.addSizePrice());
	}
	
	@Test
	public void testCalcPrice() {
		assertEquals(4.00,b1.calcPrice());
		assertEquals(6.00,b2.calcPrice());
		assertEquals(3.00,b3.calcPrice());
	}
	
	@Test
	public void testEquals() {
		assertFalse(b1.equals(b2));
	}
	
	@Test 
	public void testGetBasePrice() {
		assertEquals(2.00,b1.getBasePrice());
	}
	
	@Test
	public void testGetBevName() {
		assertEquals("n1",b1.getBevName());
		assertEquals("n2",b2.getBevName());
		assertEquals("n3",b3.getBevName());
	}
	
	@Test
	public void testGetSize() {
		assertEquals(Size.LARGE, b1.getSize());
		assertEquals(Size.MEDIUM, b2.getSize());
		assertEquals(Size.SMALL, b3.getSize());
	}
	
	@Test
	public void testGetType() {
		assertEquals(Type.ALCOHOL, b1.getType());
		assertEquals(Type.SMOOTHIE, b2.getType());
		assertEquals(Type.COFFEE, b3.getType());
	}

}
