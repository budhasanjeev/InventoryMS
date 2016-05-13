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
public class Supplier extends JFrame implements ActionListener{

    int width, height;

    JPanel panel;
    JTable supplierTable;
    JButton addSupplier,deleteSupplier,editSupplier,homeBtn;

    public Supplier(String name){
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

        Object[][] data= new Object[new UserController().selectUser("SUPPLIER").size()][6];
                /*{"Sanjeev","Budha","9843723195","083-690162","Active","Sifal, Kathmandu"},*/

        int i = 0;
        for (User user:new UserController().selectUser("SUPPLIER")){

            data [i][0]= user.getFirstName();
            data [i][1]= user.getLastName();
            data [i][2]= user.getMobileNumber();
            data [i][3]= user.getPhoneNumber();
            data [i][4]= user.getRole();
            data [i][5]= user.getAddress();
            i++;
        }
        supplierTable = new JTable(data,columnNames);
        supplierTable.setPreferredScrollableViewportSize(new Dimension(width-100,height/2));
        supplierTable.setFillsViewportHeight(true);

        JScrollPane jScrollPane = new JScrollPane(supplierTable);

        addSupplier = new JButton("New Supplier");
        homeBtn = new JButton("Home");
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(width-100,height/2));
        panel.add(jScrollPane);
        panel.add(addSupplier);
        panel.add(homeBtn);
        add(panel, BorderLayout.CENTER);

        add(new Footer(width, height).returnFooter(), BorderLayout.SOUTH);

        addSupplier.addActionListener(this);
        homeBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());

        String action = e.getActionCommand();

        if (action == "New Supplier"){
            this.dispose();
            new AddUser("Add User Form");
        }
        else if (action == "Home"){
            this.dispose();
            new DashBoard("DashBoard");
        }
    }


}
