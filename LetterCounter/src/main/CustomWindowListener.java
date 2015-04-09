package main;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * 
 * Created by George on 08/05/15
 * 
 * This Classes function is to provide custom event handling for each window
 * It is used when a window needs o be disposed of but should not exit the entire 
 * program. This can also be done with DISPOSE_ON_CLOSE, we took this approach to 
 * add more modularity and seperate our view from our controller.
 * 
 */

public class CustomWindowListener implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
	}

	// Calls the method for custom maintenance of closing
	@Override
	public void windowClosing(WindowEvent e) {
		Window w = e.getWindow();
		w.dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

}
