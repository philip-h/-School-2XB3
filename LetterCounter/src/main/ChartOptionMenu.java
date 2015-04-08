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
    private JCheckBox pie;
    private JCheckBox bar;
    private JCheckBox plot;

    private JLabel order;
    private ButtonGroup orderGroup;
    private JCheckBox ltg;
    private JCheckBox gtl;

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
        JPanel inputPanel = new JPanel(new GridLayout(2,1));
        letters = new JLabel(" Letters");
        lettersField = new JTextField();
        inputPanel.add(letters);
        inputPanel.add(lettersField);

        JPanel graphPanel = new JPanel(new GridLayout(2,1));
        JPanel bottom = new JPanel(new FlowLayout());
        type = new JLabel(" Type");
        pie = new JCheckBox("Pie Graph");
        bar = new JCheckBox("Bar Graph");
        plot = new JCheckBox("Plot Graph");
        graphsGroup = new ButtonGroup();
        graphsGroup.add(pie);
        graphsGroup.add(bar);
        graphsGroup.add(plot);
        bottom.add(pie);
        bottom.add(bar);
        bottom.add(plot);
        graphPanel.add(type);
        graphPanel.add(bottom);

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

        JPanel submitPanel = new JPanel(new FlowLayout());
        submit = new JButton("Submit");
        submitPanel.add(submit);

        contentPane = new JPanel(new GridLayout(4,1));
        contentPane.add(inputPanel);
        contentPane.add(graphPanel);
        contentPane.add(orderPanel);
        contentPane.add(submitPanel);

        setContentPane(contentPane);
    }
}
