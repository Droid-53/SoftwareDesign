package com.company;


import java.util.Vector;

public class ParkingSpot {
    public static int capacity = 5;
    public static double baseLineFeePerHour = 5;
    public static double discountPercentage = .2;
    boolean hasDiscount = false;
    public static Vector<Cars> parkingSpotVector = new Vector<Cars>(capacity);

    public ParkingSpot() {
        hasDiscount = false;

    }


    public void addCarToVect(Cars c){
        parkingSpotVector.add(c);
    }

    public void removeCarFromVect(int i){
        parkingSpotVector.remove(i);
    }


    public void printVect(){
        for(int i = 0; i < parkingSpotVector.size(); i++){
            System.out.println(parkingSpotVector.get(i).id);
        }
    }

    public int getVectSize(){
        return parkingSpotVector.size();
    }





}
