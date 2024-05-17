import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;

public class FlightPath {
  // Map to store the linked lists for each city
  private Map<String, LinkedList<City>> cities;
  
  public FlightPath() {
    // Initialize the map of cities
    cities = new HashMap<String, LinkedList<City>>();
  }

  public Map<String, LinkedList<City>> getCities() {
    // Return the map of cities
    return cities;
  }
  
  // Find the optimal path between the origin and destination cities using DFS
  public void findOptimalPath(String origin, String destination, String sortBy, int planNum) {
	  // Create a Stack to store the cities visited in the current path
	  Stack<String> path = new Stack<String>();

	  // Create a LinkedList to store the optimal path for the flight plan
	  LinkedList<String> optimalPath = new LinkedList<String>();

	  // Push the origin city onto the stack
	  path.push(origin);

	  // While the stack is not empty
	  while (!path.isEmpty()) {
	    // Get the current city from the top of the stack
	    String current = path.pop();

	    // If the current city is the destination city
	    if (current.equals(destination)) {
	      // Check if the current path is better than the optimal path for the flight plan
	      if (isBetterPath(path, optimalPath, sortBy)) {
	        // If it is, update the optimal path
	        optimalPath = new LinkedList<String>(path);
	        optimalPath.add(destination);
	      }
	    } else {
	      // If the current city is not the destination city, add its destinations to the stack and continue the search
	      LinkedList<City> destinations = cities.get(current);
	      if (destinations != null) {
	        for (City city : destinations) {
	          path.push(city.name);
	        }
	      }
	    }
	  }

	  // When the stack is empty, the search is complete and the optimal path for the flight plan has been found
	  // Sort the optimal path by time or cost, depending on the input
	  sortPath(optimalPath, sortBy);

	  // Print the results for the flight plan
	  printResults(origin, destination, optimalPath, planNum, sortBy);
	}

  
  	// Output results found from finding the optimal path
  	private void printResults(String origin, String destination, LinkedList<String> path, int planNum, String sortBy) {
	  // Print the results for the flight plan
	  System.out.println("Flight " + planNum + ": " + origin + ", " + destination + " (" + sortBy + ")");
	  System.out.println("Path: " + String.join(" -> ", path));

	  // Calculate the time and cost for the path
	  int time = 0;
	  double cost = 0;
	  for (int i = 0; i < path.size() - 1; i++) {
	    String city = path.get(i);
	    LinkedList<City> destinations = cities.get(city);
	    for (City cityDestination : destinations) {
	      if (cityDestination.name.equals(path.get(i + 1))) {
	        time += cityDestination.time;
	        cost += cityDestination.cost;
	        break;
	      }
	    }
	  }

	  // Print the time and cost for the path
	  System.out.println("Time: " + time);
	  System.out.println("Cost: " + cost);
	}

  
  	// Get Flight Time between two cities
  	private int getFlightTime(String city1, String city2) {
  		// Get the list of destinations for the city
  		LinkedList<City> destinations = cities.get(city1);

  		// Loop through the destinations for the city
  		for (City city : destinations) {
  	    // If the destination city is the one we're looking for, return its time
  	    if (city.name.equals(city2)) {
  	      return city.time;
  	    }
  	  }

  	  // If the destination city is not found in the list, return 0
  	  return 0;
  	}
  	
  	// Calculate total time it would take to travel through all cities in a given path
  	private int getPathTime(LinkedList<String> optimalPath) {
  		// Initialize the total time to 0
    	int time = 0;

    	// Loop through the cities in the path
    	for (int i = 0; i < optimalPath.size() - 1; i++) {
    		// Get the current city and its next destination
    	    String current = optimalPath.get(i);
    	    String destination = optimalPath.get(i + 1);

    	    // Get the time for the flight between the current city and its destination
    	    int flightTime = getFlightTime(current, destination);

    	    // Add the flight time to the total time
    	    time += flightTime;
    	  }
    	
    	// Return the total time for the path
    	return time;
    }
  	
  	public double getPathCost(LinkedList<String> path) {
  	  double cost = 0;
  	  for (int i = 0; i < path.size() - 1; i++) {
  	    String city1 = path.get(i);
  	    String city2 = path.get(i + 1);
  	    LinkedList<City> destinations = cities.get(city1);
  	    for (City city : destinations) {
  	      if (city.name.equals(city2)) {
  	        cost += city.cost;
  	        break;
  	      }
  	    }
  	  }
  	  return cost;
  	}
  	
