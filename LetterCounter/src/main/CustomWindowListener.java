package main;

import java.awt.Window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class CustomWindowListener implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("open");
	}

	// NEITHER OF THESE METHODS ARE GETTING CALLED
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("closing");
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("closed");

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("icon");

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("de icon");

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("active");

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("de active");
		// Get the window
		Window w = e.getWindow();
		//w.dispose();
	}

}
