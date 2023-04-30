
public class Customer {
	private String name;
	private int age;
	
	/**
	 * Create Customer object with given values
	 * @param name name
	 * @param age age
	 * */
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	/**
	 *  copy constructor
	 *  @param c Customer object to be copied 
	 * */
	public Customer(Customer c) {
		this.name = c.name;
		this.age = c.age;
	}
	
	/**
	 * Get method for age
	 * @return age age
	 * */
	public int getAge() {
		return age;
	}
	/**
	 * set method for age
	 * */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * get method for name
	 * @return name name
	 * */
	public String getName() {
		return name;
	}
	/**
	 * set method for name
	 * */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @Override
	 * String representation of customer object
	 * @return str string representation
	 * */
	public String toString() {
		String str = "";
		str += name + ", " + age;
		return str;
	}

}
