package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by sanjeevbudha on 5/4/16.
 */
public class DashBoard extends JFrame implements ActionListener{

    JPanel groupPanel;
    JButton customerButton,supplierButton,stockButton,transactionButton,brandButton,categoryButton;
    int width,height;

    public DashBoard(String name){

        super(name);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dimension = tk.getScreenSize();

        width = (int)(dimension.getWidth() - 0.1*dimension.getWidth());
        height = (int)(dimension.getHeight() - 0.2*dimension.getHeight());

        this.setSize(width, height);

        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        showWorkSpace();

    }

    public void showWorkSpace(){

        Header header = new Header(width,height);
        add(header.returnHeader(), BorderLayout.NORTH);

        ImageIcon customer = new ImageIcon(getClass().getResource("/Images/customer.png"));
        ImageIcon supplier = new ImageIcon(getClass().getResource("/Images/supplier.png"));
        ImageIcon stock = new ImageIcon(getClass().getResource("/Images/stock.png"));
        ImageIcon transaction = new ImageIcon(getClass().getResource("/Images/transaction.png"));
        ImageIcon category = new ImageIcon(getClass().getResource("/Images/category.png"));
        ImageIcon brand = new ImageIcon(getClass().getResource("/Images/brand.png"));

        customerButton = new JButton(customer);
        customerButton.setText("Customer");

        supplierButton = new JButton(supplier);
        supplierButton.setText("Supplier");

        stockButton    = new JButton(stock);
        stockButton.setText("Stock");

        transactionButton = new JButton(transaction);
        transactionButton.setText("Transaction");

        categoryButton  = new JButton(category);
        categoryButton.setText("Category");

        brandButton  = new JButton(brand);
        brandButton.setText("Brand");

        groupPanel = new JPanel();
        groupPanel.setBackground(Color.decode("#EDF2F7"));
        groupPanel.setLayout(new GridLayout(2, 2));
        groupPanel.setPreferredSize(new Dimension(500, 250));
        groupPanel.add(customerButton);
        groupPanel.add(supplierButton);
        groupPanel.add(stockButton);
        groupPanel.add(transactionButton);
        groupPanel.add(categoryButton);
        groupPanel.add(brandButton);

        JPanel pan = new JPanel();
        pan.add(groupPanel);

        add(pan,FlowLayout.CENTER);

        add(new Footer(width,height).returnFooter(),BorderLayout.SOUTH);

        customerButton.addActionListener(this);
        supplierButton.addActionListener(this);
        stockButton.addActionListener(this);
        transactionButton.addActionListener(this);
        categoryButton.addActionListener(this);
        brandButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String btnType = e.getActionCommand();

        if (btnType.equals("Customer")){
            this.dispose();
            new Customer("Customer Panel");
        }
        else if(btnType.equals("Supplier")){
            this.dispose();
            new Supplier("Supplier Panel");
        }
        else if(btnType.equals("Stock")){
            this.dispose();
            new Stock("Stock Panel");
        }
        else if(btnType.equals("Brand")){

            JOptionPane.showMessageDialog(null,"This Feature is not Available in this version\n" +
                    " You need to buy ultimate edition to use this feature\n Thank You");
        }
        else if (btnType.equals("Category")){
            JOptionPane.showMessageDialog(null,"This Feature is not Available in this version\n" +
                    " You need to buy ultimate edition to use this feature\n" +
                    " Thank You");
        }
        else if (btnType.equals("Transaction")){
            this.dispose();
            new Analysis("Analysis");
        }
    }
}
