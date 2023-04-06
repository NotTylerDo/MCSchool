import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent {

	Property property1, property2, property3, property4, property5, property6;
	ManagementCompany m1Company, m2Company, m3Company, m4Company, copy;
	@BeforeEach
	void setUp() throws Exception {
		m1Company = new ManagementCompany("Company123", "777555333", 55.50);
		m2Company = new ManagementCompany();
		m3Company = new ManagementCompany("Starbucks", "12345", 15.00, 2, 2, 4, 5);
		copy = new ManagementCompany("CopyCat", "11111", 27.77);
		m4Company = new ManagementCompany(copy);
	}

	@AfterEach
	void tearDown() throws Exception {
		m1Company = null;
		
	}

	@Test
	void testAddProperty1() {
		assertEquals(m1Company.addProperty("Sunsational", "Beckman", 2613, "BillyBob Wilson"),0,0);
		assertEquals(m1Company.addProperty("House", "Germantown", 800.00, "Sang Nguyen"),1,0);
		assertEquals(-4,m1Company.addProperty("Pizza Hut", "Rockville", 450.00, "Bob"),0);
		assertEquals(-4, m1Company.addProperty("Building", "Rio", 3000.00, "CEO"),0);
		assertEquals(-4, m1Company.addProperty("Escape Room", "Town", 1100.00, "Guy"),0);
		assertEquals(-4, m1Company.addProperty("","",0.00,""),0);
	}
	
	@Test
	void testAddProperty2() {
		assertEquals(m1Company.addProperty("Sunsational", "Beckman", 2613, "BillyBob Wilson"),0,0);
		assertEquals(m1Company.addProperty("House", "Germantown", 800.00, "Sang Nguyen",1,1,1,1),1,0);
		assertEquals(2,m1Company.addProperty("Pizza Hut", "Rockville", 450.00, "Bob",2,2,1,1),0);
		assertEquals(3, m1Company.addProperty("Building", "Rio", 3000.00, "CEO",3,3,1,1),0);
		assertEquals(4, m1Company.addProperty("Escape Room", "Town", 1100.00, "Guy",4,4,1,1),0);
		assertEquals(-1, m1Company.addProperty("","",0.00,"",5,5,1,1),0);
	}
	
	@Test
	void testAddProperty3() {
		
		property1 = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson");		 
		assertEquals(m1Company.addProperty(property1),0,0);
		property2 = new Property ("House", "Germantown", 800.00, "Sang Nguyen", 1,1,1,1);
		assertEquals(m1Company.addProperty(property2),1,0);
		property3 = new Property ("Pizza Hut", "Rockville", 450.00, "Bob",2,2,1,1);
		assertEquals(2,m1Company.addProperty(property3),0);
		property4 = new Property("Building", "Rio", 3000.00, "CEO",3,3,1,1 );
		assertEquals(3, m1Company.addProperty(property4),0);
		property5 = new Property("Escape Room", "Town", 1100.00, "Guy",4,4,1,1 );
		assertEquals(4, m1Company.addProperty(property5),0);
		property6 = new Property();
		assertEquals(-1, m1Company.addProperty(property6),0);
		
		
	}
	
	//@Test
	//void testRemoveLastProperty() {
		//property1 = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson");		 
		//assertEquals(m1Company.addProperty(property1),0,0);
		//assertEquals(0, m1Company.removeLastProperty().getPropertiesCount());
	//}
	
	@Test
	void testIsPropertiesFull() {
		property1 = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson");		 
		assertEquals(m1Company.addProperty(property1),0,0);
		assertFalse(m1Company.isPropertiesFull());
		property2 = new Property ("House", "Germantown", 800.00, "Sang Nguyen", 1,1,1,1);
		assertEquals(m1Company.addProperty(property2),1,0);
		assertFalse(m1Company.isPropertiesFull());
		property3 = new Property ("Pizza Hut", "Rockville", 450.00, "Bob",2,2,1,1);
		assertEquals(2,m1Company.addProperty(property3),0);
		assertFalse(m1Company.isPropertiesFull());
		property4 = new Property("Building", "Rio", 3000.00, "CEO",3,3,1,1 );
		assertEquals(3, m1Company.addProperty(property4),0);
		assertFalse(m1Company.isPropertiesFull());
		property5 = new Property("Escape Room", "Town", 1100.00, "Guy",4,4,1,1 );
		assertEquals(4, m1Company.addProperty(property5),0);
		assertTrue(m1Company.isPropertiesFull());
		
	}
	
	@Test
	void testGetPropertiesCount() {
		property1 = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson");		 
		assertEquals(m1Company.addProperty(property1),0,0);
		assertEquals(1,m1Company.getPropertiesCount());
		property2 = new Property ("House", "Germantown", 800.00, "Sang Nguyen", 1,1,1,1);
		assertEquals(m1Company.addProperty(property2),1,0);
		assertEquals(2,m1Company.getPropertiesCount());
		property3 = new Property ("Pizza Hut", "Rockville", 450.00, "Bob",2,2,1,1);
		assertEquals(2,m1Company.addProperty(property3),0);
		assertEquals(3,m1Company.getPropertiesCount());
		property4 = new Property("Building", "Rio", 3000.00, "CEO",3,3,1,1 );
		assertEquals(3, m1Company.addProperty(property4),0);
		assertEquals(4,m1Company.getPropertiesCount());
		property5 = new Property("Escape Room", "Town", 1100.00, "Guy",4,4,1,1 );
		assertEquals(4, m1Company.addProperty(property5),0);
		assertEquals(5,m1Company.getPropertiesCount());
	}
	
	@Test
	void testTotalRent() {
		property1 = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson");		 
		assertEquals(m1Company.addProperty(property1),0,0);
		assertEquals(2613,m1Company.getTotalRent(),0);
		property2 = new Property ("House", "Germantown", 800.00, "Sang Nguyen", 1,1,1,1);
		assertEquals(m1Company.addProperty(property2),1,0);
		assertEquals(3413,m1Company.getTotalRent(),0);
		property3 = new Property ("Pizza Hut", "Rockville", 450.00, "Bob",2,2,1,1);
		assertEquals(2,m1Company.addProperty(property3),0);
		assertEquals(3863,m1Company.getTotalRent(),0);
		property4 = new Property("Building", "Rio", 3000.00, "CEO",3,3,1,1 );
		assertEquals(3, m1Company.addProperty(property4),0);
		assertEquals(6863,m1Company.getTotalRent(),0);
		property5 = new Property("Escape Room", "Town", 1100.00, "Guy",4,4,1,1 );
		assertEquals(4, m1Company.addProperty(property5),0);
		assertEquals(7963,m1Company.getTotalRent(),0);
	}
	
	@Test
	void testGetHighestRentProperty() {
		property1 = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson");		 
		assertEquals(m1Company.addProperty(property1),0,0);
		property2 = new Property ("House", "Germantown", 800.00, "Sang Nguyen", 1,1,1,1);
		assertEquals(m1Company.addProperty(property2),1,0);
		property3 = new Property ("Pizza Hut", "Rockville", 450.00, "Bob",2,2,1,1);
		assertEquals(2,m1Company.addProperty(property3),0);
		property4 = new Property("Building", "Rio", 3000.00, "CEO",3,3,1,1 );
		assertEquals(3, m1Company.addProperty(property4),0);
		property5 = new Property("Escape Room", "Town", 1100.00, "Guy",4,4,1,1 );
		assertEquals(4, m1Company.addProperty(property5),0);
		assertEquals(m1Company.getHighestRentProperty(),"Building,Rio,CEO,3000.0");
	}
	
	@Test
	void testIsManagementFeeValid() {
		assertTrue( m1Company.isManagementFeeValid());
		assertTrue(m2Company.isManagementFeeValid());
		assertTrue( m3Company.isManagementFeeValid());
		assertTrue(m4Company.isManagementFeeValid());
		assertTrue(copy.isManagementFeeValid());
	}
	
	@Test
	void testGetName() {
		assertEquals("Company123", m1Company.getName());
		assertEquals("",  m2Company.getName());
		assertEquals("Starbucks",  m3Company.getName());
		assertEquals("CopyCat", m4Company.getName());
		assertEquals("CopyCat", copy.getName());
	}
	
	@Test
	void testGetTaxID() {
		assertEquals("777555333", m1Company.getTaxID());
		assertEquals("",  m2Company.getTaxID());
		assertEquals("12345",  m3Company.getTaxID());
		assertEquals("11111", m4Company.getTaxID());
		assertEquals("11111", copy.getTaxID());
	}
	
	@Test
	void testGetProperties() {
		property1 = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson");		 
		assertEquals(m1Company.addProperty(property1),0,0);
		assertEquals("",m1Company.getProperties());
		property2 = new Property ("House", "Germantown", 800.00, "Sang Nguyen", 1,1,1,1);
		assertEquals(m1Company.addProperty(property2),1,0);
		property3 = new Property ("Pizza Hut", "Rockville", 450.00, "Bob",2,2,1,1);
		assertEquals(2,m1Company.addProperty(property3),0);
		property4 = new Property("Building", "Rio", 3000.00, "CEO",3,3,1,1 );
		assertEquals(3, m1Company.addProperty(property4),0);
		property5 = new Property("Escape Room", "Town", 1100.00, "Guy",4,4,1,1 );
		assertEquals(4, m1Company.addProperty(property5),0);
	}
	
	@Test
	void testGetMgmFeePer() {
		assertEquals(m1Company.getMgmFeePer(), 55.50, 0);
		assertEquals(m2Company.getMgmFeePer(), 0.0, 0);
		assertEquals(m3Company.getMgmFeePer(), 15.0,0);
		assertEquals(m4Company.getMgmFeePer(),27.77,0);
		assertEquals(copy.getMgmFeePer(),27.77,0);
	}
	
	@Test
	void testGetPlot() {
		assertEquals(0, m1Company.getPlot().getX());
		assertEquals(0, m1Company.getPlot().getY());
		assertEquals(10, m1Company.getPlot().getWidth());
		assertEquals(10, m1Company.getPlot().getDepth());
		
		assertEquals(0, m2Company.getPlot().getX());
		assertEquals(0, m2Company.getPlot().getY());
		assertEquals(10, m2Company.getPlot().getWidth());
		assertEquals(10, m2Company.getPlot().getDepth());
		
		assertEquals(2, m3Company.getPlot().getX());
		assertEquals(2, m3Company.getPlot().getY());
		assertEquals(4, m3Company.getPlot().getWidth());
		assertEquals(5, m3Company.getPlot().getDepth());
		
		assertEquals(0, m4Company.getPlot().getX());
		assertEquals(0, m4Company.getPlot().getY());
		assertEquals(10, m4Company.getPlot().getWidth());
		assertEquals(10, m4Company.getPlot().getDepth());
		
		assertEquals(0, copy.getPlot().getX());
		assertEquals(0, copy.getPlot().getY());
		assertEquals(10, copy.getPlot().getWidth());
		assertEquals(10, copy.getPlot().getDepth());
		
	}
	
	@Test
	void testToString() {
		///////
		property1 = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson");		 
		assertEquals(0,m1Company.addProperty(property1),0);
		assertEquals("List of the properties for Company123, 777555333\r\n"
				+ "Sunsational,Beckman,BillyBob Wilson,2613.0",m1Company.toString());
	
	}

}
