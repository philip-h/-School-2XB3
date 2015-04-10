package controller;

import charts.BarChart;
import charts.PieChart;
import org.jfree.ui.RefineryUtilities;
import view.ChartOptionMenu;
import view.SearchMenu;

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
        // check for the submission of the input
        if(e.equals("InputSubmit")) {
        	// get the oreder the user wants to graph in
            String order = ChartOptionMenu.getOrder();
            
            // checks to see whether or not the user wants too look at single or double patterns
            
            // if its null send an alert
            if (ChartOptionMenu.getSingle() == ""){
                JOptionPane.showMessageDialog(null, "Please enter single letter patterns or double letter patterns", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            // if the type of graph field is null send an alert
            else if (ChartOptionMenu.getTypeOfGraph() == "") {
                JOptionPane.showMessageDialog(null, "Please enter a type of graph", "Error", JOptionPane.ERROR_MESSAGE);
            }
            // if the order field is null send an alert
            else if (order == "") {
                JOptionPane.showMessageDialog(null, "Please enter an order", "Error", JOptionPane.ERROR_MESSAGE);
            }
            // Check if piegraph is active
            else if (ChartOptionMenu.getTypeOfGraph().equals("pieGraph")) {
            	// Create and display the pie graph with so that the user can see it with the data chosen
                PieChart demo = new PieChart("Letter Occurrences");
                demo.setSize(560, 367);
                RefineryUtilities.centerFrameOnScreen(demo);
                demo.setVisible(true);
            } 
            // check if bar graph is active
            else if (ChartOptionMenu.getTypeOfGraph().equals("barGraph")) {
            	// Create and displat the bar grapgh so that the user can see it with the relevant data chosen
            	BarChart chart = new BarChart("Letter Counter", "Number of Occurrences of Letters");
                chart.pack();
                RefineryUtilities.centerFrameOnScreen(chart);
                chart.setVisible(true);
            }
        }
        // Selected if they are doing input search
        else if (e.equals("InputSearch")) {
            new SearchMenu();
        }

    }
}
