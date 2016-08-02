/** 
*Program: Create a rational-number calculator
*File: Exercise13_16.java
*Summary:a program similar to Listing 7.9, 
*Calculator.java. Instead of using integers, 
*use rationals.
*Author: Charles Maple III
*Date: July 31,2016 
**/
public class Calculate 
{
	protected int numResult;
	protected int denResult;
	protected String[] parts;
	
	Calculate(String[] parts) 
	{
		this.parts = parts;
	}

	public String getResult() 
	{
		String theResult = "";
		int denominator1 = getDenom(parts[0]);
		int numerator1 = getNumer(parts[0]);
		
		int denominator2 = getDenom(parts[2]);
		int numerator2 = getNumer(parts[2]);
		
		switch (parts[1]) 
		{

		    case "-":
			    theResult = subtractFractions(numerator1, denominator1, numerator2, denominator2);
			    break;
			    
			case "+":
				theResult = addFractions(numerator1, denominator1, numerator2, denominator2);
				break;
				
			case "/":
				theResult = divideFractions(numerator1, denominator1, numerator2, denominator2);
				break;
				
			case "*":
				theResult = multiplyFractions(numerator1, denominator1, numerator2, denominator2);
				break;
		}
		return theResult;
	}
	
	public String addFractions(int numerator1, int denominator1, int numerator2, int denominator2) 
	{
		if (denominator1 == denominator2) 
		{
			denResult = denominator1;
			numResult = numerator1 + numerator2;
		}
		else 
		{
			int lowerDen = denominator1 < denominator2 ? denominator1 : denominator2;
			int higherDen = denominator1 < denominator2 ? denominator2 : denominator1;
			
			denResult = getLCM(lowerDen, higherDen);
			
			int tempNum1 = numerator1 * (denResult / denominator1);
			int tempNum2 = numerator2 * (denResult / denominator2);
			
			numResult = tempNum1 + tempNum2;
		}
		
		int greatestCommon = getGCM(numResult, denResult);
		
		return ((numResult / greatestCommon) + "/" + (denResult / greatestCommon));
	}
	
	public String subtractFractions(int denominator1, int denominator2, int numerator1, int numerator2) 
	{
		if (denominator1 == denominator2) 
		{
			denResult = denominator1;
			numResult = numerator1 - numerator2;
		}
		else 
		{
			int higherDen = denominator1 < denominator2 ? denominator2 : denominator1;
			int lowerDen = denominator1 < denominator2 ? denominator1 : denominator2;
			denResult = getLCM(lowerDen, higherDen);
			int tempNum1 = numerator1 * (denResult / denominator1);
			int tempNum2 = numerator2 * (denResult / denominator2);
			
			numResult = tempNum1 - tempNum2;
		}
		
		int greatestCommon = getGCM(numResult, denResult);
		return ((numResult / greatestCommon) + "/" + (denResult / greatestCommon));
	}
	
	public String multiplyFractions(int numerator1, int denominator1, int numerator2, int denominator2) 
	{		
		numResult = numerator1 * numerator2;
		denResult = denominator1 * denominator2;
		int greatestCommon = getGCM(numResult, denResult);
		return ((numResult / greatestCommon) + "/" + (denResult / greatestCommon));
	}

	public String divideFractions(int numerator1, int denominator1, int numerator2, int denominator2) 
	{
		int tempNum2 = denominator2;
		denominator2 = numerator2;
		numResult = numerator1 * tempNum2;
		denResult = denominator1 * denominator2;
		int greatestCommon = getGCM(numResult, denResult);
		
		return ((numResult / greatestCommon) + "/" + (denResult / greatestCommon));
	} 
	
	public static int getLCM(int min, int max) 
	{
		int result = 0;
		
		for(int i = 1; i <= min; i++) 
		{
		    int t = max * i;
			if(t % min == 0) 
			{
				result = t;
			  	break;
			}
		}
		
		return result;
    }
	
	public static int getGCM(int y, int z) 
	{
		if (y == 0)
	        return z;

	    while (z != 0) 
	    {
	        if (y > z)
	            y = y - z;
	        else
	            z = z - y;
	    }

	    return y;
	}
	
	public static int getNumer(String eq) 
	{
		String[] parts = eq.split("/");
		
		return Integer.parseInt(parts[0]);
	}
	
	public static int getDenom(String eq) 
	{
		String[] parts = eq.split("/");
		
		return Integer.parseInt(parts[1]);
	}
}