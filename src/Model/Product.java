package Model;

import java.util.Date;

/**
 * Created by sanjeevbudha on 5/4/16.
 */
public class Product {

    int id;
    String productName;
    int category_id;
    int brand_id;
    int count;
    String createdDate;
    Date lastUpdated;
    double price;

    public Product(String productName, int category_id, int brand_id, String createdDate, double price) {
        this.productName = productName;
        this.category_id = category_id;
        this.brand_id = brand_id;
        this.createdDate = createdDate;
        this.price = price;
    }

    public Product(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getCategory_id() {
        return category_id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public int getCount() {
        return count;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public double getPrice() {
        return price;
    }
}
