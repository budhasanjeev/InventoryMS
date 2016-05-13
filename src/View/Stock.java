package View;

import Controller.ProductController;
import Controller.UserController;
import Model.Product;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sanjeevbudha on 5/6/16.
 */
public class Stock extends JFrame implements ActionListener{

    int width, height;
    JPanel panel;
    JTable productTable;
    JButton addProduct,deleteProduct,editProduct,homeBtn;

    public Stock(String name){
        super(name);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dimension = tk.getScreenSize();

        width = (int)(dimension.getWidth() - 0.1*dimension.getWidth());
        height = (int)(dimension.getHeight() - 0.2*dimension.getHeight());

        createUI();

        this.setSize(width, height);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }


    public void createUI()
    {
        add(new Header(width,height).returnHeader(),BorderLayout.NORTH);


        String[] columnNames = {"Product Name","Category","Brand","Count","Price"};

        Object[][] data= new Object[new ProductController().selectProduct().size()][6];
                /*{"Sanjeev","Budha","9843723195","083-690162","Active","Sifal, Kathmandu"},*/

        String categoryName = "";
        String brandName = "";

        int i = 0;
        for (Product product:new ProductController().selectProduct()){

            data [i][0]= product.getProductName();

            if(product.getCategory_id() == 0)
            {
                categoryName = "Laptop";
            }
            else if (product.getCategory_id() == 1){
                categoryName = "Mobile";
            }
            else if(product.getCategory_id() == 2){
                categoryName = "Camera";
            }

            if(product.getBrand_id() == 0)
            {
                brandName = "Sony";
            }
            else if (product.getBrand_id() == 1){
                brandName = "Micromax";
            }
            else if(product.getBrand_id() == 2){
                brandName = "Dell";
            }

            data [i][1]= categoryName;
            data [i][2]= brandName;
            data [i][3]= product.getCount();
            data [i][4]= product.getPrice();
            i++;
        }

        productTable = new JTable(data,columnNames);
        productTable.setPreferredScrollableViewportSize(new Dimension(width-100,height/2));
        productTable.setFillsViewportHeight(true);

        JScrollPane jScrollPane = new JScrollPane(productTable);

        addProduct = new JButton("New Product");
        homeBtn = new JButton("Home");
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(width-100,height/2));
        panel.add(jScrollPane);
        panel.add(addProduct);
        panel.add(homeBtn);
        add(panel, BorderLayout.CENTER);

        add(new Footer(width, height).returnFooter(), BorderLayout.SOUTH);

        addProduct.addActionListener(this);
        homeBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());

        String action = e.getActionCommand();

        if (action == "New Product"){
            this.dispose();
            new AddProduct("Add Product Form");
        }
        else if (action == "Home"){
            this.dispose();
            new DashBoard("DashBoard");
        }
    }

}
