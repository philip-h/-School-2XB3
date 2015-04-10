package charts;

/**
 * Created by philip on 06/04/15.
 */

import datastructs.MergeSort;
import datastructs.Node;
import datastructs.Trie;
import main.ChartOptionMenu;
import main.Main;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
import java.util.ArrayList;

public class BarChart extends JFrame {
    private Trie trie;

    public BarChart(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        trie = Trie.toTrie(Main.getInputTextArea());
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
        if (ChartOptionMenu.getSingle().equals("single")) {
            return getSingleLetterDataSet(nodesArray);
        } else {
            return getDoubleLetterDataSet(nodesArray);
        }
    }

    private CategoryDataset getSingleLetterDataSet(Node[] nodes) {
        ArrayList<Node> singleLetters = new ArrayList<>();
        final DefaultCategoryDataset dataset =  new DefaultCategoryDataset();

        if (ChartOptionMenu.getOrder().equals("ltg")) {
            for (Node n : nodes) {
                if (n.getKey().length() == 1 && !n.getKey().equals(" "))
                    singleLetters.add(n);
            }
        } else {
            for (int i = nodes.length-1; i >= 0; i--) {
                if (nodes[i].getKey().length() == 1)
                    singleLetters.add(nodes[i]);
            }
        }

        for (Node n : singleLetters) {
            String label;
            label = "# of "+n.getKey()+"'s";
            dataset.addValue(n.getValue(), label, "");
        }
        return dataset;

    }

    private CategoryDataset getDoubleLetterDataSet(Node[] nodes) {
        ArrayList<Node> doubleLetters = new ArrayList<>();
        final DefaultCategoryDataset dataset =  new DefaultCategoryDataset();

        if (ChartOptionMenu.getOrder().equals("ltg")) {
            for (Node n : nodes) {
                if (n.getKey().length() == 2)
                    doubleLetters.add(n);
            }
        } else {
            for (int i = nodes.length-1; i >= 0; i--) {
                if (nodes[i].getKey().length() == 1)
                    doubleLetters.add(nodes[i]);
            }
        }

        for (Node n : doubleLetters) {
            String label;
            label = "# of "+n.getKey()+"'s";
            dataset.addValue(n.getValue(), label, "");
        }
        return dataset;
    }

}