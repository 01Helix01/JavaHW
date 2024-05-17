import java.util.*;
import java.lang.*;
import java.io.*;
class ProblemSolution{
	// Initialize variables for distance, miles per gallon, price per gallon, gallons needed, and cost
	double dst;
	double mpg;
	double ppg;
	double gal;
	double cost;
	
    public double getCost(){
        Scanner input = new Scanner(System.in);
        
        // Get distance, miles per gallon, and price per gallon - in that order
        dst = input.nextDouble();
        mpg = input.nextDouble();
        ppg = input.nextDouble();
        
        // distance divided by miles per gallon equals the total gallons needed to make the trip
        gal = dst / mpg;
        
        // gallons needed times cost per gallon equals the total cost of the trip
        cost = gal * ppg;
        
        return cost;
	}
}

