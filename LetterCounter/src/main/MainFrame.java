package main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by philip on 07/04/15.
 */
public class MainFrame extends JFrame {
    private JPanel contentPane;
    private JLabel title;
    private JButton auto, manual;

    public MainFrame() {
        initFrame();
        setSize(new Dimension(300, 150));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initFrame() {
        contentPane = (JPanel)getContentPane();
        contentPane.setLayout(new GridLayout(2, 1));

        JPanel titlePane  = new JPanel(new FlowLayout());
        title = new JLabel("Wat type of input would you like?");
        titlePane.add(title);

        JPanel buttonPane = new JPanel(new FlowLayout());
        auto = new JButton("Auto Input");
        manual = new JButton("Manual Input");
        buttonPane.add(auto);
        buttonPane.add(manual);

        contentPane.add(titlePane);
        contentPane.add(buttonPane);

    }
}
