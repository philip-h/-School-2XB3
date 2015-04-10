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
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.*;
import java.util.ArrayList;

public class PieChart extends JFrame {
    private Trie trie;

    public PieChart(String title) {
        super(title);
        trie = Trie.toTrie(Main.getInputTextArea());
        setContentPane(createDemoPanel());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private PieDataset createDataset() {
        ArrayList<Node> nodes = trie.nodes();
        Node [] nodesArray = nodes.toArray(new Node[nodes.size()]);
        MergeSort.sort(nodesArray);
        if (ChartOptionMenu.getSingle().equals("single")) {
            return getSingleLetterDataSet(nodesArray);
        } else {
            return getDoubleLetterDataSet(nodesArray);
        }
    }
    // create the Demo Panel
    private JPanel createDemoPanel() {
        JFreeChart chart = ChartFactory.createPieChart("Occurrences of 1 and 2 letter patterns", createDataset(), false, true, false);
        return new ChartPanel(chart);
    }

    private PieDataset getSingleLetterDataSet(Node[] nodes) {
        ArrayList<Node> singleLetters = new ArrayList<>();
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Node n : nodes) {
            if (n.getKey().length() == 1 && !n.getKey().equals(" "))
                singleLetters.add(n);
        }
        for (Node n : singleLetters) {
            String label;
            if (n.getKey().equals(" "))
                label = "# of spaces";
            else
                label = "# of "+n.getKey()+"'s";
            dataset.setValue(label,n.getValue());
        }
        return dataset;

    }

    private PieDataset getDoubleLetterDataSet(Node[] nodes) {
        ArrayList<Node> singleLetters = new ArrayList<>();
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Node n : nodes) {
            if (n.getKey().length() == 2)
                singleLetters.add(n);
        }
        for (Node n : singleLetters) {
            String label;
            if (n.getKey().equals(" "))
                label = "# of spaces";
            else
                label = "# of "+n.getKey()+"'s";
            dataset.setValue(label,n.getValue());
        }
        return dataset;
    }
}