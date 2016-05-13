package View;


import Controller.UserController;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sanjeevbudha on 5/6/16.
 */
public class Customer extends JFrame implements ActionListener{

    int width, height;

    JPanel panel;
    JTable customerTable;
    JButton addCustomer,deleteCustomer,editCustomer,homeBtn;

    public Customer(String name){

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

        String[] columnNames = {"First Name","Last Name","Mobile Number","Phone Number","Role","Address"};

        Object[][] data= new Object[new UserController().selectUser("CUSTOMER").size()][6];
                /*{"Sanjeev","Budha","9843723195","083-690162","Active","Sifal, Kathmandu"},*/

        int i = 0;
        for (User user:new UserController().selectUser("CUSTOMER")){

            data [i][0]= user.getFirstName();
            data [i][1]= user.getLastName();
            data [i][2]= user.getMobileNumber();
            data [i][3]= user.getPhoneNumber();
            data [i][4]= user.getRole();
            data [i][5]= user.getAddress();
            i++;
        }
        customerTable = new JTable(data,columnNames);
        customerTable.setPreferredScrollableViewportSize(new Dimension(width-100,height/2));
        customerTable.setFillsViewportHeight(true);

        JScrollPane jScrollPane = new JScrollPane(customerTable);

        addCustomer = new JButton("New Customer");
        homeBtn  = new JButton("Home");
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(width - 100, height / 2));
        panel.add(jScrollPane);
        panel.add(addCustomer);
        panel.add(homeBtn);
        add(panel, BorderLayout.CENTER);

        add(new Footer(width, height).returnFooter(), BorderLayout.SOUTH);

        addCustomer.addActionListener(this);
        homeBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        if ( action == "New Customer"){
            this.dispose();
            new AddUser("Add User Form");
        }
        else if (action == "Home"){
            this.dispose();
            new DashBoard("Dash Board");
        }
    }

}
