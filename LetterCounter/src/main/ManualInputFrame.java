package main;

import javax.swing.*;
import java.awt.*;
@Deprecated
public class ManualInputFrame extends JFrame{
	
	JTextArea inputArea;
	JRadioButton test1,test2;
	JButton select;
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
	public ManualInputFrame(String title) {
        super(title);
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
        select = new JButton ("Enter");
        
        // Add the radio buttons to the panel
        panel.add(test1);
        panel.add(test2);
        
        scrollpane = new JScrollPane(inputArea);

        // Add components
        panel.add(scrollpane, BorderLayout.SOUTH);
        panel.add(select);
        panel.setVisible(true);
        
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setContentPane(panel);
        
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }


 
}
 