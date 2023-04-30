
public class Alcohol extends Beverage {
	
	private boolean isWeekend;
	
	/**
	 * Creates an Alcohol object using the given values
	 * @param bevName  beverage name
	 * @param size  beverage size
	 * @param isWeekend  whether the beverage is offered in the weekend
	 * */
	public Alcohol(String bevName, Size size, boolean isWeekend) {
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	
	/**
	 * @Override
	 * Calculates the price of the alcohol
	 * @return price  the price of the alcohol beverage
	 * */
	public double calcPrice() {
		double price;
		price = super.getBasePrice();
		if (super.getSize().equals(Size.MEDIUM)){
			price += super.addSizePrice();
		}
		else if (super.getSize().equals(Size.LARGE)) {
			price += super.addSizePrice();
			price += super.addSizePrice();
		}
		if (isWeekend)
			price += 0.60;
		return price;
	}
	
	/**
	 * @Override
	 * String representation of the alcohol beverage
	 * @return str string representation
	 * */
	public String toString() {
		String str = "";
		str += super.getBevName() + ", " + super.getSize() + ", ";
		if (isWeekend)
			str += "offered in weekend, ";
		else 
			str += "not offered in weekend, ";
		str += calcPrice();
		return str;
	}
	
	/**
	 * @Override
	 * Checks if this beverage equals to anotherBev
	 * @param anotherBev another beverage
	 * @return status whether the two beverages are the same
	 * */
	public boolean equals(Alcohol anotherBev) {
		boolean status = super.equals(anotherBev);
		if (status == true) {
			if (this.isWeekend != anotherBev.isWeekend)
				status = false;
			if (this.calcPrice() != anotherBev.calcPrice())
				status = false;
		}
		return status;
	}
	
	/**
	 * Checks if is weekend
	 * @return isWeekend  if it is weekend
	 * */
	public boolean isWeekend() {
		return isWeekend;
	}
	
	

}
