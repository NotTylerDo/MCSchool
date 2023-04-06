import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {

	Property propertyOne, propertyTwo, propertyThree, propertyFour;
	@BeforeEach
	void setUp() throws Exception {
		propertyOne = new Property("Property ABC", "Rockville", 2450.00, "Wells Fargo Bank");
		propertyTwo = new Property();
		propertyThree = new Property("McDonalds", "Germantown", 1500.00, "McDad");
		propertyFour = new Property("BestBuy", "Gaithersburg", 3333.33, "Bill Gates Jr.", 3, 3, 7, 8);
	}

	@AfterEach
	void tearDown() throws Exception {
		propertyOne = null;
		propertyTwo = null;
		propertyThree = null;
		propertyFour = null;
	}

	@Test
	void testGetPlot() {
		assertEquals(0, propertyOne.getPlot().getX());
		assertEquals(0, propertyOne.getPlot().getY());
		assertEquals(1, propertyOne.getPlot().getWidth());
		assertEquals(1, propertyOne.getPlot().getDepth());
		
		assertEquals(0, propertyTwo.getPlot().getX());
		assertEquals(0, propertyTwo.getPlot().getY());
		assertEquals(1, propertyTwo.getPlot().getWidth());
		assertEquals(1, propertyTwo.getPlot().getDepth());
		
		assertEquals(0, propertyThree.getPlot().getX());
		assertEquals(0, propertyThree.getPlot().getY());
		assertEquals(1, propertyThree.getPlot().getWidth());
		assertEquals(1, propertyThree.getPlot().getDepth());
		
		assertEquals(3, propertyFour.getPlot().getX());
		assertEquals(3, propertyFour.getPlot().getY());
		assertEquals(7, propertyFour.getPlot().getWidth());
		assertEquals(8, propertyFour.getPlot().getDepth());
	}
	

	@Test
	void testGetPropertyName() {
		assertEquals("Property ABC", propertyOne.getPropertyName());
		assertEquals("", propertyTwo.getPropertyName());
		assertEquals("McDonalds", propertyThree.getPropertyName());
		assertEquals("BestBuy", propertyFour.getPropertyName());
		
		
	}

	@Test
	void testGetCity() {
		assertEquals("Rockville", propertyOne.getCity());
		assertEquals("", propertyTwo.getCity());
		assertEquals("Germantown", propertyThree.getCity());
		assertEquals("Gaithersburg", propertyFour.getCity());
	}

	@Test
	void testGetOwner() {
		assertEquals("Wells Fargo Bank", propertyOne.getOwner());
		assertEquals("", propertyTwo.getOwner());
		assertEquals("McDad", propertyThree.getOwner());
		assertEquals("Bill Gates Jr.", propertyFour.getOwner());
	}

	@Test
	void testGetRentAmount() {
		assertEquals(2450.00, propertyOne.getRentAmount());
		assertEquals(0.0, propertyTwo.getRentAmount());
		assertEquals(1500.00, propertyThree.getRentAmount());
		assertEquals(3333.33, propertyFour.getRentAmount());
		
	}

	@Test
	void testToString() {
		assertEquals("Property ABC,Rockville,Wells Fargo Bank,2450.0", propertyOne.toString());
		assertEquals(",,,0.0", propertyTwo.toString());
		assertEquals("McDonalds,Germantown,McDad,1500.0", propertyThree.toString());
		assertEquals("BestBuy,Gaithersburg,Bill Gates Jr.,3333.33", propertyFour.toString());
		
	}

}
