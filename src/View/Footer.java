package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sanjeevbudha on 5/6/16.
 */
public class Footer {

    JPanel panelFooter;

    public Footer(int width, int height){

        panelFooter = new JPanel();
        panelFooter.setBackground(Color.decode("#071F40"));
        JLabel footer = new JLabel("<html><font color='white'>@2016 DWIT INVENTORY</font></html>");
        panelFooter.add(footer);
        panelFooter.setPreferredSize(new Dimension(width,height/8));

    }

    public JPanel returnFooter(){
        return panelFooter;
    }
}
