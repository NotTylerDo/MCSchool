/*
Class: CMSC203  

Instructor: Gary Thai 

Description: Create classes where a property management company manages individual properties they will build to rent, and charges them a management fee as the percentages of the monthly rental amount. The properties cannot overlap with each other, and each property must be within the limits of the management company’s plot. Write an application that lets the user create a management company and adds the properties managed by the company to its list.  

Due: 04/07/2023 

Platform/compiler: Eclipse 

I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student. 

Tyler Do 
*/
public class HolidayBonus extends Object{

	/**
	 * Default/no arg constructor
	 * */
	public HolidayBonus() {
	}
	
	/**
	 * Calculates the holiday bonus for each store
	 * @param data   the two dimension array of store sales
	 * @return holidayBonus   the array of the bonuses for each store
	 * */
	public static double[] calculateHolidayBonus(double[][] data) {
		
		double[] holidayBonus;
		int highest, lowest;
		holidayBonus = new double[data.length];
		for (int i = 0; i < data.length; i++) {
			// bonus needs to reset at 0
			double bonus = 0;
			for (int j = 0; j < data[i].length; j++) {
				if( data[i][j] >= 0 ) {
					if (data[i].length > 1) {
						lowest = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j);
						highest = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j);
	
					if (highest == i)
						bonus += 5000;
					else if (lowest == i )
						bonus += 1000;
					else if (data[i][j] >= 0)
						bonus += 2000;
					}
				}
			}
			holidayBonus[i] = bonus;
		}
		return holidayBonus;
	}
	
	
	/**
	 * Calculates the total holiday bonuses
	 * @param data    the two dimensional array of store sales
	 * @return holidayBonus    the total of all holiday bonuses
	 * */
	public static double calculateTotalHolidayBonus(double[][] data) {
		double holidayBonus = 0;
		
		int highest, lowest;
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {	
				if (data[i][j] >= 0) {
					lowest = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j);
					highest = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j);
					if (highest == i)
						holidayBonus += 5000;
					else if (lowest == i)
						holidayBonus += 1000;
					else if (data[i][j] >= 0)
						holidayBonus += 2000;
					}
				}
			
			
		}
		return holidayBonus;
		
	}
}
