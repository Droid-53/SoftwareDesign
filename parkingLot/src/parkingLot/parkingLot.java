package parkingLot;
import java.util.*;
import java.time.LocalTime;
import java.io.*;
import java.util.concurrent.*;
import java.util.Vector.*;

//10 Car Parking Garage
//$5/second parking limit
// input1_number.txt



public class parkingLot {
	static int totalCarsInFile = 1;
	static int garageSize = 10;
	static int occupancy = 0;
	static int totalCarCounter = 0;
	
	public static boolean isFull()
	{
		return(occupancy == garageSize);
	}
	public static void main(String[] args) throws InterruptedException, IOException {
		int menuSelection = -1;
		garageSize = getGarageSize();
		String carName = "car";
		Cars carArray[] = new Cars[garageSize];	
		
		
		while(menuSelection != 0) {
			menuSelection = start();
			menu(menuSelection, carArray);
		}
		
	}
	public static void printVectorItems(Cars [] v) {
		for(int i = 0; i < v.length; i++) {
			System.out.println("ELEMENT " + i + ": " + v[i]);
			System.out.println("ELEMENT " + i + "Name: " + v[i].name);
			System.out.println("ELEMENT " + i + "ID: " + v[i].id);
			System.out.println("ELEMENT " + i + "HasPaid: " + v[i].hasPaid);
			System.out.println("ELEMENT " + i + "HasTicket: " + v[i].hasTicket);
		}
		System.out.println();
	}
	
	
	public static void readInputFile(Cars [] v) throws IOException {
		String inputFile = "src/input1_number.txt";
		int g = 0, i = 0;
		String carName = "";
		String line = "";
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		try {
			while((line = reader.readLine()) != null) {
				Scanner scanner = new Scanner(line);
				carName = scanner.next();
				g = scanner.nextInt();
				v[i].name = carName;
				v[i].waitTime = g;
				v[i].id = i;
				System.out.println("Car " + i + " has entered the Garage.");
				System.out.println("WaitTime:  " + g);
				TimeUnit.SECONDS.sleep(g);
				System.out.println("Car " + i + " has left the Garage.");
				i++;
			}
		} catch(Exception e){
		    e.printStackTrace();
		}
		
		
	}
	public static int getGarageSize() throws IOException {
		String inputFile = "src/input1_number.txt";
		int g = 0;
		//Scanner input = new Scanner(System.in);
		//inputFile = inputFile + input.next();
		String line = null;
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		while((line = reader.readLine()) != null) {
			Scanner scanner = new Scanner(line);
			g++;
		}
		return g;
	}	
	static int start()
	{

	    Scanner input = new Scanner(System.in);
		int selection = 0;
		System.out.println();
		System.out.println("This is a Parking Lot Simulator. Select an option below:");
		System.out.println("1. Show Total Lot Capacity");
		System.out.println("2. Simulate");
		
	    selection = input.nextInt();
	    return selection;
	}
	public static void menu(int selection, Cars [] carVector) throws InterruptedException, IOException {
		switch(selection) {
		case -1:
			System.exit(0);
		case 1:
			System.out.println("Total Capacity: " + totalCarsInFile);
			break;
		case 2:
			readInputFile(carVector);
			break;
		}
	}
	
	
	
}







