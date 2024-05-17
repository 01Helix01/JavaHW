import java.util.*;
import java.lang.*;
import java.io.*;

public class Driver{
	public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();
        String color = input.next();
        boolean filled = input.nextBoolean();

    
        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);
        triangle.setFilled(filled);
        System.out.printf("%.2f",triangle.getArea());
        System.out.println();
        System.out.printf("%.2f",triangle.getPerimeter());
        System.out.println();
        System.out.println(triangle);
  }
       
  
	
}
