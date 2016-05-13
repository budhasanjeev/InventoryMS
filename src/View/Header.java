package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sanjeevbudha on 5/6/16.
 */
public class Header {
    JPanel panelHeader;

    public Header(int width,int height){

        panelHeader = new JPanel();
        panelHeader.setBackground(Color.decode("#071F40"));
        panelHeader.setPreferredSize(new Dimension(width, height / 5));
        JLabel heading = new JLabel("<html><h1><font color='white'>DWIT INVENTORY</font></h1></html>");
        panelHeader.add(heading);

    }

    public JPanel returnHeader(){
        return panelHeader;
    }
}
