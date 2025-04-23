package src.module.conn;

import java.sql.Connection;
import java.sql.Statement;
import java.util.*;


public class CreateTable {

    public static void createTable() throws Exception{

        String createbus = "create table bus(bus_no int primary key ,ac boolean ,capacity int  );";
        String createbooking = "create table bookings(passenger_name varchar(50),bus_no int ,travel_date date);";

        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();

        statement.executeUpdate(createbus);
        statement.executeUpdate(createbooking);
    }


}
