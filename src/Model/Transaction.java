package Model;

import java.util.Date;

/**
 * Created by sanjeevbudha on 5/4/16.
 */
public class Transaction {

    int id;
    int from_user_id;
    int to_user_id;
    int product_id;
    Date createdDate;
    int count;

    public Transaction(){}
}