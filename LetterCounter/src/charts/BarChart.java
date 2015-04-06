package charts;

/**
 * Created by philip on 06/04/15.
 */

import datastructs.Trie;
import main.Data;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import java.util.ArrayList;

public class BarChart extends ApplicationFrame {
    private Trie trie;
    public BarChart(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        initTrie();
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Category",
                "# Of Occurrences",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset() {
        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset();

        dataset.addValue(countPrefixes("sh"),"# of 'sh'","Some Category");
        dataset.addValue(countPrefixes("se"),"# of 'se'","Some Category");
        dataset.addValue(countPrefixes("th"),"# of 'th'","Some Category");
        dataset.addValue(countPrefixes("sa"),"# of 's'" ,"Some Category");
        return dataset;
    }

    private void initTrie() {
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