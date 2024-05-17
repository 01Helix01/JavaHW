import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
//import java.util.Scanner;


public class main {
	public static void main(String[] args) {
		
		/* Unused code, could be implemented for faster testing
		Scanner s = new Scanner(System.in);
		System.out.println("Would you like to analyze a specific algorithm? (Y/N)");
		String specAlgo = s.nextLine();
		
		System.out.println("Would you like to run in real time simulation mode? (Y/N)");
		String realTime = s.nextLine();
		sleeper.doSleep = realTime;
		*/
		
		
		ArrayList<process> Processes = new ArrayList<process>();
		Processes.add(new process('A', 0, 6, 1, 3, -1));
		Processes.add(new process('B', 2, 12, 2, 4, 8));
		Processes.add(new process('C', 4, 8, 1, 4, -1));
		Processes.add(new process('D', 6, 10, 0, -1, -1));
		Processes.add(new process('E', 8, 4, 2, 1, 3));
		Processes.add(new process('F', 10));
		Processes.add(new process('G', 12));
		Processes.add(new process('H', 14));
		Processes.add(new process('I', 16));
		Processes.add(new process('J', 18));
		Processes.add(new process('K', 20));
		Processes.add(new process('L', 22));
		Processes.add(new process('M', 24));
		Processes.add(new process('N', 26));
		Processes.add(new process('O', 28));
		Processes.add(new process('P', 30));

		// Create a deep copy of the Processes list
		ArrayList<process> fcfsProc = new ArrayList<process>();
		ArrayList<process> robinProc = new ArrayList<process>();
		ArrayList<process> srtProc = new ArrayList<process>();
		ArrayList<process> hrrnProc = new ArrayList<process>();
		
		for (process p : Processes) {
			fcfsProc.add(p.clone());
			robinProc.add(p.clone());
			srtProc.add(p.clone());
			hrrnProc.add(p.clone());
		}

		
		// Test FCFS - first come first serve
		
		fcfs(fcfsProc);
		System.out.println();
		
		// Test Round Robin
		roundRobin(Processes);
		System.out.println();
		
		// Test SRT - shortest remaining time
		srt(srtProc);
		System.out.println();
		
		// Test HRRN - highest response rate next
		hrrn(hrrnProc);
		System.out.println();
		
	}

	
	// First Come First Serve //
	public static void fcfs(ArrayList<process> Processes) {
		// Create queue and start the timer
        Queue<process> processQueue = new LinkedList<process>();
        ArrayList<Double> responseTimes = new ArrayList<Double>();
        
        int currentTime = 0;
        
        // Add processes to queue
        for (process process : Processes) {
            processQueue.add(process);
        }
        
        
        System.out.println("Now running the [FCFS] Algorithm");
    	System.out.println("Name\t\tArrival\t\tService\t\tDisk\t\tStart\t\tFinish\t\tTurnaround\t\tTurnaround/Service\t\t");
    	
        while (!processQueue.isEmpty()) {
        	// Get next process
        	process process = processQueue.poll();

        	
        	// Wait until the process arrives
        	if (process.arrivalTime > currentTime) {
        		sleeper.sleep(process.arrivalTime - currentTime);
        	}
        	
        	// Set start time
        	process.startTime = currentTime;
        	
        	// Run the process until it is completed
        	Boolean processCompletion = false;
        	while (!processCompletion)
        	{

        		// Make request for IO if necessary during this time the process is blocked
        		if (process.diskActivity == process.elapsedServiceTime || process.diskActivity2 == process.elapsedServiceTime) {
        			sleeper.sleep(process.diskTime);
        			currentTime += process.diskTime;
        		}
        		
        		// If processRuntime has reached serviceTime, it is completed
        		if(process.serviceTime <= process.elapsedServiceTime) {
        			process.finishTime = currentTime;
        			processCompletion = true;
        		}
        		
        		// If this has not happened, add to both counters and continue to loop
        		else {
        			++process.elapsedServiceTime;
        			++currentTime;
        			sleeper.sleep();
        		}
        	}
        	
        	// Process is finished
            double turnaroundTime = (double) (process.finishTime - process.arrivalTime);
            double responseTime = (double) (process.startTime - process.arrivalTime);
            responseTimes.add(responseTime);
            
            
            double turnaroundOverService = turnaroundTime / process.serviceTime;
            System.out.println(process.name + "\t\t" + process.arrivalTime + "\t\t" + process.serviceTime + "\t\t"
                    + process.diskTime + "\t\t" + process.startTime + "\t\t" + process.finishTime + "\t\t"
                    + turnaroundTime + "\t\t\t" + String.format("%.2f", turnaroundOverService));
        }
        
        // Calculate throughput (num processes completed / time taken)
        double throughput = 15 / (double)currentTime;
        System.out.println("Throughput: " + String.format("%.4f", throughput));
       
        // Calculate average response time
        double sum = 0;
        for (double time : responseTimes) {
            sum += time;
        }
        double average = sum / responseTimes.size();
        System.out.println("Average response time: " + String.format("%.2f", average));
	}
	
	
	
