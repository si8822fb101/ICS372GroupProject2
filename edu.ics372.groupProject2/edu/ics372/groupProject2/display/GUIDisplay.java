package edu.ics372.groupProject2.display;

import edu.ics372.groupProject2.buttons.FastForwardButton;
import edu.ics372.groupProject2.buttons.GUIButton;
import edu.ics372.groupProject2.buttons.OffButton;
import edu.ics372.groupProject2.buttons.OnButton;
import edu.ics372.groupProject2.buttons.PauseButton;
import edu.ics372.groupProject2.buttons.PlayButton;
import edu.ics372.groupProject2.buttons.RewindButton;
import edu.ics372.groupProject2.buttons.StopButton;
import edu.ics372.groupProject2.select.Show;
import edu.ics372.groupProject2.states.PlayerContext;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GUIDisplay extends Application implements PlayerDisplay {

	private GUIButton playerOn;
	private GUIButton playerOff;
	private GUIButton pauseShow;
	private GUIButton playShow;
	private GUIButton rewindShow;
	private GUIButton fastForwardShow;
	private GUIButton stopShow;
	private Label statusText;
	private ListView showList;

	public GUIDisplay() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		playerOn = new OnButton("On");
		playerOff = new OffButton("Off");
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
		showList.getItems().add(new Show("n1", 10));
		showList.getItems().add(new Show("n2", 20));
		showList.getItems().add(new Show("n3", 30));
		showList.getItems().add(new Show("n4", 40));
		showList.getItems().add(new Show("n5", 50));
		statusPane.setStyle("-fx-background-color: white;");
		// statusText.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		statusText.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
//		mainPane.setStyle("-fx-background-color: white;");
		mainPane.add(buttonPane, 0, 0);
		mainPane.add(statusPane, 1, 0, 5, 1);
		statusPane.setVgap(10);
		buttonPane.setVgap(10);
		Scene scene = new Scene(mainPane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Remote Control and Player Interface");
		PlayerContext.getInstance().setDisplay(this);
		primaryStage.show();
		primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				System.exit(0);
			}
		});
	}

}
