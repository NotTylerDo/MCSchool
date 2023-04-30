import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class TypeTestStudent {

public enum Type {
	SMOOTHIE, COFFEE, ALCOHOL;
}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testValues() {
		Type[] test={Type.SMOOTHIE,Type.COFFEE,Type.ALCOHOL};
		assertEquals(test, Type.values());
	}
	
	@Test
	public void testValueOf() {
		assertEquals(Type.SMOOTHIE, Type.valueOf("SMOOTHIE"));
	}
}
