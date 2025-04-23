package src.module.conn;

import java.sql.*;
import java.util.*;

public class InsertTable {

   public static void insertBus() throws Exception{


       String query = "insert into bus values(?,?,?)";

       Connection connection = DBConnection.getConnection();
       connection.setAutoCommit(false);
       PreparedStatement pst = connection.prepareStatement(query);

       Scanner input = new Scanner(System.in);

       System.out.println("how many bus details you insert");

       int length = input.nextInt();
       input.nextLine();

       for(int i=0;i<length;i++){

           System.out.println("enter the Bus No");
           int busno =input.nextInt();
           input.nextLine();

           System.out.println("Enter AC availablity 1 for yes and 0 for no");
           int ac = input.nextInt();
           input.nextLine();

           System.out.println("Enter the capacity of Bus ");
           int capacity = input.nextInt();
           input.nextLine();

           pst.setInt(1,busno);
           pst.setInt(2,ac);
           pst.setInt(3,capacity);

           pst.addBatch();
       }

       int[] rows = pst.executeBatch();

       boolean allSuccess = true;

       for(int row : rows){

           if(row == 0){
               allSuccess = false;
           }
       }
       if(allSuccess){
           connection.commit();
           System.out.println("The values are inserted Successfully");
       }
       else{
           connection.rollback();
           System.out.println("The values doesn't added There is an error occurs");
       }
   }

}
