package src.module;

import src.module.conn.BookingDAO;
import src.module.conn.BusDAO;
import src.module.conn.CreateTable;
import src.module.conn.InsertTable;

import java.util.*;
import java.sql.*;

public class Main{

    public static void main(String[] args) throws Exception{

        BusDAO busDAO = new BusDAO();
        busDAO.displayBusInfo();

        int option = 1;
        int ticketCount = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to KCC Travels ");
        System.out.println("Are you Looking for a Bus booking");

        while(option == 1){

            System.out.println("Do You Want to Book a Bus Ticket");
            System.out.println("Enter 1 for Yes");
            System.out.println("Enter 2 for No");

            option = input.nextInt();
            input.nextLine();

            if(option == 1){
                Booking booking = new Booking();

                if(booking.isAvailable()){
                    BookingDAO bookingDAO = new BookingDAO();

                    bookingDAO.addBooking(booking);
                    System.out.println("Thank You for Booking ");
                    ticketCount++;
                }
                else{

                    System.out.println("Sorry the bus is already full ");
                }


            }
            else{
                System.out.println("Thank You for Coming");
                System.out.println("Your total ticket is "+ticketCount );
            }
        }

    }
}