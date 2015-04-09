package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * Added by George on 07/05/15
 * 
 */
public class MainMenuActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent evt) {
		
		// Get the string from the pressed button for comparisons
		String e = evt.getActionCommand();

		// If the button pressed
		if (e.equals("InputEnter")){
			if (Main.getButtonSelected() == null) {
				new ChartOptionMenu();
			} else if (Main.getButtonSelected().equals("test1")) {
				new ChartOptionMenu();
			} else if (Main.getButtonSelected().equals("test2")) {
				new ChartOptionMenu();
			}
		}
		// Sets the text in the input area to a book when it is clicked 
		else if (e.equals("test1")){
			Main.setTextArea(Data.getStringRep1());
		}
		// Sets the text in the input area to a book when it is clicked 
		else if (e.equals("test2")){
			Main.setTextArea(Data.getStringRep2());
		}





	}

}
