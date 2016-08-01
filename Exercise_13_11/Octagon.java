/** 
*Program: The Octagon Class
*File: Octagon.java
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

public class Octagon extends GeometricObject implements Cloneable 
{
    double side;
    
    public Octagon() 
    {
        this(5);
    }

    public Octagon(double side) 
    {
        this.side = side;
    }

    @Override
    public double getArea() 
    {
        return (2.0 + 4.0 / Math.sqrt(2) * side * side);
    }

    @Override
    public double getPerimeter() 
    {
        return side * 8;
    }

    public Object clone() 
    {
        Object o = null;
        try 
        {
            o = super.clone();
        } 
        catch (CloneNotSupportedException ex) 
        {
            ex.printStackTrace();
        }
        return o;
    }

    @Override
    public boolean equals(Object o) 
    {
        return o instanceof Octagon && getArea() == ((Octagon)o).getArea();
    }
}