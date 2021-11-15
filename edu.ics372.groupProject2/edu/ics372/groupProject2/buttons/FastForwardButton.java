package edu.ics372.groupproject2.buttons;

import edu.ics372.groupproject2.states.PlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The player on request is made using an instance of this class
 * 
 * @author Nathan Lantaigne-Goetsch
 *
 */
public class FastForwardButton extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * Create the button with the proper display
	 * 
	 * @param string the text to be put
	 */
	public FastForwardButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent arg0) {
		PlayerContext.getInstance().onFastForwardRequest();
	}

}
