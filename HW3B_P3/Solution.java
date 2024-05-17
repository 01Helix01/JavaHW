import java.util.*;

/* Analysis:
 * In this program, we will create an interface named Car that contains:
 * void displaySpeed() and void increaseSpeed()
 * These will lead to Suzuki, which interfaces with Car
 * increaseSpeed will add speed parameter to the current speed
 * displaySpeed simply returns the current speed
 */

/* Design:
 * Wrote the driver program, which takes two digits, one for original speed and one for speed to be added
 * Driver creates a new instance of car using Suzuki
 * Call increase speed and passes number to increase by into it
 * Display initial speed plus speed added
 */

public class Solution {
    public static void main(String[] args) {
        //Write your code here
    	
    	Scanner in = new Scanner(System.in);
    	
    	// s is speed and i is how much speed will increase
    	int s = in.nextInt();
    	int i = in.nextInt();
    	
    	Car car = new Suzuki(s);
    	car.increaseSpeed(i);
    	car.displaySpeed();
    }
}

interface Car
{
	public void displaySpeed();
	
	public void increaseSpeed(int speed);
}

class Suzuki implements Car
{
	private int currentSpeed;
	
	// Constructor
	public Suzuki (int speed)
	{
		this.currentSpeed = speed;
	}
	
	public void increaseSpeed (int speed)
	{
		currentSpeed += speed;
	}
	
	public void displaySpeed ()
	{
		System.out.println(currentSpeed);
	}
	
}