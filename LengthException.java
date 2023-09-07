package application;

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

public class LengthException extends Exception
{
	public LengthException()
	{
		super("The password must be at least 6 characters long");
	}
}
