package main;

import charts.BarChart;
import charts.LineChart;
import charts.PieChart;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**;
 * Created by philip on 09/04/15.
 */
public class ChartOptionActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evt) {
        // Get the string from the pressed button for comparisons
        String e = evt.getActionCommand();

        if(e.equals("InputSubmit")) {
            String order = ChartOptionMenu.getOrder();

            if (ChartOptionMenu.getSingle() == null){
                JOptionPane.showMessageDialog(null, "Please enter single letter patterns or double letter patterns", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (ChartOptionMenu.getTypeOfGraph() == null) {
                JOptionPane.showMessageDialog(null, "Please enter a type of graph", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (order == null) {
                JOptionPane.showMessageDialog(null, "Please enter an order", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (ChartOptionMenu.getTypeOfGraph().equals("pieGraph")) {
                PieChart demo = new PieChart("Letter Occurrences");
                demo.setSize(560, 367);
                RefineryUtilities.centerFrameOnScreen(demo);
                demo.setVisible(true);
            } else if (ChartOptionMenu.getTypeOfGraph().equals("barGraph")) {
                BarChart chart = new BarChart("Letter Counter", "Number of Occurrences of Letters");
                chart.pack();
                RefineryUtilities.centerFrameOnScreen(chart);
                chart.setVisible(true);
            } else if (ChartOptionMenu.getTypeOfGraph().equals("lineGraph")) {
                LineChart chart = new LineChart("School Vs Years" ,"Number of Schools vs years");
                chart.pack();
                RefineryUtilities.centerFrameOnScreen(chart);
                chart.setVisible(true);
            }
        }

    }
}
