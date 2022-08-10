package org.example.DAO;

import org.example.connection.MySQLConnection;
import org.example.models.Address;
import org.example.models.UserDetails;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public  List<UserDetails> getUsers(){
        List<UserDetails> usersList=new ArrayList<>();
        Connection connection=MySQLConnection.getConnection();
        String sql="select * from user";
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String dob=resultSet.getString("dob");
                int addressID=resultSet.getInt("address_id");
                String gender=resultSet.getString("gender");
                usersList.add(new UserDetails(id,name,dob,addressID,gender));
            }
        }
        catch(SQLException e){
            System.out.println("Can't Execute Query");
            e.printStackTrace();
        }
        return usersList;
    }
    public void updateUser(UserDetails user){
        Connection connection=MySQLConnection.getConnection();
        String sql="update user set name=?,dob=?,address_id=?,gender=? where id=?";
    }
}
