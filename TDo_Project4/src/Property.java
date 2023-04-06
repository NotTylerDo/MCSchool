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

public class Property {
	private Plot plot;
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	
	/**
	 * Creates a new Property using empty strings. 
	 * Also creates a default plot
	 * */
	public Property() {
		propertyName = "";
		city = "";
		owner = "";
		rentAmount = 0.0;
	
		plot = new Plot();
	}
	
	/**
	 * Creates a new Property object using given values.
	 * Also creates a default plot.
	 * @param propertyName   property name
	 * @param city    city where property is located
	 * @param rentAmount      rent amount
	 * @param owner       the owner's name
	 * */
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot();
	}
	
	/**
	 * Creates a new Property object using given values.
	 * Also creates a Plot using given values
	 * @param propertyName   property name
	 * @param city    city where property is located
	 * @param rentAmount      rent amount
	 * @param owner       the owner's name
	 * @param x    the x coordinate of the plot
	 * @param y    the y coordinate of the plot
	 * @param width    the width coordinate of the plot
	 * @param depth    the depth coordinate of the plot
	 * */
	public Property(String propertyName, String city, double rentAmount, String owner, 
					int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot(x,y,width,depth);
	}
	
	/**
	 * Creates a new copy of the given property object
	 * @param otherProperty     the Property object to make a copy of
	 * */
	public Property(Property otherProperty) {
		this.propertyName = otherProperty.propertyName;
		this.city = otherProperty.city;
		this.owner = otherProperty.owner;
		this.rentAmount = otherProperty.rentAmount;
		this.plot = otherProperty.plot;
	}
	
	/**
	 * Gets the plot
	 * @return plot    the plot
	 * */
	public Plot getPlot() {
		return plot;
	}
	
	/**
	 * Gets the property name 
	 * @return propertyName    the property name 
	 * */
	public String getPropertyName() {
		return propertyName;
	}
	
	/**
	 * Gets the city's name 
	 * @return city    the city 
	 * */
	public String getCity() {
		return city;
	}
	
	/**
	 * Gets the rent amount
	 * @return rentAmount    the rent amount 
	 * */
	public double getRentAmount() {
		return rentAmount;
	}
	
	/**
	 * Gets the owner's name 
	 * @return owner    the owner's name 
	 * */
	public String getOwner() {
		return owner;
	}
	
	/**
	 * Represents a Property object in the following String format: 
	 * propertyName,city,owner,rentAmount
	 * @return str    The string representation of a Property object
	 * */
	public String toString() {
		String str = propertyName + "," + city + "," + owner + "," + rentAmount;
		return str;
	}
}
