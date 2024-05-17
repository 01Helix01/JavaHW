import java.util.Random;

public class process implements Cloneable {
    public char name;
    public int arrivalTime;
    public int serviceTime;
    public int elapsedServiceTime;

    public int diskTime;
    public int diskActivity;
    public int diskActivity2;

    public int firstRun;
    public int startTime;
    public int finishTime;

    // Basic Constructor
    public process(char name, int arrivalTime, int serviceTime, int diskTime, int diskActivity, int diskActivity2) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.diskTime = diskTime;

        // For tracking service time
        this.elapsedServiceTime = 0;

        // For disk activity, -1 means it is NA for that process
        this.diskActivity = diskActivity;
        this.diskActivity2 = diskActivity2;

        // Will be set to 0 once accessed in certain algorithms
        this.firstRun = 1;
    }

    // Deep copy constructor
    public process(process other) {
        this.name = other.name;
        this.arrivalTime = other.arrivalTime;
        this.serviceTime = other.serviceTime;
        this.elapsedServiceTime = other.elapsedServiceTime;
        this.diskTime = other.diskTime;
        this.diskActivity = other.diskActivity;
        this.diskActivity2 = other.diskActivity2;
        this.firstRun = other.firstRun;
        this.startTime = other.startTime;
        this.finishTime = other.finishTime;
    }

    // Random Constructor
    public process(char name, int elapsed) {
        Random random = new Random();
        this.name = name;
        this.arrivalTime = random.nextInt(5) + elapsed;
        this.serviceTime = random.nextInt(15)+2;
        this.diskTime = random.nextInt(10);
        this.diskActivity = random.nextInt(2) - 1;
        this.diskActivity2 = random.nextInt(2) - 1;
        this.elapsedServiceTime = 0;
        this.firstRun = 1;
        this.startTime = 0;
        this.finishTime = 0;
    }

    // Override the clone() method to create a deep copy of the process object
    @Override
    public process clone() {
        return new process(this);
    }
}
