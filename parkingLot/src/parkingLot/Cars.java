package parkingLot;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;  





public class Cars {
	
	static String name = "";
	static int id = 0;
	static int waitTime = 0;
	static boolean hasTicket = false;
	static boolean hasPaid = false;
	static LocalTime timeIn, timeOut;
	 static long duration;
	
	public static void main(String[] args) {
		printCarData();
	}
	
	public static void hasEnteredGarage() {
		timeIn = LocalTime.now();
		hasTicket = true;
		hasPaid = false;
	}
	
	public void hasLeftGarage() {
		timeOut = LocalTime.now();
		hasPaid = true;
		hasTicket = false;
		duration = ChronoUnit.SECONDS.between(timeIn, timeOut);  
	}
	
	public void setID(int idValue) {
		id = idValue;
	}
	
	public static void printCarData() {

		System.out.println("Name: " + name);
		System.out.println("Time In: " + timeIn);
		System.out.println("Time Out: " + timeOut);
		System.out.println("Has Ticket? " + hasTicket);
		System.out.println("Paid Ticket? " + hasPaid);
	}
	
	/*
	public void insertTicket() throws InterruptedException {
		hasTicket = false;
		System.out.println("Confirming Purchase, Please Wait...");
		Thread.sleep(5000);
		System.out.println("Purchase Successful!");
		hasPaid = true;
	}
	*/
	
}
