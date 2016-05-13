package Controller;

import Config.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sanjeevbudha on 5/4/16.
 */
public class AnalysisController {

    Connection connection = null;
    Statement statement1 = null;
    Statement statement2 = null;
    Statement statement3 = null;

    public AnalysisController(){
        connection = new DatabaseConnection().getConn();
    }

    public List<Integer> getBrand(){

        List<Integer> countList = new LinkedList<Integer>();

        try {
            statement1 = connection.createStatement();
            statement2 = connection.createStatement();
            statement3 = connection.createStatement();

            String select_sony = "SELECT COUNT(brand_id) AS sonyCount FROM product WHERE brand_id=0";
            String select_micromax = "SELECT COUNT(brand_id) AS micromaxCount FROM product WHERE brand_id=1";
            String select_dell = "SELECT COUNT(brand_id) AS dellCount FROM product WHERE brand_id=2";

            ResultSet resultSet1 = statement1.executeQuery(select_sony);

            while (resultSet1.next()){
                countList.add(resultSet1.getInt(1));
            }

            ResultSet resultSet2 = statement2.executeQuery(select_micromax);

            while (resultSet2.next()){
                countList.add(resultSet2.getInt(1));
            }

            ResultSet resultSet3 = statement3.executeQuery(select_dell);

            while (resultSet3.next()){
                countList.add(resultSet3.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countList;
    }

    public List<Integer> getCategory(){

        List<Integer> countList = new LinkedList<Integer>();

        try {
            statement1 = connection.createStatement();
            statement2 = connection.createStatement();
            statement3 = connection.createStatement();

            String select_laptop = "SELECT COUNT(category_id) AS laptopCount FROM product WHERE category_id=0";
            String select_mobile = "SELECT COUNT(category_id) AS mobileCount FROM product WHERE category_id=1";
            String select_camera = "SELECT COUNT(category_id) AS cameraCount FROM product WHERE category_id=2";

            ResultSet resultSet1 = statement1.executeQuery(select_laptop);

            while (resultSet1.next()){
                countList.add(resultSet1.getInt(1));
            }

            ResultSet resultSet2 = statement2.executeQuery(select_mobile);

            while (resultSet2.next()){
                countList.add(resultSet2.getInt(1));
            }

            ResultSet resultSet3 = statement3.executeQuery(select_camera);

            while (resultSet3.next()){
                countList.add(resultSet3.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countList;
    }

}
