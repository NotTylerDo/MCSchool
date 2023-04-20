/*
Class: CMSC203  

Instructor: Gary Thai 

Description: Create classes where a property management company manages individual properties they will build to rent, and charges them a management fee as the percentages of the monthly rental amount. The properties cannot overlap with each other, and each property must be within the limits of the management company’s plot. Write an application that lets the user create a management company and adds the properties managed by the company to its list.  

Due: 04/07/2023 

Platform/compiler: Eclipse 

I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student. 

Tyler Do 
*/
import java.io.*;
import java.util.Scanner;


public final class TwoDimRaggedArrayUtility extends Object{

	private final static int MAX_ROW = 10;
	private final static int MAX_COLUMN = 10;
	
	/**
	 * Default/no arg constructor
	 * */
	public TwoDimRaggedArrayUtility() {
		
	}
	
	/**
	 * Reads from a file and returns a ragged array of doubles
	 * @param file   the file to read from
	 * @return raggedArray     a two dimensional ragged array of doubles. If the file is empty
	 * 							return null    
	 * */
	public static double [][]readFile(File file) throws FileNotFoundException{
	
		double [][]raggedArray;
		String [][]temporary = new String[MAX_ROW][MAX_COLUMN];
		Scanner inputFile = new Scanner(file);
		int rowCount=0, colCount=0, columnCount = 0;

		
		while (inputFile.hasNext() && rowCount < MAX_ROW) {
			String [] tokenRow = inputFile.nextLine().split(" ");
			colCount = 0;
			while (colCount < tokenRow.length && colCount < MAX_COLUMN) {
				temporary[rowCount][colCount] = tokenRow[colCount];
				colCount++;
			}
			rowCount++;
		}
		
		
		raggedArray = new double[rowCount][];
		for (int i = 0; i < rowCount; i++) {
			// columnCount needs to restart at 0
			columnCount = 0;
			for (int j = 0; j < temporary[i].length && temporary[i][j] != null; j++) {
					columnCount++;	
			}
			raggedArray[i] = new double[columnCount];
			
			for (int j = 0; j < columnCount; j++) {
				raggedArray[i][j] = Double.parseDouble(temporary[i][j]);
			}
		}
		
		
		inputFile.close();
		if (file.length() == 0)
			return null;
		
		return raggedArray;
		}
	
