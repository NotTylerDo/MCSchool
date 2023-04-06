/*
Class: CMSC203  
Instructor: Gary Thai 
Description: Create classes where a property management company manages individual properties they will build to rent,
 and charges them a management fee as the percentages of the monthly rental amount. The properties cannot overlap with each other, 
 and each property must be within the limits of the management company’s plot. 
 Write an application that lets the user create a management company and adds the properties managed by the company to its list.  
Due: 04/07/2023 
Platform/compiler: Eclipse 
I pledge that I have completed the programming assignment independently. 
I have not copied the code from a student or any source. I have not given my code to any student. 
Tyler Do  
 * */
public class ManagementCompany {

	public static final int MAX_PROPERTY = 5;
	public static final int MGMT_WIDTH = 10;
	public static final int MGMT_DEPTH = 10;
	private Plot plot;
	private String name;
	private String taxID;
	private double mgmFee;
	private Property[] properties;
	private int numberOfProperties;
	
	/**
	 * Creates a ManagementCompany object using empty strings, 
	 * creates a default Plot with maximum width and depth and 
	 * it initializes the properties array.
	 * */
	public ManagementCompany() {
		name = "";
		taxID = "";
		mgmFee = 0.0;
		plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
	/**
	 * Creates a ManagementCompany object using the given values, 
	 * creates a default Plot with maximum width and depth and it 
	 * initializes the properties array.
	 * @param name   company name
	 * @param taxID   tax ID
	 * @param mgmFee   management fee
	 * */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
	/**
	 *Creates a ManagementCompany object using the given values creates a 
	 *Plot using the given values and it initializes the properties array.
	 * This constructor should call an appropriate existing constructor.
	 * @param name   company name
	 * @param taxID   tax ID
	 * @param mgmFee   management fee
	 * @param x    x coordinate of plot
	 * @param y    y coordinate of plot
	 * @param width    the width of plot
	 * @param depth    the depth of plot
	 * */
	public ManagementCompany(String name, String taxID, double mgmFee,
							int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		plot = new Plot(x,y,width,depth);
		properties = new Property[MAX_PROPERTY];	
	}
	
	/**
	 * Creates a new ManagementCompany copy of the given ManagementCompany.
	 *  This constructor should call an appropriate existing constructor.
	 *  @param otherCompany    the ManagementCompany object to be copied from
	 * */
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFee = otherCompany.mgmFee;
		this.plot = otherCompany.plot;
		this.properties = otherCompany.properties;
	
	}
	
	/**
	 * Adds a new property to the properties array, this method should call an 
	 * appropriate existing overloaded method.
	 * @param name  property name
	 * @param city   city where the property is located
	 * @param rent   rent amount
	 * @param owner    the owner's name
	 * @return -1  if the array is full
	 * @return -2  if the property object is null
	 * @return -3  if the management company does not encompass the property plot
	 * @return -4  if the property plot overlaps any properties in array
	 * @return value   if the property was successfully added
	 * */
	public int addProperty(String name, String city, double rent, String owner) {
		Property property = new Property(name, city, rent, owner);
		int index = 0;
		int value = 0;
		
		
		for (int i = 0; i < getPropertiesCount(); i++) {
		if (isPropertiesFull()) {
			value = -1;
		}
		else if (property.equals(null)) {
			value = -2;
		}
		else if (!(plot.encompasses(property.getPlot()))) {
			value = -3;
		}
		
		else if (property.getPlot().overlaps(properties[i].getPlot())) 
			{
			value = -4;
			}
		
		}
		while (index < MAX_PROPERTY ) {
			if ((properties[index] == (null))) {
				properties[index] = property;
				break;
			}
			else 
				index++;
			
		} 
		if (value < 0)
			removeLastProperty();
		else
			value = index;
		return value;
	}
	
	
	/**
	 * Adds a new property to the properties array, this method should call an 
	 * appropriate existing overloaded method.
	 * @param name  property name
	 * @param city   city where the property is located
	 * @param rent   rent amount
	 * @param owner    the owner's name
	 * @param x    x coordinate of plot
	 * @param y    y coordinate of plot
	 * @param width   width of plot
	 * @param depth   depth of plot
	 * @return -1  if the array is full
	 * @return -2  if the property object is null
	 * @return -3  if the management company does not encompass the property plot
	 * @return -4  if the property plot overlaps any properties in array
	 * @return value   if the property was successfully added
	 * */
	public int addProperty(String name, String city, double rent, String owner,
							int x, int y, int width, int depth) {
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		int index = 0;
		int value = 0;
		
		
		
		for (int i = 0; i < getPropertiesCount(); i++) {
		if (isPropertiesFull()) {
			value = -1;
		}
		else if (property.equals(null)) {
			value = -2;
		}
		else if (!(plot.encompasses(property.getPlot()))) {
			value = -3;
		}
		
		else if (property.getPlot().overlaps(properties[i].getPlot())) 
		 {
			value = -4;
			}
		
		}
		while (index < MAX_PROPERTY ) {
			if ((properties[index] == (null))) {
				properties[index] = property;
				break;
			}
			else 
				index++;
			
		} 
		if (value < 0)
			removeLastProperty();
		else
			value = index;
		return value;
	}
	
	
	/**
	 * Creates a property object by copying from another property and adds it to the properties array.
	 * @param property   property object to copy from
	 * @return -1  if the array is full
	 * @return -2  if the property object is null
	 * @return -3  if the management company does not encompass the property plot
	 * @return -4  if the property plot overlaps any properties in array
	 * @return value   if the property was successfully added
	 * */
	public int addProperty(Property property) {
		Property copy = new Property(property);
		int index = 0;
		int value = 0;
		
		
		
		for (int i = 0; i < getPropertiesCount(); i++) {
		if (isPropertiesFull()) {
			value = -1;
		}
		else if (copy.equals(null)) {
			value = -2;
		}
		else if (!(plot.encompasses(copy.getPlot()))) {
			value = -3;
		}
		
		else if (copy.getPlot().overlaps(properties[i].getPlot())) 
			{
				value = -4;
			}
		
		}
		while (index < MAX_PROPERTY ) {
			if ((properties[index] == (null))) {
				properties[index] = copy;
				break;
			}
			else 
				index++;
			
		} 
		if (value < 0)
			removeLastProperty();
		else
			value = index;
		return value;
	}
	
