package Controller;

import Config.DatabaseConnection;
import Model.User;
import View.DashBoard;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sanjeevbudha on 5/4/16.
 */
public class UserController {
    User user;
    Connection connection = null;
    Statement statement = null;

    public UserController(User user){
        this.user = user;
        connection = new DatabaseConnection().getConn();
    }

    public UserController(){
        connection = new DatabaseConnection().getConn();
    }

    public boolean createUser(){


        try {
            statement = connection.createStatement();

            String create_sql = "INSERT INTO person VALUES(null,'" +user.getFirstName()+"','"+user.getLastName()+"','"+user.getRole()+"',true,'"+convertDate()+"',null,null,'"+user.getMobileNumber()+"','"+user.getPhoneNumber()+"','"+user.getUsername()+"','"+user.getPassword()+"','"+user.getAddress()+"');";

            if(!statement.execute(create_sql)){
                JOptionPane.showMessageDialog(null,"Inserted Successfully");
                return true;

            }
            else {
                JOptionPane.showMessageDialog(null,"Insertion Failed");

            }

            System.out.println(create_sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public String convertDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        Date createdDate = new Date();

        String todayDate;

        todayDate = simpleDateFormat.format(createdDate);

        return todayDate;
    }

    public String encryptPassword(){
        return user.getPassword();
    }

    public List<User> selectUser(String role){

        List<User> userList = new LinkedList<User>();

        try {
            Statement statement1 = connection.createStatement();

            String select_query = "SELECT *FROM person WHERE status = '1' AND role ='"+role+"';";
            System.out.println(select_query);

            ResultSet resultSet = statement1.executeQuery(select_query);

            while (resultSet.next()){
                User user1 = new User();

                user1.setId(resultSet.getInt("id"));
                user1.setFirstName(resultSet.getString("first_name"));
                user1.setLastName(resultSet.getString("last_name"));
                user1.setMobileNumber(resultSet.getString("mobile_number"));
                user1.setPhoneNumber(resultSet.getString("phone_number"));
                user1.setRole(resultSet.getString("role"));
                user1.setAddress(resultSet.getString("address"));

                userList.add(user1);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

}
