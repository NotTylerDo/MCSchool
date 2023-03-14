import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {
	CryptoManager cryptoManager;


	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("TEST CODE WITH UPPERCASE"));
		assertTrue(CryptoManager.isStringInBounds("TEST_CODE**WITH>>SPECIAL\\CHARACTERS"));
		assertFalse(CryptoManager.isStringInBounds("test code with lowercase"));
		assertFalse(CryptoManager.isStringInBounds("TEST CODE WITH OUT OF BOUND CHARACTER {}"));
		assertFalse(CryptoManager.isStringInBounds("TEST CODE WITH 1 LoWERCASE"));	
	}
	
	@Test
	public void testEncryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("{}", 3));
		assertEquals("[ SLY'KV", CryptoManager.caesarEncryption("TYLER DO", 7));
		assertEquals("]\"UN[)MX", CryptoManager.caesarEncryption("TYLER DO", 777));
		assertEquals("TESTING_CASES 1-4", CryptoManager.caesarEncryption("TESTING_CASES 1-4", 64));
		assertEquals("+_)(*&^%$#@!<>?", CryptoManager.caesarEncryption("+_)(*&^%$#@!<>?", 0));
	}
	
	@Test
	public void testDecryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarDecryption("{}", 3));
		assertEquals("PENGUINS", CryptoManager.caesarDecryption("QFOHVJOT", 1));
		assertEquals("DOG OWNER 101", CryptoManager.caesarDecryption("/:2K:B90=K\\[\\", 555));
		assertEquals("!@#$%^&*()", CryptoManager.caesarDecryption("!@#$%^&*()", 64));
		assertEquals("TYLER DO", CryptoManager.caesarDecryption("[ SLY'KV", 7));
	}
	
	@Test
	public void testEncryptBellaso() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.bellasoEncryption("{}", "3"));
		assertEquals(" (ZLW2$#", CryptoManager.bellasoEncryption("TYLER DO", "LONGER THAN THIS"));
		assertEquals("X(SI!'H^", CryptoManager.bellasoEncryption("TYLER DO", "DOG"));
		assertEquals("&]][J!')T[Z /\"U<B6#RT'KMFYKXR\\SSU[", CryptoManager.bellasoEncryption("RUNNING_OUT[]OF...TEST+CASES@IDEAS", "THOMAS JEFFERSON"));
		assertEquals(">/.+3'*E$F< OND", CryptoManager.bellasoEncryption("+_)(*&^%$#@!<>?", "SPECIAL @#<?"));
	}
	
	@Test
	public void testDecryptBellaso() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.bellasoDecryption("{}", "3"));
		assertEquals("PEN THE PENGUIN", CryptoManager.bellasoDecryption("$MW34SJ90N!'!X\\", "THIS KEY IS LONGER THAN THIS"));
		assertEquals("STUFFING THE STUFF WITH STUFF", CryptoManager.bellasoDecryption("&\\$XZN '+Y!X(\"&)KX@\"N-[(\"&)KX", "SHORTER KEY"));
		assertEquals("RUNNING_OUT[]OF...TEST+CASES@IDEAS", CryptoManager.bellasoDecryption("&]S.NRP2^#4\"2(Z63NYI\\':Q!ZZ,TQI%FW", "THE EDISON GUY"));
		assertEquals("TYLER DO", CryptoManager.bellasoDecryption("X(SI!'H^", "DOG"));
	}
}
