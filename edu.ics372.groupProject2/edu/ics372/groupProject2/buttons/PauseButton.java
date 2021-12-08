package edu.ics372.groupProject2.buttons;

import edu.ics372.groupProject2.states.PlayerContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The player on request is made using an instance of this class
 * 
 * @author Qaalib Farah, Ayden Sinn, Nate Goetsch, Leng Vang, John Quinlan
 *
 */
public class PauseButton extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * Create the button with the proper display
	 * 
	 * @param string the text to be put
	 */
	public PauseButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent arg0) {
		PlayerContext.getInstance().onPauseShowRequest();
	}

}
