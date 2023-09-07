/*
 Class: CMSC204 CRN 21573
 Program: Project 1
 Instructor: Gary Thai
 Summary of Description: Check password validity
 Due Date: 09/06/2023 
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Shawn Parmhans
*/


package application;

import java.io.*;
import java.util.regex.*;
import java.util.ArrayList;

public class PasswordCheckerUtility 
{
	/**
	 * Check if password is valid
	 * @param password The password used for checking
	 * @return True if all exceptions pass, return exception that fails if fail
	 * @throws LengthException Thrown when password doesn't meet length requirements
	 * @throws NoUpperAlphaException Thrown when password doesn't meet upper alphabet requirements
	 * @throws NoLowerAlphaException Thrown when password doesn't meet lower alphabet requirements
	 * @throws NoDigitException Thrown when password doesn't meet digit requirements
	 * @throws NoSpecialCharacterException Thrown when password doesn't meet special character requirements
	 * @throws InvalidSequenceException Thrown when password doesn't meet valid sequence requirements
	 */
	public static boolean isValidPassword(String password) throws LengthException, 
	NoUpperAlphaException, NoLowerAlphaException, NoDigitException, 
	NoSpecialCharacterException, InvalidSequenceException
	{
		if(!isValidLength(password))
			throw new LengthException();
		
		if(!hasUpperAlpha(password))
			throw new NoUpperAlphaException();
		
		if(!hasLowerAlpha(password))
			throw new NoLowerAlphaException();
		
		if(!hasDigit(password))
			throw new NoDigitException();
		
		
		if(!hasSpecialChar(password))
			throw new NoSpecialCharacterException();
	
        if(!NoSameCharInSequence(password))
            throw new InvalidSequenceException();
		
		return true;
	}
	/**
	 * Check if password is weak
	 * @param password The password used for checking
	 * @return True if password is invalid and between 6-9 characters
	 * @throws LengthException Thrown when password doesn't meet length requirements
	 * @throws NoUpperAlphaException Thrown when password doesn't meet upper alphabet requirements
	 * @throws NoLowerAlphaException Thrown when password doesn't meet lower alphabet requirements
	 * @throws NoDigitException Thrown when password doesn't meet digit requirements
	 * @throws NoSpecialCharacterException Thrown when password doesn't meet special character requirements
	 * @throws InvalidSequenceException Thrown when password doesn't meet valid sequence requirements
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException, 
	LengthException, NoUpperAlphaException, NoLowerAlphaException, 
	NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		boolean isValid = true;
		//If weak password in between 6-9
		try
		{
			if(password.length() >= 6 && password.length() <= 9)
				throw new WeakPasswordException();
		}
		finally
		{
			
		}
		//if valid and not between 6-9
			if(isValidPassword(password) && (password.length() < 6 || password.length() > 9))
				isValid = false;
			
		return isValid;
	}
	/**
	 * Return an array of all the invalid passwords with exception messages
	 * @param passwords The array of Strings used to determine validity per password
	 * @return Array of invalid passwords
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords)
	{
		ArrayList<String> invalidList = new ArrayList<>();
		
		for(String password : passwords)
		{
			try 
			{
				isValidPassword(password);
			}
			//Add invalid passwords to list
			catch (Exception e)
			{
				invalidList.add(password + " " + e.getMessage());
			}
		}
		return invalidList;
	}
	/**
	 * compare 2 passwords
	 * @param password original password used to compare
	 * @param passwordConfirm 2nd password used to compare
	 * @throws UnmatchedException Thrown when passwords aren't equal
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException
	{
		if(!password.equals(passwordConfirm))
			throw new UnmatchedException();
	}
	/**
	 * Compare 2 passwords with return
	 * @param password original password used to compare
	 * @param passwordConfirm 2nd password used to compare
	 * @return True if passwords are the same
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm)
	{
		if(password.equals(passwordConfirm))
			return true;
		else
			return false;
	}
	/**
	 * Determine if password is a valid length
	 * @param password The password used for checking
	 * @return True if password passes exception
	 * @throws LengthException Thrown when password doesn't pass exception
	 */
	public static boolean isValidLength(String password) throws LengthException 
	{
	    if (password.length() < 6) 
	        throw new LengthException();
	    
	    return true;
	}
	/**
	 * Determine if password has an uppercase letter
	 * @param password The password used for checking
	 * @return True if password passes exception
	 * @throws LengthException Thrown when password doesn't pass exception
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException 
	{
	    Pattern pattern = Pattern.compile("[A-Z]");
	    Matcher matcher = pattern.matcher(password);
	
	    if (!matcher.find()) 
	        throw new NoUpperAlphaException();
	
	    return true;
	}
	/**
	 * Determine if password has a lowercase letter
	 * @param password The password used for checking
	 * @return True if password passes exception
	 * @throws LengthException Thrown when password doesn't pass exception
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException 
	{
	    Pattern pattern = Pattern.compile("[a-z]");
	    Matcher matcher = pattern.matcher(password);

	    if (!matcher.find()) 
	        throw new NoLowerAlphaException();

	    return true;
	}
	/**
	 * Determine if password has a digit
	 * @param password The password used for checking
	 * @return True if password passes exception
	 * @throws LengthException Thrown when password doesn't pass exception
	 */
	public static boolean hasDigit(String password) throws NoDigitException 
	{
	    Pattern pattern = Pattern.compile("\\d");
	    Matcher matcher = pattern.matcher(password);

	    if (!matcher.find()) 
	        throw new NoDigitException();
 
	    return true;
	}
	/**
	 * Determine if password has a special character
	 * @param password The password used for checking
	 * @return True if password passes exception
	 * @throws LengthException Thrown when password doesn't pass exception
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		String specialChars = "\"!@#$%^&*()-_+=<>?,.|\\\"\'/{}][";

	    for (char c : password.toCharArray()) 
	    {
	        if (specialChars.indexOf(c) != -1) 
	            return true; 
	    }

	    throw new NoSpecialCharacterException();

	}
	/**
	 * Determine if password doesn't have same characters in a sequence
	 * @param password The password used for checking
	 * @return True if password passes exception
	 * @throws LengthException Thrown when password doesn't pass exception
	 */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
	    char previousChar = 0; 

	    for (char currentChar : password.toCharArray()) 
	    {
	        if (currentChar == previousChar)
	            throw new InvalidSequenceException();
	        previousChar = currentChar;
	    }

	    return true;
	}
	
}