  	// Given stack of cities representing current path, compare to the LinkedList found previously for optimal path
  	private boolean isBetterPath(Stack<String> path, LinkedList<String> optimalPath, String sortBy) {
  	  // Calculate the time and cost for the current path
  	  int time = 0;
  	  double cost = 0;
  	  for (int i = 0; i < path.size() - 1; i++) {
  	    String city = path.get(i);
  	    String nextCity = path.get(i + 1);
  	    LinkedList<City> destinations = cities.get(city);
  	    if (destinations != null) {
  	      for (City destination : destinations) {
  	        if (destination.name.equals(nextCity)) {
  	          time += destination.time;
  	          cost += destination.cost;
  	          break;
  	        }
  	      }
  	    }
  	  }

  	  // Compare the time and cost of the current path with the optimal path
  	  if (optimalPath.isEmpty()) {
  	    // If the optimal path is empty, the current path is the optimal path
  	    return true;
  	  } else if (sortBy.equals("T")) {
  	    // If the paths are sorted by time, return true if the current path has a shorter time than the optimal path
  	    return time < getPathTime(optimalPath);
  	  } else if (sortBy.equals("C")) {
  	    // If the paths are sorted by cost, return true if the current path has a lower cost than the optimal path
  	    return cost < getPathCost(optimalPath);
  	  } else {
  	    // If the sort type is not recognized, return false
  	    return false;
  	  }
  	}
  	
  	// Sort the path given based on if sortBy is a T or C
  	private void sortPath(LinkedList<String> path, String sortBy) {
  		// Sort the optimal path by time or cost, depending on the sortBy variable
  		Collections.sort(path, (c1, c2) -> {
  			LinkedList<City> destinations1 = cities.get(c1);
  			LinkedList<City> destinations2 = cities.get(c2);
	    if (sortBy.equals("T")) {
	      // If sorting by time, compare the time for each pair of cities
	      for (City destination1 : destinations1) {
	        for (City destination2 : destinations2) {
	          if (destination1.name.equals(c2) && destination2.name.equals(c1)) {
	            return Integer.compare(destination1.time, destination2.time);
	          }
	        }
	      }
	    } else {
	      // If sorting by cost, compare the cost for each pair of cities
	      for (City destination1 : destinations1) {
	        for (City destination2 : destinations2) {
	          if (destination1.name.equals(c2) && destination2.name.equals(c1)) {
	            return Double.compare(destination1.cost, destination2.cost);
	          }
	        }
	      }
	    }
	    return 0;
	  });
	}

  	// Read from the filePath to construct original map
  	public void readInputFromFile(String filePath) {
  		// Use a try-with-resources statement to read the input file
  		try (Scanner scanner = new Scanner(new File(filePath))) {
  			// Read the number of cities
  			int numCities = Integer.parseInt(scanner.nextLine());

  			// Read each city and its destinations
		    for (int i = 0; i < numCities; i++) {
		      String[] line = scanner.nextLine().split("\\|");
		      String cityName = line[0];
		      String destination = line[1];
		      int time = Integer.parseInt(line[2]);
		      double cost = Double.parseDouble(line[3]);
	      
		      // Create a new City object with the input data
		      City newCity = new City(destination, time, cost);
	
		      // Add the city to the map
		      LinkedList<City> destinations;
		      if (cities.containsKey(cityName)) {
		        // The city already exists in the map, get its destinations
		        destinations = cities.get(cityName);
		      } else {
		        // The city does not exist in the map, create a new list of destinations for it
		        destinations = new LinkedList<City>();
		        cities.put(cityName, destinations);
		      }
	
		      // Add the new City object to the list of destinations for the city
		      destinations.add(newCity);
	    }
	  } catch (FileNotFoundException e) {
	    System.err.println("Error: Could not find file at " + filePath);
	  }
	}

  
  public static void main(String[] args) {
	  // Create a new FlightPath object
	  FlightPath flightPath = new FlightPath();

	  // Read the input from the file and add the cities and their destinations to the map
	  flightPath.readInputFromFile("FlightData1.txt");

	  // Read the flight plans from the input
	  Scanner scanner = new Scanner(System.in);
	  // Get the number of flight plans from the input
	  int numPlans = Integer.parseInt(scanner.nextLine());

	  // Process each flight plan from the input
	  for (int i = 0; i < numPlans; i++) {
		  String[] plan = scanner.nextLine().split("\\\\|");
	    String origin = plan[0];
	    String destination = plan[1];
	    String sortBy = plan[2];
	    // Find the optimal path for the flight plan and print the results
	    flightPath.findOptimalPath(origin, destination, sortBy, i + 1);
	  }

	  // Close the input
	  scanner.close();
  }
}
