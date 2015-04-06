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
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
import java.util.ArrayList;

public class PieChart extends ApplicationFrame {
    private Trie trie;

    public PieChart(String title) {
        super(title);
        initTrie();
        setContentPane(createDemoPanel());

    }

    private PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("# of 'sh'", countPrefixes("sh"));
        dataset.setValue("# of 'se'", countPrefixes("se"));
        dataset.setValue("# of 'th'", countPrefixes("th"));
        dataset.setValue("# of 's'", countPrefixes("s"));
        return dataset;
    }

    private JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Occurences of 1 and 2 letter patterns",  // chart title
                dataset,        // data
                false,           // include legend
                true,
                false);

        return chart;
    }

    public JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        return new ChartPanel(chart);
    }


    public void initTrie() {
        int c = 0;
        trie = new Trie();
        for (String s : Data.getWords()) {
            trie.put(s, c);
            c++;
        }
    }

    private double countPrefixes(String prefix) {
        return ((ArrayList<String>) trie.keysWithPrefix(prefix)).size();
    }
}