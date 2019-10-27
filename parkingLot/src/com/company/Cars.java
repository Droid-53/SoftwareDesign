package com.company;

public class Cars {
    int id;
    double inTime, outTime;
    boolean enteredGarage;
    boolean leftGarage;
    public static double spotCost;
    double waitTimeBefore = getRandomNumber();
    double waitTimeAfter = getRandomNumber();

    public Cars(int i) {
        id = i;
        enteredGarage = false;
        leftGarage = false;
    }

    public int getId(){
        return id;
    }
    public void setId(int a){
        id = a;
    }
    public void printId(){
        System.out.println(id);
    }

    public double getInTime(){
        return inTime;
    }
    public void setInTime(){
        inTime = Math.random() * 10;
    }
    public void printInTime(){
        System.out.println(inTime);
    }

    public double getOutTime(){
        return outTime;
    }
    public void setOutTime(){
        outTime = Math.random() * 10;
    }
    public void printOutTime(){
        System.out.println(outTime);
    }

    public boolean isInGarage(){
        return enteredGarage;
    }
    public boolean hasLeftGarage(){
        return leftGarage;
    }

    public void setGarageStatus(boolean i, boolean o){
        enteredGarage = i;
        leftGarage = o;
    }

    public double getSpotCost(){
        return spotCost;
    }
    public void setSpotCost(double a){
        spotCost = a;
    }


    public static double getRandomNumber(){
        double x = Math.random() * 10;
        return x;
    }


}
