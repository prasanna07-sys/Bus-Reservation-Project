package src.module;

import src.module.conn.BookingDAO;
import src.module.conn.BusDAO;

import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Booking {

    public String passengerName;
    public int busNo;
    public Date date;

    Scanner input = new Scanner(System.in);

    public Booking(){

        System.out.println("Enter The Passenger Name :");
        this.passengerName = input.nextLine();

        System.out.println("Enter your Bus number You want  ");
        this.busNo = input.nextInt();
        input.nextLine();

        System.out.println("Enter your booking date in this format DD-MM-YYYY");
        String dateInput = input.nextLine();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");

        try{
            this.date = dateformat.parse(dateInput);
        }
        catch(Exception e ){

            System.out.println("There is something error "+e.getMessage());
        }

    }

    public boolean isAvailable() throws Exception{

        BusDAO busDAO = new BusDAO();
        BookingDAO bookingDAO = new BookingDAO();

        int capacity = busDAO.getCapacity(busNo);

        int booked =bookingDAO.getBookedCount(busNo,date);

        int balance = busDAO.getCapacity(busNo) - bookingDAO.getBookedCount(busNo,date)-1;

        System.out.println("the balance capacity is "+balance);

        return booked < capacity;


    }




}
