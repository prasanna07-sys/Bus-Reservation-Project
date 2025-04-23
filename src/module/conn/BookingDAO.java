package src.module.conn;

import src.module.Booking;

import java.sql.*;
import java.util.*;

import java.util.Date;



public class BookingDAO {

    public int getBookedCount(int busno,Date date) throws Exception{

        String query = "select count(passenger_name) from bookings where bus_no = ? and travel_date = ?;";

        Connection connection = DBConnection.getConnection();
        PreparedStatement pst = connection.prepareStatement(query);

        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        pst.setInt(1,busno);
        pst.setDate(2,sqlDate);

        ResultSet result = pst.executeQuery();

        result.next();

        return result.getInt(1);


    }

    public void addBooking(Booking booking) throws Exception{

        String query = "insert into bookings values(?,?,?)";

        Connection connection = DBConnection.getConnection();

        java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());

        PreparedStatement pst = connection.prepareStatement(query);

        pst.setString(1,booking.passengerName);
        pst.setInt(2,booking.busNo);
        pst.setDate(3,sqldate);

        if(pst.executeUpdate() == 1){
        System.out.println("Added SuccessFully  ");}
        else{
            System.out.println("error occurs");
        }



    }
}
