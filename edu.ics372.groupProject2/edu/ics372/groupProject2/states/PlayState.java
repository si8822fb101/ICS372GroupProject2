package edu.ics372.groupproject2.states;

/**
 * 
 * @author Nathan Lantainge-Goetsch
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
 * Represents the play show state
 *
 */
public class PlayState extends RemoteState {
	private static PlayState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private PlayState() {
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static PlayState getInstance() {
		if (instance == null) {
			instance = new PlayState();
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
		PlayerContext.getInstance().showPlayingShow();
	}

	@Override
	public void leave() {
		PlayerContext.getInstance().showStoppedShow();
	}

}