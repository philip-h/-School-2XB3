package charts;

/**
 * Created by philip on 06/04/15.
 */

import datastructs.MergeSort;
import datastructs.Node;
import datastructs.Trie;
import view.ChartOptionMenu;
import view.MainMenu;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.ArrayList;

public class BarChart extends JFrame {
    private Trie trie;

    //Create a BarChart of the occurrences of letters
    public BarChart(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        trie = Trie.toTrie(MainMenu.getInputTextArea());
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Category",
                "# Of Occurrences",
                createDataset(),
                PlotOrientation.VERTICAL,
                false, true, false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);

    }

    private CategoryDataset createDataset() {
        ArrayList<Node> nodes = trie.nodes();
        Node [] nodesArray = nodes.toArray(new Node[nodes.size()]);
        MergeSort.sort(nodesArray);
        //If the check box was single, create data with double letters only
        if (ChartOptionMenu.getSingle().equals("single")) {
            return getSingleLetterDataSet(nodesArray);
        //If the check box was double, create data with double letters only
        } else {
            return getDoubleLetterDataSet(nodesArray);
        }
    }
    //Return a dataset consisting of the occurrences of all single letters in the given text area
    private CategoryDataset getSingleLetterDataSet(Node[] nodes) {
        ArrayList<Node> singleLetters = new ArrayList<>();
        final DefaultCategoryDataset dataset =  new DefaultCategoryDataset();
        //If the order check box is least to greatest, then add nodes to single list as normal, ignoring spaces
        if (ChartOptionMenu.getOrder().equals("ltg")) {
            for (Node n : nodes) {
                if (n.getKey().length() == 1 && !n.getKey().equals(" "))
                    singleLetters.add(n);
            }
        //If the order check box is greatest to least, then add nodes to double list in reverse order
        } else {
            for (int i = nodes.length-1; i >= 0; i--) {
                if (nodes[i].getKey().length() == 1)
                    singleLetters.add(nodes[i]);
            }
        }

        //For each node in single letters list, create a value in the dataset
        for (Node n : singleLetters) {
            String label;
            label = "# of "+n.getKey()+"'s";
            dataset.addValue(n.getValue(), label, "");
        }
        //return the dataset
        return dataset;

    }
    //Return a dataset consisting of the occurrences of all double letters in the given text area
    private CategoryDataset getDoubleLetterDataSet(Node[] nodes) {
        ArrayList<Node> doubleLetters = new ArrayList<>();
        final DefaultCategoryDataset dataset =  new DefaultCategoryDataset();

        //If the order check box is least to greatest, then add nodes to single list as normal, ignoring spaces
        if (ChartOptionMenu.getOrder().equals("ltg")) {
            for (Node n : nodes) {
                if (n.getKey().length() == 2)
                    doubleLetters.add(n);
            }
        //If the order check box is greatest to least, then add nodes to double list in reverse order
        } else {
            for (int i = nodes.length-1; i >= 0; i--) {
                if (nodes[i].getKey().length() == 1)
                    doubleLetters.add(nodes[i]);
            }
        }

        //For each node in single letters list, create a value in the dataset
        for (Node n : doubleLetters) {
            String label;
            label = "# of "+n.getKey()+"'s";
            dataset.addValue(n.getValue(), label, "");
        }
        //return the dataset
        return dataset;
    }

}