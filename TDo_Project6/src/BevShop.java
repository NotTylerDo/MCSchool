import java.util.ArrayList;

public class BevShop implements BevShopInterface{
	private ArrayList<Order>orders;
	private int numOfAlcohol;
	private int index;
	
	/**
	 * Default constructor, initializes a BevShop object
	 * */
	public BevShop() {
		orders = new ArrayList<>();
	}
	
	/**
	 * Checks if the time is valid
	 * @param time the time
	 * @return   true if time is valid, otherwise false
	 * */
	public boolean isValidTime(int time) {
		if (time >= 8 && time <= 23)
			return true;
		else 
			return false;
	}
	
	/**
	 * Gets the constant value of the maximum number of fruits 
	 * @return MAX_FRUIT  the max amount of fruits
	 * */
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}
	
	/**
	 * Gets the constant value of the minimum age for alcohol 
	 * @return MIN_AGE_FOR_ALCOHOL  the min age for drinking alcohol
	 * */
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	/**
	 * Returns true if the passed parameter exceeds the max fruit allowed 
	 * @param numOfFruits number of fruits
	 * @return true if parameter exceeds max fruit, otherwise false
	 * */
	public boolean isMaxFruit(int numOfFruits) {
		if (numOfFruits > MAX_FRUIT)
			return true;
		else 
			return false;
	}
	
	/**
	 * Returns constant max number of alcohol beverages allowed
	 * @return MAX_ORDER_FOR_ALCOHOL  the max number of alcoholic beverages
	 * */
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	/**
	 * checks if the number of alcohol beverages for the current order has reached the max
	 * return true if number of alcoholic drinks for current order reached the max, otherwise false
	 * */
	public boolean isEligibleForMore() {
		if (numOfAlcohol >= MAX_ORDER_FOR_ALCOHOL)
			return true;
		else 
			return false;
	}
	
	/**
	 * Return the number of alcoholic drinks for the order
	 * @return getNumOfAlcoholDrink the number of alcohol drinks
	 * */
	public int getNumOfAlcoholDrink() {
		return numOfAlcohol;
	}
	

	/**
	 * Check the valid age for the alcohol drink
	 * @age the age 
	 * @return true if age is more than min age, false otherwise
	 * */
	public boolean isValidAge(int age) {
		if (age >= MIN_AGE_FOR_ALCOHOL)
			return true;
		else 
			return false;
	}

	/**
	 * Creates new order
	 * @param time time 
	 * @param day day
	 * @param customerName name of customer 
	 * @param customerAge age of customer
	 * */
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		Customer customer = new Customer(customerName, customerAge);
		Order order = new Order(time, day, customer);
		orders.add(order);
		index = orders.indexOf(order);
		
	}
	
	/**
	 * Processes coffee order
	 * @param bevName beverage name
	 * @param size the size
	 * @param extraShot whether there is an extra shot
	 * @param extraSyrup whether there is extra syrup
	 * */
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		orders.get(index).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	
	/**
	 * Process Alcohol order
	 * @param bevName beverage name
	 * @param size the size
	 * */
	public void processAlcoholOrder(String bevName, Size size) {
		orders.get(index).addNewBeverage(bevName, size);
		numOfAlcohol++;
	}
	
	/**
	 * Process smoothie order
	 * @param bevName beverage name
	 * @param size the size
	 * @param numOfFruits number of fruits
	 * @param addProtein whether protein was added
	 * */
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		orders.get(index).addNewBeverage(bevName, size, numOfFruits, addProtein);
	}
	
	/**
	 * locate an order based on order number
	 * @param orderNo the order number
	 * @return i the index of the order number if it exist
	 * */
	public int findOrder(int orderNo) {
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderNo() == orderNo)
				return i;
		}
		return -1;
	}
	
	/**
	 * locate an order in the list and returns total value of the order
	 * @param orderNo order number
	 * @return price the total value of the order
	 * */
	public double totalOrderPrice(int orderNo) {
		int index = findOrder(orderNo);
		double price = orders.get(index).calcOrderTotal();
		return price;
	}
	
	/**
	 * Calculates the total sales of all the orders in the shop
	 * @return sales the total sales
	 * */
	public double totalMonthlySale() {
		double sales = 0.0;
		for (int i = 0; i < orders.size(); i++) {
			sales += orders.get(i).calcOrderTotal();
		}
		return sales;
	}
	
	/**
	 * returns total number of orders
	 * @return total number of orders
	 * */
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}
	
	/**
	 * returns the current order 
	 * @return the current order in the current index
	 * */
	public Order getCurrentOrder() {
		return orders.get(index);
	}
	
	/**
	 * return order in the list at the index
	 * @return order at the index
	 * */
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}
	
	/**
	 * Sorts the order by selection sort
	 * */
	public void sortOrders() {
		int low;
	
		for (int i = 0; i < orders.size() - 1; i++) {
			low = i;
			for (int j = i+1; j < orders.size(); j++) {
				if (orders.get(j).getOrderNo() < orders.get(low).getOrderNo()) {
					low = j;
				}
			}
			Order tempOrder = orders.get(low);
			orders.set(low, orders.get(i));
			orders.set(i, tempOrder);
		}
	}
	
	/**
	 * @Override
	 * String representation of the order
	 * return str string representation
	 * */
	public String toString() {
		String str ="";
		for (int i = 0; i < orders.size(); i++) {
			str += orders.get(i).getOrderNo() + ", ";
		}
		str += "\n " + totalMonthlySale();
		return str;
	}
}
