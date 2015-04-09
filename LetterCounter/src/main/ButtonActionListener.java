package main;

import charts.PieChart;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent evt) {
		
		// Get the string from the pressed button for comparisons
		String e = evt.getActionCommand();
		
		// If the button pressed is the auto
		if (e.equals("InputEnter")){

			if (Main.getButtonSelected().equals("test1")) {
				new ChartOptionMenu();
			} else if (Main.getButtonSelected().equals("test2")) {
				new ChartOptionMenu();
			} else {
				Main.getInputTextArea();
				System.out.println("POOH");
			}

		}else if (e.equals("test1")){
			Main.setTextArea(Data.getStringRep1());


		}else if (e.equals("test2")){
			Main.setTextArea(Data.getStringRep2());
		}
		
	}

}
