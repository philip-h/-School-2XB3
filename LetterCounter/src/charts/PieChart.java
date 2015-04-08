package charts;

/**
 * Created by philip on 06/04/15.
 */

import datastructs.Trie;
import main.Data;
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
        initTrie();
        setContentPane(createDemoPanel());
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }

    private PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("# of 'sh'", countPrefixes("sh"));
        dataset.setValue("# of 'se'", countPrefixes("se"));
        dataset.setValue("# of 'th'", countPrefixes("th"));
        dataset.setValue("# of 's'" ,  countPrefixes("s"));
        return dataset;
    }
    // create the Demo Panel
    public JPanel createDemoPanel() {
        JFreeChart chart = ChartFactory.createPieChart(
                "Occurences of 1 and 2 letter patterns", createDataset(), true, true, false);
        return new ChartPanel(chart);
    }

    // 
    public void initTrie() {
        int c = 0;
        trie = new Trie();
        for (String s : Data.getTest1()) {
            trie.put(s);
            c++;
        }
    }

    private double countPrefixes(String prefix) {
        return ((ArrayList<String>) trie.keysWithPrefix(prefix)).size();
    }
}