	// Round Robin //
	public static void roundRobin(ArrayList<process> Processes) {
		
		// Set time slice
		int timeQuantum = 2;
		
		// Create queue and start the timer
        Queue<process> processQueue = new LinkedList<process>();
        ArrayList<Double> responseTimes = new ArrayList<Double>();
        int currentTime = 0;

        // Add processes to queue
        for (process process : Processes) {
            processQueue.add(process);
        }

        System.out.println("Now running the [Round Robin] Algorithm");
    	System.out.println("Name\t\tArrival\t\tService\t\tDisk\t\tStart\t\tFinish\t\tTurnaround\t\tTurnaround/Service\t\t");
    	
        // Process queue until all processes are completed
        while (!processQueue.isEmpty()) {
            // Get next process
            process process = processQueue.poll();

            // Wait until process arrives
            if (process.arrivalTime > currentTime) {
            	sleeper.sleep(process.arrivalTime - currentTime);
            }
            
        	// Set start time if process first time running
            if(process.firstRun == 1) {
            	process.startTime = currentTime;
            	process.firstRun = 0;
            }

            // Run process for time quantum
            int remainingTime = timeQuantum;
            while (remainingTime > 0) {
                // Run process for time quantum or until it finishes


        		// Make request for IO if necessary during this time the process is blocked
        		if (process.diskActivity == process.elapsedServiceTime || process.diskActivity2 == process.elapsedServiceTime) {
        			sleeper.sleep(process.diskTime);
        			currentTime += process.diskTime;
        			// Do not decrement remainingTime while CPU is blocked
        		}
        		
        		
        		// Increment timers
        		++process.elapsedServiceTime;
        		++currentTime;
        		--remainingTime;
        		sleeper.sleep();
        		
        		// Debugging message to see how Round Robin functions
        		// System.out.println("DEBUG LOG: Process: " + process.name + " has " + process.elapsedServiceTime + " service out of " + process.serviceTime);
        		
        		// If processRuntime has reached serviceTime, it is completed
        		if(process.serviceTime <= process.elapsedServiceTime) {
        			process.finishTime = currentTime;
        			
        			// Process is finished
                    double turnaroundTime = (double) (process.finishTime - process.arrivalTime);
                    double responseTime = (double) (process.startTime - process.arrivalTime);
                    responseTimes.add(responseTime);
                    
                    double turnaroundOverService = turnaroundTime / process.serviceTime;
                    System.out.println(process.name + "\t\t" + process.arrivalTime + "\t\t" + process.serviceTime + "\t\t"
                            + process.diskTime + "\t\t" + process.startTime + "\t\t" + process.finishTime + "\t\t"
                            + turnaroundTime + "\t\t\t" + String.format("%.2f", turnaroundOverService));
                	
                	break;
        		}
        			
            	// Once ran for the duration of the time slice, add process back to queue
            	if(remainingTime == 0) {
            		processQueue.add(process);
            		break;
            	}
            }
        }
        
        // Calculate throughput (num processes completed / time taken)
        double throughput = 15 / (double)currentTime;
        System.out.println("Throughput: " + String.format("%.4f", throughput));

        // Calculate average response time
        double sum = 0;
        for (double time : responseTimes) {
            sum += time;
        }
        double average = sum / responseTimes.size();
        System.out.println("Average response time: " + String.format("%.2f", average));
	}
	
	
	// Shortest Remaining Time //
	public static void srt(ArrayList<process> Processes) {
		// Create queue and start the timer
		PriorityQueue<process> processQueue = new PriorityQueue<process>(Processes.size(), Comparator.comparingInt(p -> p.arrivalTime));
	    processQueue.addAll(Processes);
	    ArrayList<Double> responseTimes = new ArrayList<Double>();
        int currentTime = 0;


        System.out.println("Now running the [SRT] Algorithm");
    	System.out.println("Name\t\tArrival\t\tService\t\tDisk\t\tStart\t\tFinish\t\tTurnaround\t\tTurnaround/Service\t\t");
    	
        // Get first process in the queue
        process process = processQueue.poll();
    	
    	
        while (process != null) {
            // Check if the process has arrived
            if (process.arrivalTime > currentTime) {
                sleeper.sleep(process.arrivalTime - currentTime);
                currentTime = process.arrivalTime;
            }

            // Set start time if process first time running
            if (process.firstRun == 1) {
                process.startTime = currentTime;
                process.firstRun = 0;
            }

            // Make request for IO if necessary during this time the process is blocked
            if (process.diskActivity == process.elapsedServiceTime || process.diskActivity2 == process.elapsedServiceTime) {
                sleeper.sleep(process.diskTime);
                currentTime += process.diskTime;
            }

            // Increment elapsed service time and current time
            ++process.elapsedServiceTime;
            ++currentTime;
            sleeper.sleep();

            // Check if the process has completed
            if (process.serviceTime <= process.elapsedServiceTime) {
                process.finishTime = currentTime;

                // Process is finished
                double turnaroundTime = (double) (process.finishTime - process.arrivalTime);
                double responseTime = (double) (process.startTime - process.arrivalTime);
                responseTimes.add(responseTime);
                double turnaroundOverService = turnaroundTime / process.serviceTime;
                
                System.out.println(process.name + "\t\t" + process.arrivalTime + "\t\t" + process.serviceTime + "\t\t"
                        + process.diskTime + "\t\t" + process.startTime + "\t\t" + process.finishTime + "\t\t"
                        + turnaroundTime + "\t\t\t" + String.format("%.1f", turnaroundOverService));

                // Remove the process from the queue


                // Remove the process from the queue
                process = processQueue.poll();
            }

            // Check if there are any other processes that have arrived before the current process finishes
            else {
                process shortestProcess = process;
                for (process p : processQueue) {
                    if (p.arrivalTime <= currentTime && p.serviceTime - p.elapsedServiceTime < shortestProcess.serviceTime - shortestProcess.elapsedServiceTime) {
                        shortestProcess = p;
                    }
                }
                if (shortestProcess != process) {
                    processQueue.remove(shortestProcess);
                    processQueue.add(process);
                    process = shortestProcess;
                }
            }
         }
        
        // Calculate throughput (num processes completed / time taken)
        double throughput = 15 / (double)currentTime;
        System.out.println("Throughput: " + String.format("%.4f", throughput));
        
        // Calculate average response time
        double sum = 0;
        for (double time : responseTimes) {
            sum += time;
        }
        double average = sum / responseTimes.size();
        System.out.println("Average response time: " + String.format("%.2f", average));
    }
    	
	
	
