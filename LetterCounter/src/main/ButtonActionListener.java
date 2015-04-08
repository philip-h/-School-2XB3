package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.jfree.ui.RefineryUtilities;

import charts.BarChart;
import charts.PieChart;

public class ButtonActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent evt) {
		
		// Get the string from the pressed button for comparisons
		String e = evt.getActionCommand();
		
		// If the button pressed is the auto
		if (e.equals("InputEnter")){
			// Create the letter counter
			PieChart demo = new PieChart( "Letter Counter" );
			// set teh size
	        demo.setSize(560, 367);
	        // center it
	        RefineryUtilities.centerFrameOnScreen(demo);
	        
	        // trying to get rid of the default close operations
	        demo.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	        
	        // custom window close even handling
	        demo.addWindowListener(new CustomWindowListener());
	      
	        demo.setVisible(true);
		}else if (e.equals("manual")){
			// Create the letter counter
			ManualInputFrame demo = new ManualInputFrame( "Letter Counter" );
			// set teh size
	        demo.setSize(560, 367);
	        // center it
	        RefineryUtilities.centerFrameOnScreen(demo);
	       
	        // trying to get rid of the default close operations
	        demo.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			        
		    // custom window close even handling
	        demo.addWindowListener(new CustomWindowListener());
				      
			demo.setVisible(true);
		}
		
	}

}
