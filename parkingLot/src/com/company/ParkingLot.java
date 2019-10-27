/*

 I attempted to use multi-threading for this assignment, to run multiple instances at the same time,
 however, it has been a struggle, so I did not use that method.

 This program generate a random number for time intervals based on the file input (number of cars).

 */



package com.company;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Vector;

public class ParkingLot extends Thread {

    public static int carCounter;
    public static int capacity = 5;
    public static LocalDate now;
    public static List<Cars> list = new ArrayList<>();
    public static Vector<Cars> carVect = new Vector<>(capacity);


    public static void main(String[] args) throws IOException, InterruptedException {
        ParkingSpot parkingSpot = new ParkingSpot();
        //carCounter = getNumberOfCars();
        String filename;
        while(carCounter == 0){
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter you file name as such: 'input.txt'. (note, file must be in directory)");
                filename = sc.nextLine();
                readFileData(filename);
            } catch (FileNotFoundException e){
                System.out.println("File Not Found, Try Again!");
            }
        }



        initCars(list, carCounter);
        setCars(list);
        //initList(taskList, carCounter);
        //printArray(list);
        //taskList.get(0).start();
        simulate(list, parkingSpot);

    }
    public static void readFileData(String s) throws IOException {
        File file = new File(s);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            if(line.contains("Car")){
                carCounter++;
            }
        }
    }
    public static int getNumberOfCars(){
        Scanner sc = new Scanner(System.in);
        Integer number = null;
        while (number == null) {
            try {
                number = Integer.parseInt(sc.next());
            } catch (InputMismatchException e) {
                System.out.println("bad input");
            }
        }
        return number;
    }
    public static void initCars(List<Cars> c, int a){
        for(int i = 0; i < a; i++){
            c.add(new Cars(i));
        }
    }
    public static void initList(List<Task> c, int a) throws InterruptedException {
        for(int i = 0; i < a; i++){
            c.add(new Task(i));
        }
    }
    public static void setCars(List<Cars> c){
        for(int i = 0; i < c.size(); i++){
            c.get(i).setInTime();
            c.get(i).setOutTime();
        }
    }
    public static void printArray(List<Cars> c){
        for(int i = 0; i < c.size(); i++){
            System.out.println(c.get(i).id);
            System.out.println(c.get(i).inTime);
            System.out.println(c.get(i).outTime);
            System.out.println("=====");
        }
    }
    public List<Cars> getList(){
        return list;
    }
    public static void printVector(Vector<Cars> v){
        for(int i = 0; i < capacity; i++){
            System.out.println("V: " + v.elementAt(i).id);
            //v.removeElementAt(i);
        }
    }
    public static void simulate(List<Cars> l, ParkingSpot p) throws InterruptedException {
        double interval = Math.ceil((double)l.size()/(double)capacity);
        System.out.println(interval);
        int count = 0;
        p.printVect();
        addCarsToGarage(l, carVect);









    }
    public static void addCarsToGarage(List<Cars> l, Vector<Cars> v) throws InterruptedException {
        int count = 0, iterator = 0;
        LocalDateTime timeCounter = LocalDateTime.now();
        do {
            try {
                while(v.size() != capacity){
                    v.add(l.get(count));
                    System.out.println("Added " + l.get(count).id + " after " + l.get(count).inTime + " seconds.");
                    count++;
                }
                System.out.println("Garage is now full. Waiting for a car to leave!");
                Thread.sleep((long) v.elementAt(iterator).outTime);
                v.removeElementAt(iterator);
                System.out.println("Removed " + v.elementAt(iterator).id + " after " + l.get(count).inTime + " seconds.");

            } catch(IndexOutOfBoundsException e){
                break;
            }
        } while(count < l.size());

    }


}