	// Highest Response Rate Next //
	public static void hrrn(ArrayList<process> Processes) {
	    // Create queue and start the timer
	    PriorityQueue<process> processQueue = new PriorityQueue<>(Processes.size(), Comparator.comparingInt(p -> p.arrivalTime));
	    processQueue.addAll(Processes);
	    ArrayList<Double> responseTimes = new ArrayList<Double>();
	    int currentTime = 0;

	    System.out.println("Now running the [HRRN] Algorithm");
	    System.out.println("Name\t\tArrival\t\tService\t\tDisk\t\tStart\t\tFinish\t\tTurnaround\t\tTurnaround/Service\t\t");

	    // Get first process in the queue
	    process currentProcess = processQueue.poll();

	    while (currentProcess != null) {
	        // Check if the process has arrived
	        if (currentProcess.arrivalTime > currentTime) {
	            sleeper.sleep(currentProcess.arrivalTime - currentTime);
	            currentTime = currentProcess.arrivalTime;
	        }

	        // Set start time if process first time running
	        if (currentProcess.firstRun == 1) {
	            currentProcess.startTime = currentTime;
	            currentProcess.firstRun = 0;
	        }

	        // Make request for IO if necessary during this time the process is blocked
	        if (currentProcess.diskActivity == currentProcess.elapsedServiceTime || currentProcess.diskActivity2 == currentProcess.elapsedServiceTime) {
	            sleeper.sleep(currentProcess.diskTime);
	            currentTime += currentProcess.diskTime;
	        }

	        // Increment elapsed service time and current time
	        ++currentProcess.elapsedServiceTime;
	        ++currentTime;
	        sleeper.sleep();

	        // Check if the process has completed
	        if (currentProcess.serviceTime <= currentProcess.elapsedServiceTime) {
	            currentProcess.finishTime = currentTime;

	            // Process is finished
	            double turnaroundTime = (double) (currentProcess.finishTime - currentProcess.arrivalTime);
	            double responseTime = (double) (currentProcess.startTime - currentProcess.arrivalTime);
	            responseTimes.add(responseTime);
	            
	            double turnaroundOverService = turnaroundTime / currentProcess.serviceTime;
	            System.out.println(currentProcess.name + "\t\t" + currentProcess.arrivalTime + "\t\t" + currentProcess.serviceTime + "\t\t"
	                    + currentProcess.diskTime + "\t\t" + currentProcess.startTime + "\t\t" + currentProcess.finishTime + "\t\t"
	                    + turnaroundTime + "\t\t\t" + String.format("%.1f", turnaroundOverService));

	            // Remove the process from the queue
	            processQueue.remove(currentProcess);

	            // Get the highest response ratio process from the queue
	            double highestResponseRatio = 0;
	            process nextProcess = null;
	            for (process p : processQueue) {
	                double responseRatio = (double) (currentTime - p.arrivalTime + p.serviceTime) / p.serviceTime;
	                if (responseRatio > highestResponseRatio) {
	                    highestResponseRatio = responseRatio;
	                    nextProcess = p;
	                }
	            }

	            // Go to next process
	            currentProcess = nextProcess;
	        }

	        // Check if there are any other processes that have arrived before the current process finishes
	        else {
	            double currentResponseRatio = (double) (currentTime - currentProcess.arrivalTime + currentProcess.serviceTime) / currentProcess.serviceTime;
	            process highestRatioProcess = currentProcess;
	            for (process p : processQueue) {
	                if (p.arrivalTime <= currentTime) {
	                    double responseRatio = (double) (currentTime - p.arrivalTime + p.serviceTime) / p.serviceTime;
	                    if (responseRatio > currentResponseRatio) {
	                        highestRatioProcess = p;
	                        currentResponseRatio = responseRatio;
	                    }
	                }
	            }

	            if (highestRatioProcess != currentProcess) {
	                processQueue.remove(highestRatioProcess);
	                processQueue.add(currentProcess);
	                currentProcess = highestRatioProcess;
	            }
	        }
	    }
	    
        // Calculate throughput (num processes completed / time taken)
        double throughput = 15 / (double)currentTime;
        System.out.println("Throughput: " + String.format("%.4f", throughput));
        
        // Calculate average response time
        double sum = 0;
        for (double time : responseTimes) {
            sum += time;
        }
        double average = sum / responseTimes.size();
        System.out.println("Average response time: " + String.format("%.2f", average));
	}
}


