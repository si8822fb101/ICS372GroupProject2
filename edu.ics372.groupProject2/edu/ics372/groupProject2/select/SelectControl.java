package edu.ics372.groupProject2.select;

import edu.ics372.groupProject2.states.FastForwardState;
import edu.ics372.groupProject2.states.PauseState;
import edu.ics372.groupProject2.states.PlayState;
import edu.ics372.groupProject2.states.PlayerContext;
import edu.ics372.groupProject2.states.RewindState;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 * 
 * @author Qaalib Farah, Ayden Sinn, Nate Goetsch, Leng Vang, John Quinlan
 *
 *         Select control class provides a control to select from a list of
 *         shows on the GUI
 * 
 */

public class SelectControl extends ListView<Show> {
	public SelectControl() {
		super(ShowList.getInstance().getShows()); // gets the ObservableList
		setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// Only selects a show when not in the pauseState
				boolean canClick = !(PlayerContext.getInstance().getCurrentState().getClass().equals(PauseState.class)
						|| PlayerContext.getInstance().getCurrentState().getClass().equals(PlayState.class)
						|| PlayerContext.getInstance().getCurrentState().getClass().equals(FastForwardState.class)
						|| PlayerContext.getInstance().getCurrentState().getClass().equals(RewindState.class));
				if (canClick) {
					Show show = (Show) getSelectionModel().getSelectedItem();
					PlayerContext.getInstance().onSelectShowRequest(show);
				}
			}
		});

	}
}