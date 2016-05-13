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
public class AddUser extends JFrame implements ActionListener{

    private int width,height;
    private JPanel groupPanel,mainPanel;
    private JTextField firstName,lastName,mobileNumber,phoneNumber,username,address;
    private JLabel labelFirstName,labelLastName,labelRole,labelMobileNumber,labelPhoneNumber,labelUsername,labelPassword1,labelPassword2,labelAddress;
    private JButton saveUser,clearUser,customerList,supplierList;
    private JComboBox comboBox;
    private JPasswordField passwordField1, passwordField2;

    private String[] roles = {"CUSTOMER","SUPPLIER","ADMIN"};

    public AddUser(String name){
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

        labelFirstName = new JLabel("First Name");
        labelLastName  = new JLabel("Last Name");
        labelMobileNumber  = new JLabel("Mobile Number");
        labelPhoneNumber  = new JLabel("Phone Number");
        labelAddress  = new JLabel("Address");
        labelRole  = new JLabel("Role");
        labelUsername = new JLabel("username");
        labelPassword1 = new JLabel("password");
        labelPassword2 = new JLabel("Re-Enter Password");

        firstName  = new JTextField();
        lastName   = new JTextField();
        mobileNumber = new JTextField();
        phoneNumber  = new JTextField();
        address  = new JTextField();
        comboBox = new JComboBox();
        username = new JTextField();
        passwordField1 = new JPasswordField();
        passwordField2 = new JPasswordField();


        saveUser = new JButton("Submit");
        clearUser = new JButton("Clear");
        customerList = new JButton("Customer's List");
        supplierList = new JButton("Supplier's List");

        saveUser.addActionListener(this);
        clearUser.addActionListener(this);
        customerList.addActionListener(this);
        supplierList.addActionListener(this);

        for (String role : roles)
        {
            comboBox.addItem(role);
            comboBox.setEditable(false);
        }

        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(width - 100, height / 2));

        groupPanel = new JPanel();
        groupPanel.setLayout(new GridLayout(7,4,40,20));
        mainPanel.setPreferredSize(new Dimension(width - 150, height / 2));

        groupPanel.add(labelFirstName);
        groupPanel.add(firstName);

        groupPanel.add(labelLastName);
        groupPanel.add(lastName);

        groupPanel.add(labelMobileNumber);
        groupPanel.add(mobileNumber);

        groupPanel.add(labelPhoneNumber);
        groupPanel.add(phoneNumber);

        groupPanel.add(labelAddress);
        groupPanel.add(address);

        groupPanel.add(labelUsername);
        groupPanel.add(username);

        groupPanel.add(labelPassword1);
        groupPanel.add(passwordField1);

        groupPanel.add(labelPassword2);
        groupPanel.add(passwordField2);

        groupPanel.add(labelRole);
        groupPanel.add(comboBox);

        groupPanel.add(new JLabel());
        groupPanel.add(new JLabel());

        groupPanel.add(new JLabel());
        groupPanel.add(new JLabel());
        groupPanel.add(new JLabel());
        groupPanel.add(new JLabel());

        groupPanel.add(saveUser);
        groupPanel.add(clearUser);
        groupPanel.add(supplierList);
        groupPanel.add(customerList);

        mainPanel.add(groupPanel);

        add(mainPanel, BorderLayout.CENTER);

        add(new Footer(width, height).returnFooter(), BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        User user;

       if (action.equals("Submit")){
           String fName = firstName.getText();
           String lName = lastName.getText();
           String mNumber = mobileNumber.getText();
           String pNumber = phoneNumber.getText();
           String addresses = address.getText();
           String uName = username.getText();
           String r = comboBox.getSelectedItem().toString();
           String pass = new String(passwordField1.getPassword());


           user = new User(fName,lName,r,mNumber,pNumber,uName,pass,addresses);

           boolean success = new UserController(user).createUser();

           if (success){
               this.dispose();
               new Customer("Customer's List");
           }
       }
       else if (action.equals("Clear")){

           firstName.setText("");
           lastName.setText("");
           mobileNumber.setText("");
           phoneNumber.setText("");
           address.setText("");
           username.setText("");
           passwordField1.setText("");
           passwordField2.setText("");

       }
        else if (action.equals("Customer's List")){
           new Customer("Customer's List");
       }
       else if (action.equals("Supplier's List")){
           new Supplier("Supplier's List");
       }
    }
}
