package edu.ics372.groupProject2.select;

import edu.ics372.groupProject2.states.FastForwardState;
import edu.ics372.groupProject2.states.PauseState;
import edu.ics372.groupProject2.states.PlayState;
import edu.ics372.groupProject2.states.PlayerContext;
import edu.ics372.groupProject2.states.RewindState;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

//Create a singleton class called ShowList with a list of Show objects.
//You need to figure out what a Show object should contain,
//The list could be an ObservableList.
//You could use the following code to select a show.

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