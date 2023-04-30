import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTestStudent {

	Customer c1;
	@BeforeEach
	void setUp() throws Exception {
		c1 = new Customer("Tyler Do", 19);
	}

	@AfterEach
	void tearDown() throws Exception {
		c1=null;
	}

	@Test
	public void testGetAge() {
		assertEquals(19, c1.getAge());
	}
	
	@Test
	public void testGetName() {
		assertEquals("Tyler Do", c1.getName());
	}
	
	@Test
	public void testSetName() {
		c1.setName("Bud");
		assertEquals("Bud", c1.getName());
	}
	
	@Test
	public void testSetAge() {
		c1.setAge(25);
		assertEquals(25, c1.getAge());
	}

}
