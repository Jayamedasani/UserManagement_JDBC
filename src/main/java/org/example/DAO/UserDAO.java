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
        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getDob());
            statement.setInt(3,user.getAddressID());
            statement.setString(4,user.getGender());
            statement.setInt(5,user.getId());
            int result=statement.executeUpdate();
            System.out.println(result+"records affected");
        }
        catch(SQLException e){
            System.out.println("Can't Execute Query");
            e.printStackTrace();
        }
    }
    public List<UserDetails> searchUser(String username){
        List<UserDetails> searchList=new ArrayList<>();
        Connection connection=MySQLConnection.getConnection();
        String sql="select * from user where name like ?";
        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1,username);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String dob=resultSet.getString("dob");
                int addressID=resultSet.getInt("address_id");
                String gender=resultSet.getString("gender");
                searchList.add(new UserDetails(id,name,dob,addressID,gender));
            }
        }
        catch (SQLException e){
            System.out.println("Can't Execute Query");
            e.printStackTrace();
        }
        return searchList;
    }
    public void deleteUser(int id){
        Connection connection=MySQLConnection.getConnection();
        String sql="delete from user where id=?";
        try{
            PreparedStatement statement= connection.prepareStatement(sql);
            statement.setInt(1,id);
            int result=statement.executeUpdate();
            System.out.println(result+"rows affected");
        }
        catch (SQLException e){
            System.out.println("Can't execute Query");
            e.printStackTrace();
        }
    }
}
