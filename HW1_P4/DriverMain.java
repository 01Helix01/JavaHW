class DriverMain{
	public static void main(String args[]){
		ProblemSolution problemSolution  = new ProblemSolution();
        // Print the result
        if(problemSolution.isValid())     
            System.out.print("Valid SSN");
        else
            System.out.print("Invalid SSN");
	}
}