
public class Smoothie extends Beverage {
	private int numOfFruits;
	private boolean addProtein;
	
	/**
	 * Create smoothie object based on given values
	 * @param bevName beverage name
	 * @param size size
	 * @param numOfFruits number of fruits
	 * @param addProtein whether or not to add protein
	 * */
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}
	
	/**
	 * return number of fruits
	 * @return numOfFruits number of fruits
	 * */
	public int getNumOfFruits() {
		return numOfFruits;
	}
	
	/**
	 * return whether to add protein or not
	 * @return addProtein whether to add protein
	 * */
	public boolean getAddProtein() {
		return addProtein;
	}
	
	/**
	 * @Override 
	 * String representation of smoothie
	 * @return str string representation
	 * */
	public String toString() {
		String str = "";
		str += super.getBevName() + ", " + super.getSize() + ", ";
		if (addProtein)
			str += "added protein, ";
		str += numOfFruits + " fruits, ";
		str += calcPrice();
		return str;
	}
	
	/**
	 * @Override
	 * Calculates smoothie price
	 * @return price the smoothie price
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
		if (addProtein == true)
			price += 1.50;
		price += numOfFruits * 0.50;
		return price;
	}
	
	/**
	 * @Override
	 * Checks to see if two smoothies are equal
	 * @param anotherBev another beverage
	 * @return status whether two smoothies are equal
	 * */
	public boolean equals(Smoothie anotherBev) {
		boolean status = super.equals(anotherBev);
		if (status == true) {
			if (this.numOfFruits != anotherBev.numOfFruits)
				status = false;
			if (this.addProtein != anotherBev.addProtein)
				status = false;
			if (this.calcPrice() != anotherBev.calcPrice())
				status = false;
		}
		return status;
	}
	
}
