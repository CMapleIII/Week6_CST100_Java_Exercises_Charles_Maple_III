/** 
*Program: The Octagon Class
*File: Exercise13_11.java
*Summary:test program that 
*creates an Octagonobject with 
*side value 5 and displays its 
*area and perimeter. Create a 
*new object using the clone method 
*and compare the two objects using 
*the compareTomethod.
*Author: Charles Maple III
*Date: July 31,2016 
**/
public class Exercise13_11 
{
	public static void main(String[] args)
	{
		Octagon oct1 = new Octagon(10);
		Octagon oct2 = (Octagon)oct1.clone();
		
		System.out.println("compareTo: " + (oct1.compareTo(oct2) == 0));
        System.out.println("equals: " + oct1.equals(oct2));
        System.out.println("Have the same reference? " + (oct1 == oct2));
	}
}
