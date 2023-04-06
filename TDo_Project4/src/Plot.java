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

public class Plot {
	private int x;
	private int y;
	private int depth;
	private int width;
	
	/**
	 * Creates a default plot with width and depth of 1
	 * */
	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	/**
	 * Creates a plot with the given values
	 * @param x2   int value of x coordinate of the upper left corner
	 * @param y2   int value of y coordinate of the upper left corner
	 * @param width2   int value of the width
	 * @param depth2   int value of the depth
	 * */
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	/**
	 * Creates a new plot given another plot to make a copy of
	 * @param otherPlot    The plot to make a copy of
	 * */
	public Plot(Plot otherPlot) {
		this.x = otherPlot.x;
		this.y = otherPlot.y;
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
	}
	
	/**
	 * Determines if the given plot is encompassed by the other plot
	 * @param plot2    Plot object to test against and check if it encompasses
	 * @return status  The boolean value if the given plot is encompassed
	 * */
	public boolean encompasses(Plot plot2) {
		boolean status = true;
		int xLeft, xRight, yTop, yBottom ;
		int x2Left, x2Right, y2Bottom, y2Top;
		
		xLeft = this.x;
		xRight = this.x + this.width;
		yTop = this.y + this.depth;
		yBottom = this.y;
		
		x2Left = plot2.x;
		x2Right = plot2.x + plot2.width;
		y2Top = plot2.y + plot2.depth;
		y2Bottom = plot2.y ;
		
		if (!(x2Left >= xLeft)) 
			status = false;
		else if (!(x2Right <= xRight))
			status = false;
		else if (!(y2Top <= yTop))
			status = false;
		else if (!(y2Bottom >= yBottom))
			status = false;
		
		return status;
	}
	
	/**
	 * Determines if given plot is overlapped by the current plot
	 * @param plot3     Plot instance to test against and check if it overlaps
	 * @return status   Boolean value if the two plots overlap
	 * */
	public boolean overlaps(Plot plot3) {
		boolean status = false;
		int xLeft, xRight, yTop, yBottom ;
		int x3Left, x3Right, y3Bottom, y3Top;
		
		xLeft = this.x;
		xRight = this.x + this.width;
		yTop = this.y + this.depth;
		yBottom = this.y;
		
		x3Left = plot3.x;
		x3Right = plot3.x + plot3.width;
		y3Top = plot3.y + plot3.depth;
		y3Bottom = plot3.y;
		// For plot to overlap, it needs two of its lines to be in the middle of the parallel lines of the other plot
		if (x3Left > xLeft && x3Left < xRight) {
			
			if (y3Bottom > yBottom && y3Bottom < yTop)
				status = true;
			else if (y3Top > yBottom && y3Top < yTop)
				status = true;
		}
			
		 if (x3Right > xLeft && x3Right < xRight) {
		
			if (y3Bottom > yBottom && y3Bottom < yTop)
				status = true;
			else if (y3Top > yBottom && y3Top < yTop)
				status = true;
		}
		
		 if (y3Top < yTop && y3Top > yBottom) {
			if (x3Left > xLeft && x3Left < xRight)
				status = true;
			else if (x3Right > xLeft && x3Right < xRight)
				status = true;
		}
		
		 if (y3Bottom > yBottom && y3Bottom < yTop) {
			if (x3Left > xLeft && x3Left < xRight)
				status = true;
			else if (x3Right > xLeft && x3Right < xRight)
				status = true;
		}
		
		// Checking if the other plot overlaps 
		 if (xLeft > x3Left && xLeft < x3Right) {
			if (yBottom > y3Bottom && yBottom < y3Top)
				status = true;
			else if (yTop > y3Bottom && yTop < y3Top)
				status = true;
		}
			
		 if (xRight > x3Left && xRight < x3Right) {
			
			if (yBottom > y3Bottom && yBottom < y3Top)
				status = true;
			else if (yTop > y3Bottom && yTop < y3Top)
				status = true;
		}
		
		 if (yTop < y3Top && yTop > y3Bottom) {
			
			if (xLeft > x3Left && xLeft < x3Right)
				status = true;
			else if (xRight > x3Left && xRight < x3Right)
				status = true;
		}
		
		 if (yBottom > y3Bottom && yBottom < y3Top) {
			if (xLeft > x3Left && xLeft < x3Right)
				status = true;
			else if (xRight > x3Left && xRight < x3Right)
				status = true;
		}
		
		 if (xRight == x3Right && xLeft == x3Left
				 && yTop == y3Top && yBottom == y3Bottom)
			 status = true;
		return status;
	}
	
	/**
	 * Sets the x
	 * @param x   the new x
	 * */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Sets the y
	 * @param y   the new y
	 * */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Sets the width
	 * @param width2   the new width
	 * */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Sets the depth
	 * @param depth2   the new depth
	 * */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	/**
	 * Gets the x
	 * @return x2   the x
	 * */
	public int getX() {
		return x;
	}
	
	/**
	 * Gets the y
	 * @returns y2   the y
	 * */
	public int getY() {
		return y;
	}
	
	/**
	 * Gets the width
	 * @returns width2   the width
	 * */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Gets the depth
	 * @return depth   the depth
	 * */
	public int getDepth() {
		return depth;
	}
	
	/**
	 * Represents a Plot object in a String format
	 * @return str    the String representation of the plot
	 * */
	public String toString() {
		String str = getX() + "," + getY() + "," + getWidth() + "," + getDepth();
		return str;
	}
	
	
	
	
	
	
}
