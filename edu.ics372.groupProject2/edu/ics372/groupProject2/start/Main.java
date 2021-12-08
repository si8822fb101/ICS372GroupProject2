package edu.ics372.groupProject2.start;

import edu.ics372.groupProject2.display.GUIDisplay;
import edu.ics372.groupProject2.timer.Clock;
import javafx.application.Application;

/**
 * 
 * 
 * @author Qaalib Farah, Ayden Sinn, Nate Goetsch, Leng Vang, John Quinlan
 * 
 *         Main class to launch the GUI window
 * 
 */

public class Main {
	public static void main(String[] args) {
		Clock.getInstance();
		new Thread() {
			@Override
			public void run() {
				Application.launch(GUIDisplay.class);// The null param is not necessary
			}
		}.start();
	}
}
