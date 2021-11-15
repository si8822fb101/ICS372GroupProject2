package edu.ics372.groupProject2.states;

import edu.ics372.groupProject2.display.PlayerDisplay;

public class PlayerContext {
	private PlayerDisplay display;
	private PlayerState currentState;
	private static PlayerContext instance;

	private PlayerContext() {
		instance = this;
	}

	/**
	 * Return the instance
	 * 
	 * @return the object
	 */
	public static PlayerContext getInstance() {
		if (instance == null) {
			instance = new PlayerContext();
		}
		return instance;
	}

	/**
	 * The display could change. So we have to get its refrence.
	 * 
	 * @param display The current display object
	 */
	public void setDisplay(PlayerDisplay display) {
		this.display = display;
	}

}
