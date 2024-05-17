import java.util.List;
import java.util.ArrayList;


public class City {
	public String name;
	public int time;
	public double cost;

  // List of destinations for the city
  public List<City> destinations;


  public City(String name, int time, double cost) {
	    this.name = name;
	    this.time = time;
	    this.cost = cost;
	    
	    // Create a new list of destinations for the city
	    this.destinations = new ArrayList<City>();
  }


  public void addDestination(City destination, int time, double cost) {
    // Add the destination city and its time and cost to the list of destinations for the city
    destination.time = time;
    destination.cost = cost;
    destinations.add(destination);
  }
}

