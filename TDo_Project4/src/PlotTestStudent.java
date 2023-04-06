import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {
	private Plot plot1, plot2, plot3, plot4, plot5, plot6, plot7;
	
	
	@BeforeEach
	public void setUp() throws Exception {
		plot1 = new Plot(10, 10, 6, 6);
		plot2 = new Plot(1, 3, 4, 4);
		plot3 = new Plot();
		plot4 = new Plot(0, 0, 10, 10);
		plot5 = new Plot(2, 4, 4, 6);
		plot6 = new Plot(0,0,8,8);
		plot7 = new Plot(5,5,3,3);
		
	}
	
	@AfterEach
	void tearDown() throws Exception {
		plot1 = null;
		plot2 = null;
		plot3 = null;
		plot4 = null;
		plot5 = null;
	}

	@Test
	public void testOverlaps() {
		assertFalse(plot1.overlaps(plot5)); 
		assertFalse(plot1.overlaps(plot4));
		assertFalse(plot3.overlaps(plot2));
		assertTrue(plot2.overlaps(plot5));
		assertTrue(plot6.overlaps(plot7));
		
	}
	
	@Test
	public void testEncompasses() {
		assertFalse(plot1.encompasses(plot5));
		assertTrue(plot4.encompasses(plot3));
		assertTrue(plot4.encompasses(plot2));
		assertFalse(plot4.encompasses(plot1));
		assertTrue(plot4.encompasses(plot5));
	}
	
	@Test
	public void testGetX() {
		assertEquals(10,plot1.getX());
		assertEquals(1,plot2.getX());
		assertEquals(0,plot3.getX());
		assertEquals(0,plot4.getX());
		assertEquals(2,plot5.getX());
	}
	
	@Test
	public void testGetY() {
		assertEquals(10,plot1.getY());
		assertEquals(3,plot2.getY());
		assertEquals(0,plot3.getY());
		assertEquals(0,plot4.getY());
		assertEquals(4,plot5.getY());

	}
	
	@Test
	public void testGetWidth() {
		assertEquals(6,plot1.getWidth());
		assertEquals(4,plot2.getWidth());
		assertEquals(1,plot3.getWidth());
		assertEquals(10,plot4.getWidth());
		assertEquals(4,plot5.getWidth());

	}
	
	@Test
	public void testGetDepth() {
		assertEquals(6,plot1.getDepth());
		assertEquals(4,plot2.getDepth());
		assertEquals(1,plot3.getDepth());
		assertEquals(10,plot4.getDepth());
		assertEquals(6,plot5.getDepth());

	}
	
	@Test
	public void testToString() {
		assertEquals("10,10,6,6", plot1.toString());
		assertEquals("1,3,4,4", plot2.toString());
		assertEquals("0,0,1,1", plot3.toString());
		assertEquals("0,0,10,10", plot4.toString());
		assertEquals("2,4,4,6", plot5.toString());
	}

}
