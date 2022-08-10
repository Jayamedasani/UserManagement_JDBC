package org.example.DAO;

import org.example.connection.MySQLConnection;
import org.example.models.Address;
import org.example.models.UserDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManagerDAO {
    public void addUser(UserDetails user){
        Connection connection= MySQLConnection.getConnection();
        String sql="insert into user values(?,?,?,?,?)";
        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1,user.getId());
            statement.setString(2,user.getName());
            statement.setString(3,user.getDob());
            statement.setInt(4,user.getAddressID());
            statement.setString(5, user.getGender());
            int result=statement.executeUpdate();
            System.out.println(result+"records affected");
        }
        catch(SQLException e){
            System.out.println("Can't Add user");
            e.printStackTrace();
        }
    }
    public void addAddress(Address address){
        Connection connection=MySQLConnection.getConnection();
        String sql="insert into address values(?,?,?,?)";
        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1,address.getId());
            statement.setString(2,address.getStreet());
            statement.setString(3,address.getCity());
            statement.setString(4,address.getState());
            int result=statement.executeUpdate();
            System.out.println(result+"records affected");
        }
        catch (SQLException e){
            System.out.println("Can't add details of address");
            e.printStackTrace();
        }
    }
}
