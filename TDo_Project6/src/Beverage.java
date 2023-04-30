
public abstract class Beverage extends Object{

	private final double BASE_PRICE = 2.0;
	private Type type;
	private String bevName;
	private Size size;
	private final double SIZE_PRICE = 1.0;
	
	/**
	 * Creates a beverage object using given values
	 * @param bevName name of beverage
	 * @param type the type of beverage
	 * @param size the size of the beverage
	 * */
	public Beverage(String bevName, Type type, Size size) {
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	
	/**
	 * Gets the base price
	 * @return BASE_PRICE the base price
	 * */
	public double getBasePrice() {
		return BASE_PRICE;
	}
	
	/**
	 * Gets the beverage type
	 * @return type the beverage type
	 * */
	public Type getType() {
		return type;
	}
	
	/**
	 * Gets the beverage name
	 * @return bevName the beverage name
	 * */
	public String getBevName() {
		return bevName;
	}
	
	/**
	 * Gets the beverage size
	 * @return size the beverage size
	 * */
	public Size getSize() {
		return size;
	}
	
	/**
	 * Calculate a new price by adding the size price
	 * @return SIZE_PRICE
	 * */
	public double addSizePrice() {
		//double newPrice;
		//newPrice = BASE_PRICE + SIZE_PRICE;
		return SIZE_PRICE;
	}
	
	/**
	 * @Override
	 * Represents a beverage object in string 
	 * @return str beverage object representation
	 * */
	public String toString() {
		String str = "";
		str += bevName + ", " + size;
		return str;
	}
	
	/**
	 * @Override
	 * Checks if this Beverage is equal to anotherBev
	 * @param anotherBev another beverage
	 * @return status whether or not the two beverages are equal
	 * */
	public boolean equals(Beverage anotherBev) {
		boolean status = false;
		if (this.bevName.equals(anotherBev.bevName))
			if (this.size.equals(anotherBev.size))
				if (this.type.equals(anotherBev.type))
					status = true;
		return status;
	}
	
	/**
	 * Calculates the beverage price
	 * @return   the price of the beverage
	 * */
	// Meant to be replaced
	public abstract double calcPrice(); 
}
