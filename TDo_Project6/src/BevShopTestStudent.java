import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BevShopTestStudent {

	BevShop bevShop;
	@BeforeEach
	void setUp() throws Exception {
		bevShop = new BevShop();
		bevShop.startNewOrder(9, Day.TUESDAY, "Tyler", 25);
		bevShop.processCoffeeOrder("Latte", Size.MEDIUM, false, false);
		bevShop.processAlcoholOrder("Wine", Size.LARGE);
		bevShop.processSmoothieOrder("Blueberry punch", Size.SMALL, 2, false);
	}

	@AfterEach
	void tearDown() throws Exception {
		bevShop = null;
	}

	@Test
	public void testFindOrder() {
		int orderNum;
		orderNum = bevShop.getCurrentOrder().getOrderNo();
		
		assertEquals(0, bevShop.findOrder(orderNum));
	}
	
	@Test
	public void testGetCurrentOrder() {
		assertEquals(bevShop.getOrderAtIndex(0), bevShop.getCurrentOrder());
	}
	
	@Test
	public void testGetMaxNumOfFruits() {
		assertEquals(5, bevShop.getMaxNumOfFruits());
	}
	
	@Test
	public void testGetMaxOrderForAlcohol() {
		assertEquals(3, bevShop.getMaxOrderForAlcohol());
	}
	
	@Test 
	public void testGetMinAgeForAlcohol() {
		assertEquals(21, bevShop.getMinAgeForAlcohol());
	}
	
	@Test
	public void testGetNumOfAlcoholDrink() {
		assertEquals(1, bevShop.getNumOfAlcoholDrink());
	}
	
	@Test
	public void testGetOrderAtIndex() {
		assertEquals(bevShop.getCurrentOrder(), bevShop.getOrderAtIndex(0));
	}
	
	@Test
	public void testIsEligibleForMore() {
		assertFalse( bevShop.isEligibleForMore());
	}
	
	@Test
	public void testIsMaxFruit() {
		assertFalse( bevShop.isMaxFruit(3));
	}
	
	@Test
	public void testIsValidAge() {
		assertTrue( bevShop.isValidAge(25));
		assertFalse( bevShop.isValidAge(19));
	}
	
	@Test
	public void testIsValidTime() {
		assertFalse( bevShop.isValidTime(25));
		assertTrue( bevShop.isValidTime(20));
	}
	
	@Test
	public void testTotalMonthlySale() {
		assertEquals(10.00, bevShop.totalMonthlySale());
	}
	
	@Test
	public void testTotalNumOfMonthlyOrders() {
		assertEquals(3, bevShop.totalNumOfMonthlyOrders());
	}
	
	@Test 
	public void testTotalOrderPrice() {
		assertEquals(10.00, bevShop.totalOrderPrice(0));
	}

}
