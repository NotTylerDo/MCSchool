/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: Create a program that uses Caesar and Bellaso encryption methods to 
 * encrypt a plaintext. Create additional methods to decrypt these encrypted methods to 
 * regular plaintext. These methods will be used in a JavaFX code to visually display 
 * text boxes to encrypt and decrypt messages.
 * Due: 03/24/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Tyler Do
*/

import java.util.ArrayList;
/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		for (int i = 0; i < plainText.length(); i++) {
			if (plainText.charAt(i) < LOWER_RANGE || plainText.charAt(i) > UPPER_RANGE)  
				return false;
		}
		return true;	
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		String copy = new String(plainText);
		String encrypt = new String("");
		char value;
		int value2;

		if (!isStringInBounds(plainText)) 
			return "The selected string is not in bounds, Try again.";
		
		for (int i = 0; i < copy.length(); i++) {
			// Adds the key to the character at i
			value2 = (copy.charAt(i) + key);
			value = (char)(value2);
			
			// In case adding the values go beyond the range and needs to be wrapped
			while ( value > UPPER_RANGE) {
				// Subtracts RANGE until it is within the desired range. 
				// Ensures that value2 does not go under LOWER_RANGE
				value2 -= RANGE;
				value = (char) (value2);
			}	
			encrypt += value;
		}
		return encrypt;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) { 
		String plainCopy = new String(plainText);
		String bellasoCopy = new String(bellasoStr);
		String encrypt = "";
		
		if (!isStringInBounds(plainText)) 
			return "The selected string is not in bounds, Try again.";
		
		int value2, originalValue2, encryptedValue2;
		char encryptedValue;
		int bellasoRange = bellasoCopy.length();
		
		for (int i = 0; i < plainCopy.length(); i++) {
			int j = i;
			originalValue2 = plainCopy.charAt(i);
			if (i < bellasoCopy.length()) 
				value2 = bellasoCopy.charAt(j);
			
			// When bellaso key needs to be wrapped around the plain text
			else {
				j = (i - bellasoCopy.length()) % bellasoRange;
				value2 = bellasoCopy.charAt(j);	
			}
	
			encryptedValue2 = originalValue2 + value2; 
			encryptedValue = (char)(originalValue2 + value2);
			
			while (encryptedValue2 > UPPER_RANGE) {	
				// Subtracts RANGE until it is within the desired range. 
				// Ensures that encryptedValue2 does not go under LOWER_RANGE
				encryptedValue2 -= RANGE;
			}
			encryptedValue = (char)(encryptedValue2);
			encrypt += encryptedValue;
		}
		return encrypt;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		String copy = new String(encryptedText);
		String decrypt = new String("");
		char value;
		int value2;
		key %= RANGE;
		
		if (!isStringInBounds(encryptedText)) 
			return "The selected string is not in bounds, Try again.";
		
		for (int i = 0; i < copy.length(); i++) {
			value2 = (copy.charAt(i) - key); 
			value = (char) (value2);
			
			while (value < LOWER_RANGE) {
				// Adds RANGE until it is within the desired range. 
				value2 += RANGE;
				value = (char)(value2);
			}
			decrypt += value;
		}
		return decrypt;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		String encryptedCopy = new String(encryptedText);
		String bellasoCopy = new String(bellasoStr);
		String decrypt = "";
		int value2, originalValue2, decryptedValue2;
		char decryptedValue;
		int bellasoRange = bellasoCopy.length();
		
		if (!isStringInBounds(encryptedText)) 
			return "The selected string is not in bounds, Try again.";
		
		for (int i = 0; i < encryptedCopy.length(); i++) {
			int j = i;
			originalValue2 = encryptedCopy.charAt(i);

			if (i < bellasoCopy.length()) 
				value2 = bellasoCopy.charAt(j);
			
			// When the bellaso key needs to be wrapped around the encrypted text
			else {
				j = (i - bellasoCopy.length()) % bellasoRange;
				value2 = bellasoCopy.charAt(j);
			}
			
			decryptedValue2 = originalValue2 - value2; 
			decryptedValue = (char)(decryptedValue2);
			
			while (decryptedValue2 < LOWER_RANGE) {
				// Adds RANGE until it is within the desired range. 
				decryptedValue2 += RANGE;
			}
			
			decryptedValue = (char)(decryptedValue2);
			decrypt += decryptedValue;
		}
		return decrypt;
	} 
	
}

