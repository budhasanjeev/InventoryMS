package Model;

import java.util.Date;

/**
 * Created by sanjeevbudha on 5/4/16.
 */
public class Invoice {

    int id;
    int customer_id;
    String customerName;
    int  product_id;
    String productName;
    int quantity;
    int discount;
    Date createdDate;
    double price;

    public Invoice(){}
}
