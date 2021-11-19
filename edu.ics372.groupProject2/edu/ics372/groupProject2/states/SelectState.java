package edu.ics372.groupProject2.states;

import edu.ics372.groupProject2.select.Show;

/**
 * 
 * @author Nathan Lantaigne-Goetsch
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
 * Represents the selection state
 *
 */
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
