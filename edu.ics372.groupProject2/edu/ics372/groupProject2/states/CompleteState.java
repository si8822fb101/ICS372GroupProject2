package edu.ics372.groupProject2.states;

/**
 * Represent the Completed state
 * 
 * @author lengvang
 *
 */

public class CompleteState extends PlayerState {
	private static CompleteState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private CompleteState() {

	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static CompleteState getInstance() {
		if (instance == null) {
			instance = new CompleteState();
		}
		return instance;
	}

	/*
	 * Handle player off event
	 */
	@Override
	public void onOffRequest() {
		PlayerContext.getInstance().changeState(PlayerOffState.getInstance());
	}

	/**
	 * Handle Player on event
	 */

	public void onPlayShowRequest() {
		PlayerContext.getInstance().changeState(PlayState.getInstance());
	}

	/**
	 * Handle Player stop event
	 */

	public void onStopRequest() {
		PlayerContext.getInstance().changeState(BeginningState.getInstance());
	}

	/**
	 * initialize the state
	 * 
	 */

	@Override
	public void enter() {
		PlayerContext.getInstance().showStoppedShow();

	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

}
