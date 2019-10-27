package com.company;
import java.util.*;

public class Task extends Thread {

    int id;
    public Task(int a) throws InterruptedException {
        id = a;
        ParkingLot lot = new ParkingLot();
        List<Cars> list = lot.getList();



        double inTime = list.get(id).getInTime();
        double outTime = list.get(id).getOutTime();
        sleep((long) inTime);
        System.out.println("Car " + id + " has been added to Garage at " + inTime);
        sleep((long) outTime);
        System.out.println("Car " + id + " has been removed from Garage after " + outTime);
    }





}
