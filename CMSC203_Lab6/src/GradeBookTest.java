import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GradeBookTest {
	private GradeBook gradeBook1;
	private GradeBook gradeBook2;
	
	
	@BeforeEach
	public void setUp() throws Exception {
		gradeBook1 = new GradeBook(5);
		gradeBook2 = new GradeBook(5);
		gradeBook1.addScore(59);
		gradeBook1.addScore(98);
		gradeBook1.addScore(68);
		gradeBook1.addScore(76);
		gradeBook1.addScore(89);
		gradeBook2.addScore(51);
		gradeBook2.addScore(67);
		gradeBook2.addScore(82);
		gradeBook2.addScore(90);
	}

	@AfterEach
	public void tearDown() throws Exception {
		gradeBook1 = null;
		gradeBook2 = null;
	}

	@Test
	public void testAddScore() {
		assertTrue(gradeBook1.toString().equals("59.0 98.0 68.0 76.0 89.0 "));
		assertTrue(gradeBook2.toString().equals("51.0 67.0 82.0 90.0 0.0 "));
	}

	@Test
	void testSum() {
		assertEquals(390, gradeBook1.sum(), .0001);
		assertEquals(290, gradeBook2.sum(), .0001);
	}

	@Test
	void testMinimum() {
		assertEquals(59, gradeBook1.minimum(), .001);
		assertEquals(51, gradeBook2.minimum(), .001);
	}

	@Test
	void testFinalScore() {
		assertEquals(331, gradeBook1.finalScore(), .001);
		assertEquals(239, gradeBook2.finalScore(), .001);
	}

}
