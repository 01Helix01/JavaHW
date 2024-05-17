import java.util.concurrent.TimeUnit;

public class sleeper {
	static String doSleep; // doSleep just lets the user choose to disable sleeping to make testing easier
	
	public static void sleep() {
			try {
				TimeUnit.SECONDS.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("SLEEPER CANNOT SLEEP");
				e.printStackTrace();
			}
	}
		
		public static void sleep(int sleepTime) {
				try {
					TimeUnit.SECONDS.sleep(0);					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
}