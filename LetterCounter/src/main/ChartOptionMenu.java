package main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by philip on 08/04/15.
 */
public class ChartOptionMenu extends JFrame {
    private JPanel contentPane;
    private JLabel letters;
    private JTextField lettersField;

    private JLabel type;
    private ButtonGroup graphsGroup;
    private static JCheckBox pie;
    private static JCheckBox bar;
    private static JCheckBox line;

    private JLabel order;
    private ButtonGroup orderGroup;
    private static JCheckBox ltg;
    private static JCheckBox gtl;

    private JButton submit;

    public ChartOptionMenu() {
        initFrame();
        setSize(400, 300);
        setLocationRelativeTo(null);
        addWindowListener(new CustomWindowListener());
        setResizable(false);
        setVisible(true);
    }

    private void initFrame() {
        // Creat and add components to the input panel
        // this panel takes what letters you want to display
        JPanel inputPanel = new JPanel(new GridLayout(2,1));
        letters = new JLabel(" Letters");
        lettersField = new JTextField();
        inputPanel.add(letters);
        inputPanel.add(lettersField);

        // The graph panel allows you to select what type of
        // graph you would like to display your information as
        JPanel graphPanel = new JPanel(new GridLayout(2,1));
        JPanel bottom = new JPanel(new FlowLayout());
        type = new JLabel(" Type");
        pie = new JCheckBox("Pie Graph");
        bar = new JCheckBox("Bar Graph");
        line = new JCheckBox("Plot Graph");
        graphsGroup = new ButtonGroup();
        graphsGroup.add(pie);
        graphsGroup.add(bar);
        graphsGroup.add(line);
        bottom.add(pie);
        bottom.add(bar);
        bottom.add(line);
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
        submit.addActionListener(new ChartOptionActionListener());
        submit.setActionCommand("InputSubmit");
        submitPanel.add(submit);

        // Add all he sub panes to the large content panel
        contentPane = new JPanel(new GridLayout(4,1));
        contentPane.add(inputPanel);
        contentPane.add(graphPanel);
        contentPane.add(orderPanel);
        contentPane.add(submitPanel);

        setContentPane(contentPane);
    }

    public static String getTypeOfGraph() {
        if (pie.isSelected())
            return "pieGraph";
        else if (bar.isSelected())
            return "barGraph";
        else if (line.isSelected())
            return "lineGraph";
        else
            return null;
    }

    public static String getOrder() {
        if (ltg.isSelected())
            return "ltg";
        else if (gtl.isSelected())
            return "gtl";
        else
            return null;
    }
}
