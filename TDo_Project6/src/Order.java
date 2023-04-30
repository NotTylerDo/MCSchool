import java.util.Random;
import java.util.ArrayList;

public class Order implements Comparable<Order>, OrderInterface {
	
	private int orderTime;
	private Day orderDay;
	private Customer cust;
	private int orderNo;
	private ArrayList<Beverage> bevList;
	
	/**
	 * Creates order object and initializes arraylist
	 * @param orderTime order time
	 * @param orderDay order day
	 * @param cust Customer object
	 * */
	public Order(int orderTime, Day orderDay, Customer cust) {
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = cust;
		bevList = new ArrayList<>();
	}
	
	/**
	 * automatically generates order number
	 * @return num order number
	 * */
	public int generateOrder() {
		Random rand = new Random();
		int num = rand.nextInt(80000) + 10000;
		orderNo = num;
		return num;
	}
	
	/**
	 * return order number 
	 * @return orderNo the order number
	 * */
	public int getOrderNo() {
		return orderNo;
	}
	
	/**
	 * return order time
	 * @return orderTime the order time
	 * */
	public int getOrderTime() {
		return orderTime;
	}
	
	
	/**
	 * return order day
	 * @return orderDay the order day
	 * */
	public Day getOrderDay() {
		return orderDay;
	}
	
	/**
	 * return customer 
	 * @return cust customer
	 * */
	public Customer getCustomer() {
		return cust;
	}
	
	/**
	 * return day
	 * @return orderDay order day
	 * */
	public Day getDay() {
		return orderDay;
	}
	

	/**
	 * Indicate whether it is the weekend
	 * @return status whether it is weekend
	 * */
	public boolean isWeekend() {
		boolean status = false;
		if (orderDay.equals(Day.SATURDAY) || orderDay.equals(Day.SUNDAY))
			status = true;
		return status;
	}
	
	/**
	 * Return beverage listed in item number of order
	 * @param itemNo the item number
	 * @return the beverage of the item number or nothing if it does not exist
	 * */
	public Beverage getBeverage(int itemNo) {
		if (bevList.size() == 0)
			return null;
		return bevList.get(itemNo);
	}
	
	/**
	 * returns the total number of beverages in order
	 * @return total number of beverages in order
	 * */
	public int getTotalItems() {
		return bevList.size();
	}
	
	/**
	 * Add coffee order to this order
	 * @param bevName beverage name
	 * @param size size
	 * @param extraShot whether there is extra shot
	 * @param extraSyrup whether there is extra syrup
	 * */
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
		bevList.add(coffee);
	}
	
	/**
	 * Add alcohol order to this order
	 * @param bevName beverage name
	 * @param size size
	 * */
	public void addNewBeverage(String bevName, Size size) {
		Alcohol alcohol = new Alcohol(bevName, size, isWeekend());
		bevList.add(alcohol);
	}
	
	/**
	 * Add smoothie order to this order
	 * @param bevName beverage name
	 * @param size size
	 * @param numOfFruits number of fruits
	 * @param addProtein whether there is protein added
	 * */
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addProtein);
		bevList.add(smoothie);
	}
	
	/**
	 * Calculates total amount of the order
	 * @return price total amount of the order
	 * */
	public double calcOrderTotal() {
		double price = 0.0;
		for (int i = 0; i < bevList.size(); i++) {
			price += bevList.get(i).calcPrice();
		}
		return price;
	}
	
	/**
	 * returns the number of beverages of the same type in order
	 * @param type the type
	 * @return counter the amount of times the beverage of the same type is in the order 
	 * */
	public int findNumOfBeveType(Type type) {
		int counter = 0;
		for (int i = 0; i < bevList.size(); i++) {
			if (bevList.get(i).getType().equals(type))
				counter++;
		}
		return counter;
	}
	
	/**
	 * @Override
	 * String representation of order
	 * @return str string representation
	 * */
	public String toString() {
		String str = "";
		str += getOrderNo() + ", " + getOrderTime() + ", " + getOrderDay()
		+ ", " + cust.toString() + ", ";
		for (int i = 0; i < bevList.size(); i++) {
			str += bevList.get(i).toString() + ", ";
		}
		return str;
	}
	
	/**
	 * @Override
	 * Compares two orders
	 * @param anotherOrder another order
	 * @return num value to represent comparison between two orders
	 * */
	public int compareTo(Order anotherOrder) {
		int num = 0;
		if (this.getOrderNo() < anotherOrder.getOrderNo())
			num = -1;
		else if (this.getOrderNo() > anotherOrder.getOrderNo())
			num = 1;
		return num;
	}
	
	

}
