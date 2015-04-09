package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JFrame {
    private static JTextArea inputArea;
    private static JRadioButton test1, test2;
    private JButton enter;
    private static ButtonGroup bg;
    private JPanel panel;
    private JScrollPane scrollpane;

    /**
     * @param Main
     *               
     *        		 This class will be used to design the test version of our input frame.
     *               Later it will be added to production and be used for the main input of the program.
     *               It will allow users to select from predetermined inputs and also allow for manual
     *               text based input in the form of a text box
     */
    public Main(String title) {
        super(title);

        this.setSize(new Dimension(550, 380));
        // Initialize Variables
        panel = new JPanel();
        inputArea = new JTextArea(20, 35);
        test1 = new JRadioButton("Test1");
        test1.setActionCommand("test1");
        test2 = new JRadioButton("Test2");
        test2.setActionCommand("test2");

        // Create a button group
        bg = new ButtonGroup();
        
    
        /* add the radio buttons to the button group
         * The radio button group will allow for only one button to be pressed at a time
         * the user will only be allowed to select one at a time */
        bg.add(test1);
        bg.add(test2);

        // Create the JButton for entering data
        enter = new JButton("Enter");
        enter.setActionCommand("InputEnter");

        // Add the radio buttons to the panel
        panel.add(test1);
        panel.add(test2);

        scrollpane = new JScrollPane(inputArea);

        // Add components
        panel.add(scrollpane, BorderLayout.SOUTH);
        panel.add(enter);
        panel.setVisible(true);

        // Adding Action Listener
        enter.addActionListener(new ButtonActionListener());
        test1.addActionListener(new ButtonActionListener());
        test2.addActionListener(new ButtonActionListener());


        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        setContentPane(panel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }
    
    // set the current content of the text area
    public static void setTextArea(String s) {
        inputArea.setText(s);
    }

    // Returns the current selected radio button
    public static String getButtonSelected() {
        if (test1.isSelected())
            return "test1";
        else if (test2.isSelected())
            return "test2";
        else
            return null;
    }

    // gets the current contents of the text area
	public static String getInputTextArea() {
		return inputArea.getText();
	}

	// main method, creates the main menu
    public static void main(String[] args) {
        new Main("Letter Counter");
    }

}
