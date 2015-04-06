package main;

import charts.PieChart;
import org.jfree.ui.RefineryUtilities;

public class Main {

    public static void main(String[] args) {
        Data.readWords();
        /*Show Pie Chart*/
        PieChart demo = new PieChart( "Letter Counter" );
        demo.setSize(560, 367);
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}
