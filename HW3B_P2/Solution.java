import java.util.*;


/* Analysis:
 * Create Suzuki class as a subclass of
 * the abstract class Car
 * Car will contain the model and speed parameters
 * getModel and getMaxSpeed belong to Suzuki class
 */

/* Design:
 * Created the driver first to create a new car using class Suzuki
 * then get model and speed then print them
 * Wrote the abstract class Car and initialized model and speed
 * Created our Car constructor
 * Created Suzuki - a subclass of Car
 * Suzuki contains the getters for model and speed
 */

public class Solution {
    public static void main(String[] args) {
        //Write your code here
    	
    	Scanner in = new Scanner(System.in);
    	Car car = new Suzuki(in.nextLine(), in.nextInt());
    	System.out.println(car.getModel());
    	System.out.println(car.getMaxSpeed());
    }
}

abstract class Car
{
	public String model;
	public int speed;
	
	public Car (String model, int speed)
	{
		this.model = model;
		this.speed = speed;
	}
	
	public abstract String getModel();
	
	public abstract int getMaxSpeed();
}

class Suzuki extends Car
{
	public Suzuki (String model, int speed)
	{
		super(model, speed);
	}
	
	@Override
	public String getModel()
	{
		return model;
	}
	
	@Override
	public int getMaxSpeed()
	{
		return speed;
	}
}