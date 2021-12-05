package edu.ics372.groupProject2.display;

import edu.ics372.groupProject2.buttons.FastForwardButton;
import edu.ics372.groupProject2.buttons.GUIButton;
import edu.ics372.groupProject2.buttons.PauseButton;
import edu.ics372.groupProject2.buttons.PlayButton;
import edu.ics372.groupProject2.buttons.PlayerOffButton;
import edu.ics372.groupProject2.buttons.PlayerOnButton;
import edu.ics372.groupProject2.buttons.RewindButton;
import edu.ics372.groupProject2.buttons.StopButton;
import edu.ics372.groupProject2.select.SelectControl;
import edu.ics372.groupProject2.select.Show;
import edu.ics372.groupProject2.states.PlayerContext;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * 
 * @author Nathan lantaigne-Goetsch
 * @Copyright (c) 2021
 
 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - the use is for academic purpose only
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Neither the name of Brahma Dathan or Sarnath Ramnath
 *     may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in this module
 * and are not responsible for any loss or damage resulting from its use.  
 */

/**
 * GUI to implement the Player/Remote Control interface A pretty elementary
 * interface
 *
 */
public class GUIDisplay extends Application implements PlayerDisplay {
	private GUIButton playerOn;
	private GUIButton playerOff;
	private GUIButton pauseShow;
	private GUIButton playShow;
	private GUIButton rewindShow;
	private GUIButton fastForwardShow;
	private GUIButton stopShow;
	private Text statusText;
	private SelectControl showList;
	// Hold on to these text vars
	private Text timerValue = new Text("            ");

	/**
	 * Sets up the interface
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		playerOn = new PlayerOnButton("On");
		playerOff = new PlayerOffButton("Off");
		playShow = new PlayButton("Play");
		stopShow = new StopButton("Stop");
		pauseShow = new PauseButton("Pause");
		fastForwardShow = new FastForwardButton("FF");
		rewindShow = new RewindButton("Rew");
		statusText = new Text("Status: Player OFF");
		showList = new SelectControl();
		GridPane mainPane = new GridPane();
		mainPane.setHgap(10);
		mainPane.setVgap(10);
		GridPane statusPane = new GridPane();
		GridPane buttonPane = new GridPane();
		buttonPane.add(playerOn, 0, 0);
		buttonPane.add(playerOff, 0, 1);
		buttonPane.add(playShow, 0, 2);
		buttonPane.add(stopShow, 0, 3);
		buttonPane.add(pauseShow, 0, 4);
		buttonPane.add(fastForwardShow, 0, 5);
		buttonPane.add(rewindShow, 0, 6);
		// to add list view control to status pane
		statusPane.add(statusText, 0, 0);
		statusPane.add(showList, 0, 1);
		statusPane.setStyle("-fx-background-color: white;");
		mainPane.add(buttonPane, 0, 0);
		mainPane.add(statusPane, 1, 0, 5, 1);
		statusPane.setVgap(10);
		buttonPane.setVgap(10);
		Scene scene = new Scene(mainPane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Remote Control and Player Interface");
		PlayerContext.getInstance().setDisplay(this);// UPDATED CLASS NAME TO RemoteContext not: PlayerContext
		primaryStage.show();
		primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				System.exit(0);
			}
		});
	}

	// pane.add(playerStatus, 0, 0);
	// pane.add(showSelectedStatus, 1, 0);
	// pane.add(showStatus, 2, 0);
	// pane.add(screenSaverStatus, 3, 0);

	@Override
	public void showTimeLeft(int time) {
		// timerValue.setText(" " + time);
		statusText.setText(" " + time);
	}

	@Override
	public void showPlayerOn() {
		// playerStatus.setText("Player ON");
		statusText.setText("Status: Player ON");
	}

	@Override
	public void showPlayerOff() {
		// playerStatus.setText("Player OFF");
		statusText.setText("Status: Player OFF");
	}

	@Override
	public void showBeginningShow(Show showDetails) {
		// showSelectedStatus.setText("Show selected yes");
		statusText.setText("" + showDetails.getName() + " " + showDetails.getTime() + " seconds left.");
	}

	@Override
	public void showPlayingShow(Show show, int time) {
		// showStatus.setText("Playing");
		statusText.setText("Playing " + show.getName() + " " + formatShowTime(time, show.getTime()));

	}

	@Override
	public void showCompleteState() {
		// showStatus.setText("Playing");
		statusText.setText("No show selected "); // old text, Status: In Complete State.

	}

	@Override
	public void showPausedShow(Show show, int time) {
		// showStatus.setText("Paused");
		statusText.setText("Status: Paused " + formatShowTime(time, show.getTime()) + " seconds left.");
	}

	@Override
	public void showStoppedShow() {
		// showStatus.setText("Stopped");
		statusText.setText("Status: Stopped");
	}

	@Override
	public void showShowRewinding(Show show, int time) {
		// showStatus.setText("Rewinding");
		statusText.setText("Rewinding " + show.getName() + " " + formatShowTime(time, show.getTime()));
	}

	@Override
	public void showShowFastwording(Show show, int time) {
		// showStatus.setText("Fast forwarding");
		statusText.setText("fast Forwarding " + show.getName() + " " + formatShowTime(time, show.getTime()));
	}

	@Override
	public void showScreenSaverOn() {
		// screenSaverStatus.setText("Screen saver on");
		statusText.setText("Status: ICS372-01");
	}

	@Override
	public void showScreenSaverOff() {
		// screenSaverStatus.setText("Screen saver off");
		statusText.setText("Status: Screen saver off");
	}

	@Override
	public void showSelectedShow(Show showDetails) {
		statusText.setText(showDetails.getName()); // removed "Status: Selected Show "
	}

	private String formatShowTime(int timeLeft, int totalTime) {
		String timeLeftMinutes = Integer.toString(timeLeft / 60);
		String timeLeftSeconds = Integer.toString(timeLeft % 60);
		String totalTimeMinutes = Integer.toString(totalTime / 60);
		String totalTimeSeconds = Integer.toString(totalTime % 60);
		if (timeLeftMinutes.length() < 2) {
			timeLeftMinutes = "0" + timeLeftMinutes;
		}
		if (timeLeftSeconds.length() < 2) {
			timeLeftSeconds = "0" + timeLeftSeconds;
		}
		if (totalTimeMinutes.length() < 2) {
			totalTimeMinutes = "0" + totalTimeMinutes;
		}
		if (totalTimeSeconds.length() < 2) {
			totalTimeSeconds = "0" + totalTimeSeconds;
		}

		return timeLeftMinutes + ":" + timeLeftSeconds + "/" + totalTimeMinutes + ":" + totalTimeSeconds;
	}

	@Override
	public void showPausedShow() {
		// TODO Auto-generated method stub
	}
}
