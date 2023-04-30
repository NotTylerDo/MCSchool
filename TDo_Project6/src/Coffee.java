public class Coffee extends Beverage{
	private boolean extraShot;
	private boolean extraSyrup;
	
	/**
	 * Create a coffee object with given values
	 * @param bevName beverage name
	 * @param size the size
	 * @param extraShot whether there is an extra shot
	 * @param extraSyrup whether there is extra syrup
	 * */
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	/**
	 * Indicates whether there is an extra shot
	 * @return extraShot whether there is an extra shot
	 * */
	public boolean getExtraShot() {
		return extraShot;
	}
	
	/**
	 * Indicates whether there is extra syrup
	 * @return extraSyrup whether there is an extra syrup
	 * */
	public boolean getExtraSyrup(){
		return extraSyrup;
	}
	
	/**
	 * Calculates the price of the coffee
	 * @return price the price of the coffee
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
		if (extraShot)
			price+= 0.50;
		if (extraSyrup)
			price+=0.50;
		return price;
	}
	
	/**
	 * @Override
	 * String representation of the coffee order
	 * return str string representation
	 * */
	public String toString() {
		String str = "";
		str += super.getBevName() + ", " + super.getSize() + ", ";
		if (extraShot)
			str += "with extra shot, ";
		if (extraSyrup)
			str += "with extra syrup, ";
		str += calcPrice();
		return str;
	}
	
	/**
	 * @Override
	 * Checks if the two beverages are equal
	 * return status whether the two beverages are equal
	 * */
	public boolean equals(Coffee anotherBev) {
		boolean status = super.equals(anotherBev);
		if (status == true) {
			if (this.extraShot != anotherBev.extraShot)
				status = false;
			if (this.extraSyrup != anotherBev.extraSyrup)
				status = false;
			if (this.calcPrice() != anotherBev.calcPrice())
				status = false;
		}
		return status;
	}
}