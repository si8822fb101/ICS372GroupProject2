package edu.ics372.groupProject2.states;

/**
 * 
 * Represents the idle; show selected state
 * 
 * @author Qaalib Farah
 *
 */
public class SelectState extends PlayerState {

	private static SelectState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private SelectState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static SelectState getInstance() {
		if (instance == null) {
			instance = new SelectState();
		}
		return instance;
	}

	public void onOffRequest() {
		PlayerContext.getInstance().changeState(PlayerOffState.getInstance());
	}

	/*
	 * Handle play show request
	 */
	@Override
	public void onPlayShowRequest() {
		PlayerContext.getInstance().changeState(PlayState.getInstance());
	}

	/*
	 * Process clock ticks Generates the timer runs out event
	 */
	public void onTimerRunsOut() {
		PlayerContext.getInstance().changeState(ScreenSaverState.getInstance());
	}

	@Override
	public void enter() {
		PlayerContext.getInstance().showSelectedShow();
	}

	@Override
	public void leave() {

	}
}