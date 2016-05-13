package Controller;

import Config.DatabaseConnection;
import Model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by sanjeevbudha on 4/28/16.
 */
public class LoginController {

    Connection connection = null;
    Statement statement = null;

    public LoginController(){

        connection = new DatabaseConnection().getConn();

    }

    public User authentication(String username,String password){

        User user = new User();

        try {
            statement = connection.createStatement();

            /*Creating query statement for login*/
            String login_query= "SELECT *FROM person WHERE username = '" +username+"' AND password = '"+password+"' AND status = '1';";

            ResultSet resultSet = statement.executeQuery(login_query);

            while (resultSet.next()){
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                break;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }

}
