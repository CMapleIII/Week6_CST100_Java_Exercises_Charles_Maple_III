/** 
*Program: Create a rational-number calculator
*File: Exercise13_16.java
*Summary:a program similar to Listing 7.9, 
*Calculator.java. Instead of using integers, 
*use rationals.
*Author: Charles Maple III
*Date: July 31,2016 
**/

import java.util.Scanner;

public class Exercise13_16
{
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		System.out.println("Enter A Rational Equation: ");
		
		String ratEquation = input.nextLine();
		String[] sectionsOfEquation = ratEquation.split(" ");
		
		Calculate calcEquation = new Calculate(sectionsOfEquation);
		
		System.out.println(ratEquation + " = " + calcEquation.getResult());
	}
}