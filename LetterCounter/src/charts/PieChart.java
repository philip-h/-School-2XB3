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
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.*;
import java.util.ArrayList;

public class PieChart extends JFrame {
    private Trie trie;

    //Create a PieChart of the occurrences of letters
    public PieChart(String title) {
        super(title);
        trie = Trie.toTrie(MainMenu.getInputTextArea());
        setContentPane(createDemoPanel());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private PieDataset createDataset() {
        ArrayList<Node> nodes = trie.nodes();
        Node [] nodesArray = nodes.toArray(new Node[nodes.size()]);
        MergeSort.sort(nodesArray);
        //If the check box was single, create data with single letters only
        if (ChartOptionMenu.getSingle().equals("single")) {
            return getSingleLetterDataSet(nodesArray);
        //If the check box was double, create data with double letters only
        } else {
            return getDoubleLetterDataSet(nodesArray);
        }
    }

    //Create the Demo Panel
    private JPanel createDemoPanel() {
        JFreeChart chart = ChartFactory.createPieChart("Occurrences of 1 and 2 letter patterns", createDataset(), false, true, false);
        return new ChartPanel(chart);
    }

    //Return a dataset consisting of the occurrences of all single letters in the given text area
    private PieDataset getSingleLetterDataSet(Node[] nodes) {
        ArrayList<Node> singleLetters = new ArrayList<>();
        DefaultPieDataset dataset = new DefaultPieDataset();
        //Put all single letter nodes in an array list
        for (Node n : nodes) {
            if (n.getKey().length() == 1 && !n.getKey().equals(" "))
                singleLetters.add(n);
        }
        //For each node in single letters list, create a value in the dataset
        for (Node n : singleLetters) {
            String label;
            if (n.getKey().equals(" "))
                label = "# of spaces";
            else
                label = "# of "+n.getKey()+"'s";
            dataset.setValue(label,n.getValue());
        }
        //return the dataset
        return dataset;

    }
    //Return a dataset consisting of the occurrences of all double letters in the given text area
    private PieDataset getDoubleLetterDataSet(Node[] nodes) {
        ArrayList<Node> singleLetters = new ArrayList<>();
        DefaultPieDataset dataset = new DefaultPieDataset();
        //Put all the double letter nodes in an array list
        for (Node n : nodes) {
            if (n.getKey().length() == 2)
                singleLetters.add(n);
        }
        //For each node in a double letters list, create a value in the dataset
        for (Node n : singleLetters) {
            String label;
            if (n.getKey().equals(" "))
                label = "# of spaces";
            else
                label = "# of "+n.getKey()+"'s";
            dataset.setValue(label,n.getValue());
        }
        //return the dataset
        return dataset;
    }
}