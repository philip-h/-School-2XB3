package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import charts.PieChart;

import org.jfree.ui.RefineryUtilities;

public class Main extends JFrame{

    public static void main(String[] args) {
        Data.readWords();
        new Main("TITLE");
        /*Show Pie Chart*/
       /* 
        PieChart demo = new PieChart( "Letter Counter" );
        demo.setSize(560, 367);
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
        */
    }
    private JPanel contentPane;
    private JLabel title;
    private JButton auto, manual;

	JTextArea inputArea;
	JRadioButton test1,test2;
	JButton enter;
	ButtonGroup bg;
	JPanel panel;
	JScrollPane scrollpane;
	/**
	 * 
	 * @param Manual Input frame
	 * 
	 * This class will be used to design the test version of our input frame.
	 * Later it will be added to production and be used for the main input of the program.
	 * It will allow users to select from predetermined inputs and also allow for manual
	 * text based input in the form of a text box
	 * 
	 */
	public Main(String title) {
        super(title);

		this.setSize(new Dimension(550, 380));
        // Initialize Variables
        panel = new JPanel();
        inputArea = new JTextArea(20, 35);
        test1 = new JRadioButton("Test1");
        test2 = new JRadioButton("Test2");
        
        // Create a button group
        bg = new ButtonGroup();
        
    
        // add the radio buttons to the button group
        // The radio button group will allow for only one button to be pressed at a time
        // the user will only be allowed to select one at a time 
        bg.add(test1);
        bg.add(test2);
        
        // Create the JButton for entering data
        enter = new JButton ("Enter");
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
        
        
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        
        
        setContentPane(panel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

    }


}
