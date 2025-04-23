package src.module;



public class Bus {

    private int busNo;
    private boolean ac;
    private int capacity;

    public Bus(int busNo ,boolean ac,int capacity){
        this.busNo = busNo;
        this.ac = ac;
        this.capacity = capacity;
    }

    public void getBusNo(){
        System.out.println("The bus No is "+this.busNo);
    }
    public void getAc(){
        System.out.println("AC available "+this.ac);
    }
    public void getCapacity(){
        System.out.println("The capacity of the bus is "+this.capacity);
    }

    public boolean setAc(boolean ac){
        return this.ac = ac;
    }
    public int setCapacity(int capacity){
        return this.capacity = capacity;
    }

    public void displayBusInfo(){

        System.out.println("The bus number is "+this.busNo);
        System.out.println("Ac available |"+this.ac);
        System.out.println("the capacity of the bus is "+this.capacity);
    }



}
