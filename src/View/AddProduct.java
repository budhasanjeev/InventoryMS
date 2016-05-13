package View;

import Controller.ProductController;
import Model.Product;
import javafx.scene.control.ComboBox;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import sun.util.calendar.JulianCalendar;
import sun.util.resources.CalendarData;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

/**
 * Created by sanjeevbudha on 5/12/16.
 */
public class AddProduct extends JFrame implements ActionListener{

    int width,height;
    JLabel labelProductName,labelCategory,labelBrand,labelQuantity,labelPrice,labelDate,labelProductImage;
    JTextField productName, price,quantity,purchasedDate;
    JComboBox category,brand;
    JButton saveProduct,clearProduct,productList;
    JPanel mainPanel,groupPanel;
    JFileChooser productImage;

    private String[] categoryList = {"Laptop","Mobile","Camera"};
    private String[] brandList = {"Sony","Micromax","Dell"};

    public AddProduct(String name){
        super(name);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dimension = tk.getScreenSize();

        width = (int)(dimension.getWidth() - 0.1*dimension.getWidth());
        height = (int)(dimension.getHeight() - 0.2*dimension.getHeight());

        this.setSize(width, height);

        addForm();

        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

    }

    public void addForm(){

        add(new Header(width,height).returnHeader(),BorderLayout.NORTH);

        labelProductName = new JLabel("Product Name");
        labelCategory  = new JLabel("Category");
        labelBrand  = new JLabel("Brand");
        labelQuantity  = new JLabel("Quantity");
        labelPrice  = new JLabel("Price");
        labelDate  = new JLabel("Purchased Date");
        labelProductImage  = new JLabel("Product Image");

        productName  = new JTextField();
        price   = new JTextField();
        quantity = new JTextField();
        purchasedDate = new JTextField();
        productImage = new JFileChooser();

        category  = new JComboBox();
        brand  = new JComboBox();

        saveProduct = new JButton("Submit");
        clearProduct = new JButton("Clear");
        productList = new JButton("Product's List");

        for (String c : categoryList)
        {
            category.addItem(c);
            category.setEditable(false);
        }

        for (String b : brandList){
            brand.addItem(b);
            brand.setEditable(false);
        }

        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(width - 100, height / 2));

        groupPanel = new JPanel();
        groupPanel.setLayout(new GridLayout(8,2,20,20));
        mainPanel.setPreferredSize(new Dimension(width - 150, height / 2));

        groupPanel.add(labelProductName);
        groupPanel.add(productName);

        groupPanel.add(labelCategory);
        groupPanel.add(category);

        groupPanel.add(labelBrand);
        groupPanel.add(brand);

        groupPanel.add(labelPrice);
        groupPanel.add(price);

        groupPanel.add(labelQuantity);
        groupPanel.add(quantity);

        groupPanel.add(labelDate);
        groupPanel.add(purchasedDate);

       /* groupPanel.add(labelProductImage);
        groupPanel.add(productImage);*/

        groupPanel.add(saveProduct);
        groupPanel.add(clearProduct);

        groupPanel.add(new JLabel());
        groupPanel.add(productList);

        mainPanel.add(groupPanel);

        add(mainPanel, BorderLayout.CENTER);

        add(new Footer(width, height).returnFooter(), BorderLayout.SOUTH);

        saveProduct.addActionListener(this);
        clearProduct.addActionListener(this);
        productList.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        if (action == "Submit"){
            Product product = new Product();

            product.setProductName(productName.getText());
            product.setCategory_id(category.getSelectedIndex());
            product.setBrand_id(brand.getSelectedIndex());
            product.setPrice(Integer.parseInt(price.getText()));
            product.setCount(Integer.parseInt(quantity.getText()));
            product.setCreatedDate(purchasedDate.getText());

            boolean success = new ProductController(product).createProduct();

            if (success){
                this.dispose();
                new Stock("Product List");
            }
        }
        else if (action == "Clear"){

            productName.setText("");
            price.setText("");
            quantity.setText("");
            purchasedDate.setText("");

        }
        else if (action == "Product's List"){

            this.dispose();
            new Stock("Product's List").createUI();
        }
    }
}
