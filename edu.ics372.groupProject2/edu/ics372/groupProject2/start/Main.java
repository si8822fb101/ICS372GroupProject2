package edu.ics372.groupProject2.start;

import edu.ics372.groupProject2.display.GUIDisplay;
import edu.ics372.groupProject2.timer.Clock;
import javafx.application.Application;

public class Main {
	public static void main(String[] args) {
		Clock.getInstance();
		new Thread() {
			@Override
			public void run() {
				Application.launch(GUIDisplay.class, null);//The null param is not necessary
			}
		}.start();
	}
}
