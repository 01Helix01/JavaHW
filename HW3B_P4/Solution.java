import java.util.*;

/* Analysis:
 * In this program, we will have three lines of input
 * Read each line and use 2 different interfaces (Engine & Steering)
 * In order to return
 */

/* Design:
 * Use a similar method as 3B part 3
 * where we use interfaces to prototype the getters
 * except this time, there are two seperate ones, meaning we must
 * implement both of them
 * Made Car static to get rid of the no enclosing instance error 
 */



public class Solution {
    public static void main(String[] args) {
        //Write your code here
    	Scanner in = new Scanner(System.in);
    	String c = in.nextLine();
    	String e = in.nextLine();
    	String s = in.nextLine();
    	
    	Car car = new Car(c, e, s);
    	
    	System.out.println(car.getCarModel());
    	System.out.println(car.getEngine());
    	System.out.println(car.getStearing());
    }
    
    
    interface Engine
    {
    	public String getEngine();
    }
    
    interface Steering
    {
    	public String getStearing();
    }
    
    static class Car implements Engine, Steering
    {
    	String carModel = "";
    	String streengModel = "";
    	String engineModel = "";
    	
    	public Car(String c, String e, String s)
    	{
    		this.carModel = c;
    		this.streengModel = s;
    		this.engineModel = e;
    	}
    	
    	public String getCarModel()
    	{
    		return this.carModel;
    	}
    	
    	public String getStearing()
    	{
    		return this.streengModel;
    	}
    	
    	public String getEngine()
    	{
    		return this.engineModel;
    	}
    }
}