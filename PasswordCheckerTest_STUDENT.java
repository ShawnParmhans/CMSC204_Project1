package application;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Shawn Parmhans
 *
 */
public class PasswordCheckerTest_STUDENT {

	@Before
	public void setUp() throws Exception 
	{
		
	}

	@After
	public void tearDown() throws Exception 
	{
	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 * @throws InvalidSequenceException 
	 * @throws NoSpecialCharacterException 
	 * @throws NoDigitException 
	 * @throws NoLowerAlphaException 
	 * @throws NoUpperAlphaException 
	 */
	@Test
	public void testIsValidPasswordTooShort() throws NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		try 
		{
            PasswordCheckerUtility.isValidLength("ha%S");
            fail("LengthException should have been thrown");
        } catch (LengthException e) 
		{
        	
        }

        try 
        {
            PasswordCheckerUtility.isValidPassword("AbC123");
        } 
        catch (Exception e) 
        {
        	
        }
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try 
		{
            PasswordCheckerUtility.hasUpperAlpha("teletubby");
            fail("NoUpperAlphaException should have been thrown");
        } catch (NoUpperAlphaException e) 
		{
        	
        }

        try 
        {
            PasswordCheckerUtility.isValidPassword("crocs123%");
        } 
        catch (Exception e) 
        {
        	
        }
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try 
		{
            PasswordCheckerUtility.hasLowerAlpha("GOODBYEWORLD");
            fail("NoLowerAlphaException should have been thrown");
        } catch (NoLowerAlphaException e) 
		{
        	
        }

        try 
        {
            PasswordCheckerUtility.isValidPassword("CROCS123%");
        } 
        catch (Exception e) 
        {
        	
        }
	}
	@Test
	public void testIsWeakPassword()
	{
		try 
		{
            try {
				PasswordCheckerUtility.isWeakPassword("sH0t");
			} catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
					| NoSpecialCharacterException | InvalidSequenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } catch (WeakPasswordException e) 
		{
        	
        }

        try 
        {
            PasswordCheckerUtility.isValidPassword("123%");
        } 
        catch (Exception e) 
        {
        	
        }
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try 
		{
            PasswordCheckerUtility.NoSameCharInSequence("Shawnxxx@99");
            fail("InvalidSequenceException should have been thrown");
        } catch (InvalidSequenceException e) 
		{
        	
        }

        try 
        {
            PasswordCheckerUtility.isValidPassword("CROCCCS123%");
        } 
        catch (Exception e) 
        {
        	
        }
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try 
		{
            PasswordCheckerUtility.hasDigit("Fortnite");
            fail("NoDigitException should have been thrown");
        } catch (NoDigitException e) 
		{
        	
        }

        try 
        {
            PasswordCheckerUtility.isValidPassword("CROCSs1%");
        } 
        catch (Exception e) 
        {
        	
        }
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
        try {
            PasswordCheckerUtility.isValidPassword("vb.SkylineX98");
        } catch (Exception e) {
            fail("No exception should have been thrown");
        }
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
        ArrayList<String> passwords = new ArrayList<>();
        passwords.add("Abc123!");
        passwords.add("abc");
        passwords.add("ABCD1234");

        ArrayList<String> invalidPasswords = PasswordCheckerUtility.getInvalidPasswords(passwords);

        assertTrue(invalidPasswords.contains("abc LengthException: The password must be at least 6 characters long"));
        assertTrue(invalidPasswords.contains("ABCD1234 NoLowerAlphaException: The password must contain at least one lowercase alphabetic character"));
	}
	
}

