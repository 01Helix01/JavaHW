import java.util.*;
import java.lang.*;
import java.io.*;

//--------Analysis and Design----------------------
/* Analysis:
 * In this program, we will create the Triangle class
 * We must first create the constructors
 * Use default constructor if triangle is not valid
 * Next find area and perimeter
 * Use toString to return string representation of Object
 */

/* Design:
 * If mesurements are given, use the Triangle constructor
 * before using it, check to make sure triangle is valid (use isTriangle function)
 * isTriangle makes use of the Triangle Inequality theorem, which states that the third side is
 * always smaller than the other two added together.
 * if not, use the default constructor.
 * Next, use the given measurements to find area and perimeter
 * For Area, I used Heron's formula.
 * For Perimeter, we just add all the sides.
 */



//--------Write your code here---------------------
public class Triangle extends GeometricObject{
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	
	// Default constructor
	public Triangle()
	{
		this.side1 = 1.0;
		this.side2 = 1.0;
		this.side3 = 1.0;
	}
	
	// Creates a triangle of designated side length
	public Triangle(double side1, double side2, double side3)
	{
		Boolean validTriangle = isTriangle(side1, side2, side3);
		
		// Check if sides are valid
		if (validTriangle)
		{
			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
		}
	}

	// Determine if triangle with given sides is a valid triangle
	public Boolean isTriangle(double x, double y, double z)
	{
		Boolean isIt = true;
		
		// apply Triangle Inequality Theorem
		double first = z + y;
		double second = z + x;
		double third = x + y;
		
		if(first <= z)
			isIt = false;
			
		if(second <= y)
			isIt = false;
			
		if(third <=z)
			isIt = false;
		
		return isIt;
	}

	// Return the area
	public double getArea()
	{
		// Apply Heron's formula
		double s = (side1 + side2 + side3)/ 2;
		
		double area = Math.sqrt(s*(s - side1)*(s - side2)*(s - side3));
		
		return area;
	}
	
	// Return the perimeter
	public double getPerimeter()
	{
		// Add all sides
		double perimeter = side1 + side2 + side3;
		
		return perimeter;
	}
	
	// Return string description
	public String toString()
	{
		return "Triangle: side1 = " + this.side1 + " side2 = " + this.side2 + " side3 = " + this.side3 + super.toString();
	}
	
	
	// Getters
	public double getSide1(Triangle t)
	{
		return t.side1;
	}
	
	public double getSide2(Triangle t)
	{
		return t.side2;
	}
	
	public double getSide3(Triangle t)
	{
		return t.side3;
	}
	
}