	/**
	 * Write the ragged array of doubles into the file
	 * @param data     two dimensional ragged array of doubles
	 * @param outputFile      The file to write to 
	 * */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		PrintWriter outfile = new PrintWriter(outputFile);
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				outfile.print(data[i][j] + " ");
			}
			outfile.println();
		}
		outfile.close();
	}
	
	/**
	 * Returns the total of all the elements of the two dimensional array
	 * @param data    the two dimensional array getting total of
	 * @return value    the sum of all the elements in the two dimensional array
	 * */
	public static double getTotal(double[][] data) {
		double value = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				value += data[i][j];
			}
		}
		return value;
	}
	
	/**
	 * Returns the average of the elements in the two dimensional array
	 * @param data    the two dimensional array getting the average of
	 * @return value    the average of the elements in the two dimensional array
	 * */
	public static double getAverage(double[][] data) {
		double value = 0;
		int counter = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				value += data[i][j];
				counter++;
			}
		}
		value /= counter;
		return value;
	}
	
	/**
	 * Returns the total of the selected row in the two dimensional array
	 * @param data    the two dimensional array
	 * @param row     the row index to take total of
	 * return value     the total of the row
	 * */
	public static double getRowTotal(double[][] data, int row) {
		double value = 0;
		
		for (int j = 0; j < data[row].length; j++) {
			value += data[row][j];
		}
		return value;
	}
	
	/**
	 * Returns the total of the selected column in the two dimensional array
	 * @param data    the two dimensional array
	 * @param col     the column index to take total of
	 * return value     the total of the column
	 * */
	public static double getColumnTotal(double[][] data, int col) {
		double value = 0;
		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length)
				value += data[i][col];
		}
		return value;
	}
	
	/**
	 * Returns the largest element of the selected row in the two dimensional array
	 * @param data    two dimensional array
	 * @param row      the row index to find the largest element of
	 * @return highestElement    The largest element of the row
	 * */
	public static double getHighestInRow(double[][] data, int row) {
		int highestIndex = 0;
		double highestElement;
		for (int j = 0; j < data[row].length; j++) {
			if (data[row][j] > data[row][highestIndex]){
				highestIndex = j;
			}
		}
		highestElement = data[row][highestIndex];
		return highestElement;
	}
	
	/**
	 * Returns the index of the largest element of the selected row in the two dimensional array
	 * @param data    two dimensional array
	 * @param row      the row index to find the largest element of
	 * @return highestIndex    The index of the largest element of the row
	 * */
	public static int getHighestInRowIndex(double[][] data, int row) {
		int highestIndex = 0;
		for (int j = 0; j < data[row].length; j++) {
			if (data[row][j] > data[row][highestIndex]){
				highestIndex = j;
			}
		}
		return highestIndex;
	}
	
	/**
	 * Returns the smallest element of the selected row in the two dimensional array
	 * @param data    two dimensional array
	 * @param row      the row index to find the smallest element of
	 * @return lowestElement    The smallest element of the row
	 * */
	public static double getLowestInRow(double[][] data, int row) {
		int lowestIndex = 0;
		double lowestElement;
		for (int j = 0; j < data[row].length; j++) {
			if (data[row][j] < data[row][lowestIndex] && data[row][j] > 0){
				lowestIndex = j;
			}
		}
		lowestElement = data[row][lowestIndex];
		return lowestElement;
	}
	
	/**
	 * Returns the index of the smallest element of the selected row in the two dimensional array
	 * @param data    two dimensional array
	 * @param row      the row index to find the smallest element of
	 * @return lowestIndex    The index of the smallest element of the row
	 * */
	public static int getLowestInRowIndex(double[][] data, int row) {
		int lowestIndex = 0;
		for (int j = 0; j < data[row].length; j++) {
			if (data[row][j] < data[row][lowestIndex] && data[row][j] > 0){
				lowestIndex = j;
			}
		}
		return lowestIndex;
	}
	
	/**
	 * Returns the largest element of the selected column in the two dimensional array
	 * @param data    the two dimensional array
	 * @param col     The column index to find the largest element of 
	 * @return highestElement    The largest element of the column
	 * */
	public static double getHighestInColumn(double[][] data, int col) {
		double highestElement = Double.NEGATIVE_INFINITY;
		for (int i = 0; i < data.length; i++) {
			if (data[i].length > col && data[i][col] > highestElement) {	
				highestElement = data[i][col];
			}
		}
		return highestElement;
	}
	
	/**
	 * Returns the index of the largest element of the selected column in the two dimensional array
	 * @param data    the two dimensional array
	 * @param col     The column index to find the largest element of 
	 * @return highestIndex    The index of the largest element of the column
	 * */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		
		int highestIndex = 0;
		double highestElement = Double.NEGATIVE_INFINITY;
		for (int i = 0; i < data.length; i++) {
			if (data[i].length > col && data[i][col] > highestElement ) {	
				highestIndex = i;
				highestElement = data[i][col];
			}
		}
		return highestIndex;
	}
	
	/**
	 * Returns the index of the smallest element of the selected column in the two dimensional array
	 * @param data    the two dimensional array
	 * @param col     The column index to find the smallest element of 
	 * @return lowestIndex    The index of the smallest element of the column
	 * */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		int lowestIndex = 0;
		double lowestElement = Double.POSITIVE_INFINITY;
		for (int i = 0; i < data.length; i++) {
			if (data[i].length > col && data[i][col] < lowestElement/*does not exist in tesst cases*/) {
				lowestIndex = i;
				lowestElement = data[i][col];
			}
		}
		return lowestIndex;
	}
	
	/**
	 * Returns the smallest element of the selected column in the two dimensional array
	 * @param data    the two dimensional array
	 * @param col     The column index to find the smallest element of 
	 * @return lowestElement    The smallest element of the column
	 * */
	public static double getLowestInColumn(double[][] data, int col) {
		double lowestElement = Double.POSITIVE_INFINITY;
		for (int i = 0; i < data.length; i++) {
			if (data[i].length > col && data[i][col] < lowestElement/*does not exist in tesst cases*/) {
				
				lowestElement = data[i][col];
			}
		}
		return lowestElement;
	}
	
	/**
	 * Returns the largest element in the two dimensional array
	 * @param data    the two dimensional array
	 * @return highestElement    the largest element in the two dimensional array
	 * */
	public static double getHighestInArray(double[][] data) {
		int highestRow = 0, highestColumn = 0;
		double highestElement;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] > data[highestRow][highestColumn]) {
					highestRow = i;
					highestColumn = j;
				}
			}
		}
		highestElement = data[highestRow][highestColumn];
		return highestElement;
	}
	
	/**
	 * Returns the smallest element in the two dimensional array
	 * @param data    the two dimensional array
	 * @return lowestElement    the smallest element in the two dimensional array
	 * */
	public static double getLowestInArray(double[][] data) {
		int lowestRow = 0, lowestColumn = 0;
		double lowestElement;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] < data[lowestRow][lowestColumn]) {
					lowestRow = i;
					lowestColumn = j;
				}
			}
		}
		lowestElement = data[lowestRow][lowestColumn];
		return lowestElement;
	}
	
	
}