	/**
	 * Removes(nullifies) the LAST property in the properties array
	 * */
	public void removeLastProperty() {
		
		int i = getPropertiesCount()-1;
		properties[i]=null;
		
		
	}
	
	/**
	 * Checks if the properties array has reached the maximum capacity
	 * @return true    if properties array is full
	 * @return false    otherwise
	 * */
	public boolean isPropertiesFull() {
	
		if (getPropertiesCount() == MAX_PROPERTY)
			return true;
		else 
			return false;
			
	}
	
	/**
	 * Gets the number of existing properties in the array
	 * @return numberOfProperties    the number of existing properties in array
	 * */
	public int getPropertiesCount() {
		int nullAmount = 0;
		for (int i = 0; i< MAX_PROPERTY; i++) {
			if (properties[i] == null) {
				nullAmount++;
			}
		}	
		numberOfProperties =  MAX_PROPERTY - nullAmount;
		return numberOfProperties;
	} 
	
	/**
	 * Gets the total amount of rent of the properties in the array
	 * @return total   the total rent
	 * */
	public double getTotalRent() {
		double total = 0.0;
		
		for (int i = 0; i < getPropertiesCount(); i++) {
			total += properties[i].getRentAmount();
		}
		return total;
	}
	
	/**
	 * Gets the property in the array with the maximum amount of rent
	 * @return properties[highestIndex]   the property with the highest amount of rent
	 * */
	public Property getHighestRentProperty() {
		int highestIndex = 0;
		for (int i = 0; i < getPropertiesCount(); i++) {
			if (properties[i].getRentAmount() > properties[highestIndex].getRentAmount() )
				highestIndex = i;
		}
		return properties[highestIndex];
	}
	
	/**
	 * Checks if the management company has a valid (between 0-100) fee
	 * return true    if the management fee is valid
	 * return false   otherwise
	 * */
	public boolean isManagementFeeValid() {
		if (mgmFee >= 0 && mgmFee <= 100)
			return true;
		else
			return false;
	}
	
	/**
	 * Gets the name
	 * @return name  the name
	 * */
	public String getName() {
		return name;
	}
	/**
	 * Gets the tax ID
	 * @return taxID  the tax ID
	 * */
	public String getTaxID() {
		return taxID;
	}
	
	/**
	 * Gets the properties
	 * @return properties  the properties
	 * */
	public Property[] getProperties() {
		return properties;
	}
	
	/**
	 * Gets the management fee per
	 * @return mgmFee  the management fee per
	 * */
	public double getMgmFeePer() {
		return mgmFee;
	}
	
	/**
	 * Gets the plot
	 * @return plot  the new plot
	 * */
	public Plot getPlot() {
		return new Plot(plot);
	}
	
	/**
	 * Represents the information of all the properties in the properties array
	 * @return str  the string representation of all the properties-pr
	 * */
	public String toString() {
		String str = "List of the properties for ";
		str += name + ", " + taxID + "\n";
		
		for (int i = 0; i < getPropertiesCount(); i++) {
			str += properties[i].getPropertyName() + "," +properties[i].getCity() + "," 
					+ properties[i].getOwner() + "," + properties[i].getRentAmount();
			str += "\n";
			
			
		}
		System.out.println(str);
		return str;
	}
}
