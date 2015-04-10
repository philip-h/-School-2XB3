package charts;

/**
 * Created by philip on 06/04/15.
 */

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

        if (ChartOptionMenu.getSingle().equals("single")) {
            return getSingleLetterDataSet(nodes);
        } else {
            return getDoubleLetterDataSet(nodes);
        }
    }
    // create the Demo Panel
    private JPanel createDemoPanel() {
        JFreeChart chart = ChartFactory.createPieChart("Occurrences of 1 and 2 letter patterns", createDataset(), false, true, false);
        return new ChartPanel(chart);
    }

    private PieDataset getSingleLetterDataSet(ArrayList<Node> nodes) {
        ArrayList<Node> singleLetters = new ArrayList<>();
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Node n : nodes) {
            if (n.getKey().length() == 1)
                singleLetters.add(n);
        }
        for (Node n : singleLetters) {
            String label = "# of "+n.getKey()+"'s";
            System.out.println(n.getValue());
            dataset.setValue(label,n.getValue());
        }
        return dataset;

    }

    private PieDataset getDoubleLetterDataSet(ArrayList<Node> nodes) {
        ArrayList<Node> singleLetters = new ArrayList<>();
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Node n : nodes) {
            if (n.getKey().length() == 2)
                singleLetters.add(n);
        }
        for (Node n : singleLetters) {
            String label = "# of "+n.getKey()+"'s";
            dataset.setValue(label,n.getValue());
        }
        return dataset;
    }

    private double countOccurrences(String pattern) {
        return ((ArrayList<String>) trie.keysWithPrefix(pattern)).size();
    }
}