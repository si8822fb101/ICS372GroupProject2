package edu.ics372.groupProject2.states;

import edu.ics372.groupProject2.select.Show;

public class SelectState extends PlayerState {
	private static SelectState instance;
	private static Show selectedShow;

	/**
	 * Private constructor for the singleton pattern
	 */
	private SelectState() {
	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static SelectState getInstance(Show show) {
		if (instance == null) {
			instance = new SelectState();
			selectedShow = show;
		}
		return instance;
	}

	/*
	 * Returns the selected show
	 */
	public Show getShow() {
		return selectedShow;
	}

	/*
	 * Handle player off event
	 */
	@Override
	public void onOffRequest() {
		PlayerContext.getInstance().changeState(PlayerOffState.getInstance());
	}

	/*
	 * All of the methods below would become acceptable once a show is selected
	 * Since, that has not been implemented yet. We assume that once the player is
	 * turned on. Then a show is auto selected by the player.
	 */

	/*
	 * Handle select show event
	 */
	public void onSelectShowRequest(Show newSelectedShow) {
		selectedShow = newSelectedShow;
		PlayerContext.getInstance().changeState(SelectState.getInstance(selectedShow));
	}

	/*
	 * Handle play show event
	 */
	@Override
	public void onPlayShowRequest() {
		PlayerContext.getInstance().changeState(PlayState.getInstance());
	}

	/*
	 * Handle pause show event
	 */
	@Override
	public void onPauseShowRequest() {
		PlayerContext.getInstance().changeState(PauseState.getInstance());
	}

	/*
	 * Handle stop show event
	 */
	@Override
	public void onStopShowRequest() {
		PlayerContext.getInstance().changeState(StopState.getInstance());
	}

	/*
	 * Handle fast forward show event
	 */
	@Override
	public void onFastForwardRequest() {
		PlayerContext.getInstance().changeState(FastForwardState.getInstance());
	}

	/*
	 * Handle rewind show event
	 */
	@Override
	public void onRewindRequest() {
		PlayerContext.getInstance().changeState(RewindState.getInstance());
	}

	@Override
	public void enter() {
		PlayerContext.getInstance().showSelectedShow(selectedShow);
	}

	@Override
	public void leave() {
		PlayerContext.getInstance().showSelectedShow(selectedShow);
	}

}