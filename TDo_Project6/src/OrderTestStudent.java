import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTestStudent {

	Order orderOne, orderTwo, orderThree, orderFour;
	@BeforeEach
	void setUp() throws Exception {
		orderOne = new Order(8, Day.MONDAY, new Customer("Mary", 22));
		orderTwo = new Order(12, Day.SATURDAY, new Customer("John", 45));
		orderThree = new Order(10, Day.SUNDAY, new Customer("Kate", 22));
	}

	@AfterEach
	void tearDown() throws Exception {
		orderOne = orderTwo = orderThree = null;
	}

	@Test
	public void testAddNewBeverageAlcohol() {
		orderOne.addNewBeverage("n1", Size.LARGE);
	}
	
	@Test
	public void testAddNewBeverageCoffee() {
		orderTwo.addNewBeverage("n1", Size.MEDIUM, true, true);
	}
	
	@Test
	public void testAddNewBeverageSmoothie() {
		orderOne.addNewBeverage("n1", Size.SMALL, 4, false);
	}
	
	@Test
	public void testCompareTo() {
		orderOne.generateOrder();
		orderTwo.generateOrder();
		orderOne.addNewBeverage("n1", Size.LARGE);
		orderTwo.addNewBeverage("n1", Size.MEDIUM, true, true);
		// run this again, its likely to be -1 or 1
		assertEquals(-1, orderOne.compareTo(orderTwo));
	}
	
	@Test
	public void testFindNumOfBeveType() {
		orderOne.addNewBeverage("n1", Size.LARGE);
		orderOne.addNewBeverage("n1", Size.LARGE);
		orderOne.addNewBeverage("n1", Size.LARGE);
		assertEquals(3, orderOne.findNumOfBeveType(Type.ALCOHOL));
	}
	
	@Test
	public void testGenerateOrder() {
		orderOne.generateOrder();
		orderTwo.generateOrder();
	}
	
	@Test
	public void testGetBeverage() {
		orderOne.addNewBeverage("n1", Size.LARGE);
		orderOne.addNewBeverage("n2", Size.LARGE);
		assertTrue(orderOne.getBeverage(0).equals(orderOne.getBeverage(0)));
		assertFalse(orderOne.getBeverage(1).equals(orderOne.getBeverage(0)));
	}
	
	@Test
	public void testGetCustomer() {
		assertTrue(orderOne.getCustomer().equals(orderOne.getCustomer()));
		assertFalse(orderTwo.getCustomer().equals(orderOne.getCustomer()));
	}
	
	@Test
	public void testGetDay() {
		assertEquals(Day.MONDAY, orderOne.getDay());
	}
	
	@Test
	public void testGetOrderDay() {
		assertEquals(Day.MONDAY, orderOne.getOrderDay());
	}
	
	@Test
	public void testGetOrderNo() {
		int num = orderOne.generateOrder();
		assertEquals(num, orderOne.getOrderNo());
	}
	
	@Test
	public void testGetOrderTime() {
		assertEquals(8, orderOne.getOrderTime());
	}
	
	@Test
	public void testGetTotalItems() {
		orderOne.addNewBeverage("n1", Size.LARGE);
		orderOne.addNewBeverage("n1", Size.LARGE);
		orderOne.addNewBeverage("n1", Size.LARGE);
		assertEquals(3, orderOne.getTotalItems());
	}
	
	@Test
	public void testisWeekend() {
		assertFalse(orderOne.isWeekend());
		assertTrue(orderTwo.isWeekend());
	}

}
