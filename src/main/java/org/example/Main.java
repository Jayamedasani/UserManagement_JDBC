package org.example;
import org.example.DAO.AddressDAO;
import org.example.DAO.ManagerDAO;
import org.example.DAO.UserDAO;
import org.example.models.Address;
import org.example.models.UserDetails;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        UserDAO userDAO=new UserDAO();
        AddressDAO addressDAO=new AddressDAO();
        ManagerDAO managerDAO=new ManagerDAO();
        while (true){
            System.out.println("1.Add User");
            System.out.println("2.Update User");
            System.out.println("3.Delete User");
            System.out.println("4.Search User");
            System.out.println("5.Display Users");
            System.out.println("6.Get User Address");
            System.out.println("7.Add Address");
            System.out.println("8.Display Address");
            System.out.println("9.Exit");
            System.out.print("Enter Your Choice:");
            int choice= sc.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Enter UserID:");
                    int id= sc.nextInt();
                    System.out.print("Enter User Name:");
                    String name= sc.next();
                    System.out.print("Enter User DOB:");
                    String dob= sc.next();
                    System.out.print("Enter User AddressID:");
                    int addressID= sc.nextInt();
                    System.out.print("Enter User Gender:");
                    String gender=sc.next();
                    UserDetails user=new UserDetails(id,name,dob,addressID,gender);
                    managerDAO.addUser(user);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    List<UserDetails> usersList=new ArrayList<>();
                    usersList=userDAO.getUsers();
                    for(UserDetails users:usersList){
                        System.out.println("UserID:"+users.getId()+"\tUserName:"+users.getName()+"\tUserDOB"+users.getDob()+"\tUserAddressID"+users.getAddressID()+"\tUserGender"+users.getGender());
                    }
                    break;
                case 6:
                    break;
                case 7:
                    System.out.print("Enter Address ID:");
                    int addressId= sc.nextInt();
                    System.out.print("Enter Address Street:");
                    String addressStreet= sc.next();
                    System.out.print("Enter Address City:");
                    String addressCity= sc.next();
                    System.out.print("Enter Address State:");
                    String addressState=sc.next();
                    managerDAO.addAddress(new Address(addressId,addressStreet,addressCity,addressState));
                    break;
                case 8:
                    List<Address> addressList=new ArrayList<>();
                    addressList=addressDAO.getAddresses();
                    for(Address address:addressList){
                        System.out.println("AddressID:"+address.getId()+"\tAddressStreet"+address.getStreet()+"\tAddressCity"+address.getCity()+"\tAddressState"+address.getState());
                    }
                    break;
                case 9:
                    System.out.println("ThankYou!!");
                    System.exit(1);
                default:
                    System.out.println("Enter Valid Choice");
            }

        }
    }
}