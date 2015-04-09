package main;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/*
 * Added by George on 08/05/15
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
