package View;

import Controller.AnalysisController;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sanjeevbudha on 5/6/16.
 */
public class Analysis extends JFrame implements ActionListener{

    int width,height;
    private String[] categoryList = {"Brand","Category"};
    JComboBox select;
    DefaultPieDataset pieDataset;

    public Analysis(String name){

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

    public void createUI(){

        add(new Header(width,height).returnHeader(),BorderLayout.NORTH);

        showPieChart("");

        add(new Footer(width, height).returnFooter(), BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(null,select.getSelectedItem().toString());

        String cat = select.getSelectedItem().toString();

        showPieChart(cat);

    }

    public void showPieChart(String cat){
        List<Integer> countList = new LinkedList<Integer>();

        pieDataset = new DefaultPieDataset();

        if (cat.equals("Brand")){

            countList = new AnalysisController().getBrand();

            pieDataset.setValue("Sony",new Integer(countList.get(0)));
            pieDataset.setValue("Micromax",new Integer(countList.get(1)));
            pieDataset.setValue("Dell",new Integer(countList.get(2)));
        }
        else if (cat.equals("Category")){

            countList = new AnalysisController().getCategory();

            pieDataset.setValue("Laptop",new Integer(countList.get(0)));
            pieDataset.setValue("Mobile",new Integer(countList.get(1)));
            pieDataset.setValue("Camera",new Integer(countList.get(2)));

        }
        else {
            countList = new AnalysisController().getBrand();

            JOptionPane.showMessageDialog(null,countList.size());

            pieDataset.setValue("Sony",new Integer(30));
            pieDataset.setValue("Micromax",new Integer(30));
            pieDataset.setValue("Dell",new Integer(40));
        }

        JFreeChart chart = ChartFactory.createPieChart("Pie Chart", pieDataset, true, true, true);

        PiePlot p = (PiePlot) chart.getPlot();
        ChartPanel frame = new ChartPanel(chart);

        frame.setSize(width/2,height/2);

        select = new JComboBox();

        select.addActionListener(this);

        for (String c : categoryList)
        {
            select.addItem(c);
            select.setEditable(false);
        }

        JPanel panel = new JPanel();

        panel.add(frame,BorderLayout.NORTH);
        panel.add(select,BorderLayout.SOUTH);

        add(panel, BorderLayout.CENTER);

    }
}
