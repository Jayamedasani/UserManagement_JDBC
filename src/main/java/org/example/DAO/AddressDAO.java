package org.example.DAO;

import org.example.connection.MySQLConnection;
import org.example.models.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO {
    public List<Address> getAddresses() {
        List<Address> addressList = new ArrayList<>();
        Connection connection = MySQLConnection.getConnection();
        String sql = "select * from address";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String street = resultSet.getString("street");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                addressList.add(new Address(id, street, city, state));
            }
        } catch (SQLException e) {
            System.out.println("Can't execute Query");
            e.printStackTrace();
        }
        return addressList;
    }
    public List<Address> getUserAddress(int id){
        List<Address> addressList=new ArrayList<>();
        Connection connection=MySQLConnection.getConnection();
        String sql="select * from address where id in (select address_id from user where id='"+id+"')";
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                int addressId=resultSet.getInt("id");
                String street=resultSet.getString("street");
                String city=resultSet.getString("city");
                String state=resultSet.getString("state");
                addressList.add(new Address(addressId,street,city,state));
            }
        }
        catch (SQLException e){
            System.out.println("Can't execute query");
            e.printStackTrace();
        }
        return addressList;
    }
}
