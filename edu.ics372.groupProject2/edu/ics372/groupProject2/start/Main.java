package edu.ics372.groupProject2.start;

import edu.ics372.groupProject2.display.GUIDisplay;
import javafx.application.Application;

public class Main {
	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				Application.launch(GUIDisplay.class, null);
			}
		}.start();
	}
}
