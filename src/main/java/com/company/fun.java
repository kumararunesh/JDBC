package com.company;
import java.sql.*;
class fun {
    public static void main(String args[]) throws SQLException {
        try{
//step2 create  the connection object  
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/maje?serverTimezone=UTC","root","");
//step3 create the statement object  
            Statement stmt=con.createStatement();
//step4 execute query  
            ResultSet rs=stmt.executeQuery("select * from employee");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));

            PreparedStatement stmt1 =con.prepareStatement("insert into employee values(?,?,?)");
            stmt1.setInt(1,101);//1 specifies the first parameter in the query
            stmt1.setString(2,"Ratan");
            stmt1.setInt(3,54544);

            int i=stmt1.executeUpdate();
            System.out.println(i+ "records inserted");
//step5 close the connection object  
            con.close();

        }catch(Exception e){ System.out.println(e);}

    }
}  