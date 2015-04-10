package view;

import controller.ChartOptionActionListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by philip on 08/04/15.
 */
public class ChartOptionMenu extends JFrame {
    private JPanel contentPane;

    private JLabel singleDouble;
    private ButtonGroup singleGroup;
    private static JCheckBox singleLetters;
    private static JCheckBox doubleLetters;

    private JLabel type;
    private ButtonGroup graphsGroup;
    private static JCheckBox pie;
    private static JCheckBox bar;

    private JLabel order;
    private ButtonGroup orderGroup;
    private static JCheckBox ltg;
    private static JCheckBox gtl;

    private JButton submit;
    private JButton search;

    public ChartOptionMenu() {
        initFrame();
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void initFrame() {
        // The single double panel allows you to select whether you
        // would like to graph single letter patterns or double letter patterns
        JPanel singleDoublePanel = new JPanel(new GridLayout(2,1));
        JPanel bottom = new JPanel(new FlowLayout());
        singleDouble = new JLabel(" Single or Double Letter Patterns");
        singleLetters = new JCheckBox("Single");
        doubleLetters = new JCheckBox("Double");
        singleGroup = new ButtonGroup();
        singleGroup.add(singleLetters);
        singleGroup.add(doubleLetters);
        bottom.add(singleLetters);
        bottom.add(doubleLetters);
        singleDoublePanel.add(singleDouble);
        singleDoublePanel.add(bottom);

        // The graph panel allows you to select what type of
        // graph you would like to display your information as
        JPanel graphPanel = new JPanel(new GridLayout(2,1));
        bottom = new JPanel(new FlowLayout());
        type = new JLabel(" Type");
        pie = new JCheckBox("Pie Graph");
        bar = new JCheckBox("Bar Graph");
        graphsGroup = new ButtonGroup();
        graphsGroup.add(pie);
        graphsGroup.add(bar);
        bottom.add(pie);
        bottom.add(bar);
        graphPanel.add(type);
        graphPanel.add(bottom);

        // The order panel lets you select in what order the
        // information should be added
        JPanel orderPanel = new JPanel(new GridLayout(2,1));
        bottom = new JPanel(new FlowLayout());
        order = new JLabel(" Order");
        ltg = new JCheckBox("Least to Greatest");
        gtl = new JCheckBox("Greatest to Least");
        orderGroup = new ButtonGroup();
        orderGroup.add(gtl);
        orderGroup.add(ltg);
        bottom.add(ltg);
        bottom.add(gtl);
        orderPanel.add(order);
        orderPanel.add(bottom);

        // Allows user to submit the current parameters and receive their graphed information
        JPanel submitPanel = new JPanel(new FlowLayout());
        submit = new JButton("Submit");
        search = new JButton("Search for a letter");
        submit.addActionListener(new ChartOptionActionListener());
        submit.setActionCommand("InputSubmit");
        search.addActionListener(new ChartOptionActionListener());
        search.setActionCommand("InputSearch");
        submitPanel.add(submit);
        submitPanel.add(search);

        // Add all he sub panes to the large content panel
        contentPane = new JPanel(new GridLayout(4,1));
        contentPane.add(singleDoublePanel);
        contentPane.add(graphPanel);
        contentPane.add(orderPanel);
        contentPane.add(submitPanel);

        setContentPane(contentPane);
    }
    //Return the type of graph as a string
    public static String getTypeOfGraph() {
        if (pie.isSelected())
            return "pieGraph";
        else if (bar.isSelected())
            return "barGraph";
        else
            return null;
    }

    //Return the order as a string
    public static String getOrder() {
        if (ltg.isSelected())
            return "ltg";
        else if (gtl.isSelected())
            return "gtl";
        else
            return null;
    }

    //Return whether you want to analyze single or double letters
    public static String getSingle() {
        if (singleLetters.isSelected())
            return "single";
        else if (doubleLetters.isSelected())
            return "double";
        else
            return null;
    }
}
