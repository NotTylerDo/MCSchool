import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoDimRaggedArrayUtilityTestStudent {

private double[][] dataSet1 = {{1,2,3},{4,5},{6,7,8}};
private double[][] dataSet2 = {{7,2,9,4},{5},{8,1,3},{11,6,7,2}};
private double[][] dataSet3 = {{7.2,2.5,9.3,4.8},{5.9},{8.1,1.7,3.3},{11.6,6.9,7.3,2.7}};
private double[][] dataSet4 = {{-2.5,-5.3,6.1},{-4.4,8.2},{2.3,-7.5},{-4.2,7.3,-5.9,2.6}};
private double[][] dataSet5 = {{1.65,4.50,2.36,7.45,3.44,6.23},{2.22,-3.24,-1.66,-5.48,3.46},
		{4.23,2.29,5.29},{2.76,3.76,4.29,5.48,3.43},{3.38,3.65,3.76},{2.46,3.34,2.38,8.26,5.34}};
private double[][] dataSet6 = {{1253.65, 4.50, 2154.36, 7532.45, 3388.44},{2876.22, -3.24, 1954.66},
		{4896.23, 2.29, 5499.29},{2256.76, 3.76, 4286.29, 5438.48, 3794.43},
		{3184.38, 3654.65, 3455.76, 6387.23, 4265.77, 4592.45},{2657.46, 3265.34, 2256.38, 8935.26, 5287.34, 6598.23}};
private double[][] dataSet7 = {{12536.54, 45665.05, 21543.66, 75324.57, 33884.48, 65982.39},{28762.21, 35762.42, 19546.63},
		{48962.34, 28552.95, 23863.66, 54992.97},{22567.63, 36237.64, 42862.95, 54384.86, 37944.37},
		{31843.86, 36546.57, 34557.68, 63872.39, 42657.70, 45924.51},{26574.65, 32653.46, 22563.87, 89352.68, 52873.49}};

	
	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testReadFile(){
		assertEquals(36.0, TwoDimRaggedArrayUtility.getTotal(dataSet1), 0.00001);
		assertEquals(65.0, TwoDimRaggedArrayUtility.getTotal(dataSet2),0.00001);
		assertEquals(71.30, TwoDimRaggedArrayUtility.getTotal(dataSet3),0.00001);
		assertEquals(-3.30, TwoDimRaggedArrayUtility.getTotal(dataSet4),0.00001);
		assertEquals(85.03, TwoDimRaggedArrayUtility.getTotal(dataSet5),0.00001);
		assertEquals(99878.82, TwoDimRaggedArrayUtility.getTotal(dataSet6),0.00001);
		assertEquals(1168798.18, TwoDimRaggedArrayUtility.getTotal(dataSet7),0.00001);
	}
	
	@Test 
	public void testWriteToFile() {
		// Idk what to test
	}
	
	@Test
	public void testGetTotal() {
		assertEquals(36.0, TwoDimRaggedArrayUtility.getTotal(dataSet1), 0.00001);
		assertEquals(65.0, TwoDimRaggedArrayUtility.getTotal(dataSet2),0.00001);
		assertEquals(71.30, TwoDimRaggedArrayUtility.getTotal(dataSet3),0.00001);
		assertEquals(-3.30, TwoDimRaggedArrayUtility.getTotal(dataSet4),0.00001);
		assertEquals(85.03, TwoDimRaggedArrayUtility.getTotal(dataSet5),0.00001);
		assertEquals(99878.82, TwoDimRaggedArrayUtility.getTotal(dataSet6),0.00001);
		assertEquals(1168798.18, TwoDimRaggedArrayUtility.getTotal(dataSet7),0.00001);
	}
	
	@Test 
	public void testGetAverage() {
		assertEquals(4.5, TwoDimRaggedArrayUtility.getAverage(dataSet1), 0.1);
		assertEquals(5.416, TwoDimRaggedArrayUtility.getAverage(dataSet2),0.1);
		assertEquals(5.941, TwoDimRaggedArrayUtility.getAverage(dataSet3),0.1);
		assertEquals(-0.3, TwoDimRaggedArrayUtility.getAverage(dataSet4),0.1);
		assertEquals(3.1492, TwoDimRaggedArrayUtility.getAverage(dataSet5),0.1);
		assertEquals(3567.1007, TwoDimRaggedArrayUtility.getAverage(dataSet6),0.1);
		assertEquals(40303.3855, TwoDimRaggedArrayUtility.getAverage(dataSet7),0.1);

	}
	
	@Test
	public void testGetRowTotal() {
		assertEquals(6.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 0), 0.00001);
		assertEquals(9.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 1),0.00001);
		assertEquals(21.00, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 2),0.00001);
	}
	
	@Test
	public void testGetColumnTotal() {
		assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 0), 0.00001);
		assertEquals(14.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 1),0.00001);
		assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 2),0.00001);
	}
	
	@Test
	public void testGetHighestInRow() {
		assertEquals(3.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 0), 0.00001);
		assertEquals(5.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 1),0.00001);
		assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 2),0.00001);
	}
	
	@Test
	public void testGetHighestInRowIndex() {
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 0), 0.00001);
		assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 1),0.00001);
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 2),0.00001);
	}
	
	@Test
	public void testGetLowestInRow() {
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 0), 0.00001);
		assertEquals(4.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 1),0.00001);
		assertEquals(6.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 2),0.00001);
	}
	
	@Test
	public void testGetLowestInRowIndex() {
		assertEquals(0.0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 0), 0.00001);
		assertEquals(0.0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 1),0.00001);
		assertEquals(0.0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 2),0.00001);
	}
	
	@Test
	public void testGetHighestInColumn() {
		assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 0), 0.00001);
		assertEquals(7.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 1),0.00001);
		assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 2),0.00001);
	}
	
	@Test
	public void testGetHighestInColumnIndex() {
		assertEquals(2.0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 0), 0.00001);
		assertEquals(2.0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 1),0.00001);
		assertEquals(2.0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 2),0.00001);
	}
	
	@Test
	public void testGetLowestInColumn() {
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 0), 0.00001);
		assertEquals(2.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 1),0.00001);
		assertEquals(3.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 2),0.00001);
	}
	
	@Test
	public void testGetLowestInColumnIndex() {
		assertEquals(0.0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 0), 0.00001);
		assertEquals(0.0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 1),0.00001);
		assertEquals(0.0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 2),0.00001);
	}
	
	@Test
	public void testGetHighestInArray() {
		assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet1), 0.00001);
		assertEquals(11.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet2),0.00001);
		assertEquals(11.6, TwoDimRaggedArrayUtility.getHighestInArray(dataSet3),0.00001);
		assertEquals(8.2, TwoDimRaggedArrayUtility.getHighestInArray(dataSet4),0.00001);
		assertEquals(8.26, TwoDimRaggedArrayUtility.getHighestInArray(dataSet5),0.00001);
		assertEquals(8935.26, TwoDimRaggedArrayUtility.getHighestInArray(dataSet6),0.00001);
		assertEquals(89352.68, TwoDimRaggedArrayUtility.getHighestInArray(dataSet7),0.00001);
	}
	
	@Test
	public void testGetLowestInArray() {
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet1), 0.00001);
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet2),0.00001);
		assertEquals(1.7, TwoDimRaggedArrayUtility.getLowestInArray(dataSet3),0.00001);
		assertEquals(-7.5, TwoDimRaggedArrayUtility.getLowestInArray(dataSet4),0.00001);
		assertEquals(-5.48, TwoDimRaggedArrayUtility.getLowestInArray(dataSet5),0.00001);
		assertEquals(-3.24, TwoDimRaggedArrayUtility.getLowestInArray(dataSet6),0.00001);
		assertEquals(12536.54, TwoDimRaggedArrayUtility.getLowestInArray(dataSet7),0.00001);
	}
}


