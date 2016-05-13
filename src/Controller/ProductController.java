package Controller;

import Config.DatabaseConnection;
import Model.Product;
import Model.User;

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
public class ProductController {

    Product product;
    Connection connection = null;
    Statement statement = null;

    public ProductController(Product product){
        this.product = product;
        connection = new DatabaseConnection().getConn();
    }

    public ProductController(){
        connection = new DatabaseConnection().getConn();
    }

    public boolean createProduct(){

        try {
            statement = connection.createStatement();

            String create_sql = "INSERT INTO product VALUES(null,'" +product.getProductName()+"','"+product.getCategory_id()+"','"+product.getBrand_id()+"','"+product.getCount()+"','"+product.getCreatedDate()+"','"+null+"','"+product.getPrice()+"');";

            if(!statement.execute(create_sql)){
                JOptionPane.showMessageDialog(null, "Inserted Successfully");
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

    public List<Product> selectProduct(){

        List<Product> productList = new LinkedList<Product>();

        try {
            Statement statement1 = connection.createStatement();

            String select_query = "select *from product;";


            ResultSet resultSet = statement1.executeQuery(select_query);

            while (resultSet.next()){
                Product product1 = new Product();

                product1.setId(resultSet.getInt("id"));
                product1.setProductName(resultSet.getString("product_name"));
                product1.setCategory_id(resultSet.getInt("category_id"));
                product1.setBrand_id(resultSet.getInt("brand_id"));
                product1.setCount(resultSet.getInt("count"));
                product1.setPrice(resultSet.getDouble("price"));

                productList.add(product1);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    public String convertDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        Date createdDate = new Date();

        String todayDate;

        todayDate = simpleDateFormat.format(createdDate);

        return todayDate;
    }

}
