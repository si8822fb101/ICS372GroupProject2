package edu.ics372.groupProject2.display;

import edu.ics372.groupProject2.buttons.FastForwardButton;
import edu.ics372.groupProject2.buttons.GUIButton;
import edu.ics372.groupProject2.buttons.PauseButton;
import edu.ics372.groupProject2.buttons.PlayButton;
import edu.ics372.groupProject2.buttons.PlayerOffButton;
import edu.ics372.groupProject2.buttons.PlayerOnButton;
import edu.ics372.groupProject2.buttons.RewindButton;
import edu.ics372.groupProject2.buttons.StopButton;
import edu.ics372.groupProject2.states.RemoteContext;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
 * GUI to implement the MicrowaveDisplay interface A pretty elementary interface
 *
 */
public class GUIDisplay extends Application implements RemoteDisplay {
	private GUIButton playerOn;
	private GUIButton playerOff;
	private GUIButton pauseShow;
	private GUIButton playShow;
	private GUIButton rewindShow;
	private GUIButton fastForwardShow;
	private GUIButton stopShow;
	private Label statusText;
	private ListView showList;
	// Hold on to these text vars
	private Text playerStatus = new Text("Status: Player off");
	private Text timerValue = new Text("            ");
	private Text showSelectedStatus = new Text("Show selected: no");
	private Text showStatus = new Text("");
	private Text screenSaverStatus = new Text("Screen saver off");

	/**
	 * Sets up the interface
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		playerOn = new PlayerOnButton("On");// UPDATED CLASS NAME TO PlayerOnButton not: onButton
		playerOff = new PlayerOffButton("Off");// UPDATED CLASS NAME TO PlayerOffButton not: offButton
		playShow = new PlayButton("Play");
		stopShow = new StopButton("Stop");
		pauseShow = new PauseButton("Pause");
		fastForwardShow = new FastForwardButton("FF");
		rewindShow = new RewindButton("Rew");
		statusText = new Label("Status");
		statusText.setMinWidth(50);
		statusText.setMinHeight(50);
		showList = new ListView();
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
		statusText.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		mainPane.add(buttonPane, 0, 0);
		mainPane.add(statusPane, 1, 0, 5, 1);
		statusPane.setVgap(10);
		buttonPane.setVgap(10);
		Scene scene = new Scene(mainPane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Remote Control and Player Interface");
		RemoteContext.getInstance().setDisplay(this);// UPDATED CLASS NAME TO RemoteContext not: PlayerContext
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
	public void showSelectedShow() {
		// showSelectedStatus.setText("Show selected yes");
		statusText.setText("Status: Show selected");
	}

	@Override
	public void showPlayingShow() {
		// showStatus.setText("Playing");
		statusText.setText("Status: Playing");
	}

	@Override
	public void showPausedShow() {
		// showStatus.setText("Paused");
		statusText.setText("Status: Paused");
	}

	@Override
	public void showStoppedShow() {
		// showStatus.setText("Stoped");
		statusText.setText("Status: Stoped");
	}

	@Override
	public void showShowRewinding() {
		// showStatus.setText("Rewinding");
		statusText.setText("Status: Rewinding");
	}

	@Override
	public void showShowFastwording() {
		// showStatus.setText("Fast forwarding");
		statusText.setText("Status: Fast forwarding");
	}

	@Override
	public void showScreenSaverOn() {
		// screenSaverStatus.setText("Screen saver on");
		statusText.setText("Status: Screen saver on");
	}

	@Override
	public void showScreenSaverOff() {
		// screenSaverStatus.setText("Screen saver off");
		statusText.setText("Status: Screen saver off");
	}

}
