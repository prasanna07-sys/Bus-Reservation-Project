package src.module.conn;

import java.util.*;
import java.sql.*;

public class BusDAO {

    public void displayBusInfo() throws Exception{

        String query = "select * from bus";

        Connection connection = DBConnection.getConnection();
        Statement  statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);

        while(result.next()){

            System.out.println("-------------------------");


            System.out.println("The Bus No is "+result.getInt(1));

            if(result.getInt(2) == 1){

                System.out.println("AC | Available");
            }
            else{
                System.out.println("AC | Not Available");
            }

            System.out.println("The capacity of the bus is "+result.getInt(3));
            System.out.println("-------------------------");
            System.out.println();
        }


    }

    public int getCapacity(int busno) throws Exception{

        String query = "select capacity from bus where bus_no = ?;";

        Connection connection = DBConnection.getConnection();
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setInt(1,busno);

        ResultSet result = pst.executeQuery();

        result.next();

        return result.getInt(1);
    }

}
