import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SizeTestStudent {


public enum Size {
	SMALL, MEDIUM, LARGE;
}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testValues() {
		Size[] test={Size.SMALL,Size.MEDIUM,Size.LARGE};
		assertEquals(test, Size.values());
	}
	
	@Test
	public void testValueOf() {
		assertEquals(Size.SMALL, Size.valueOf("SMALL"));
	}

}
