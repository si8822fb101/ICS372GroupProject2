package edu.ics372.groupProject2.states;

/**
 * 
 * @author Qaalib Farah, Ayden Sinn, Nate Goetsch, Leng Vang, John Quinlan
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
 * Represents the Screen saver state
 *
 */
public class ScreenSaverState extends PlayerState {
	private static ScreenSaverState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private ScreenSaverState() {
	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static ScreenSaverState getInstance() {
		if (instance == null) {
			instance = new ScreenSaverState();
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
	 * Handle select show event
	 */
	@Override
	public void onSelectShowRequest() {
		PlayerContext.getInstance().changeState(BeginningState.getInstance());
	}

	/*
	 * Handle play show event
	 */
	@Override
	public void onPlayShowRequest() {
		// if a show is selected
		// then play show
		// otherwise undo screen saver
		PlayerContext.getInstance().changeState(PlayerOnState.getInstance());
	}

	@Override
	public void onPauseShowRequest() {
		PlayerContext.getInstance().changeState(PlayerOnState.getInstance());
	}

	/*
	 * Handle stop show event
	 */
	@Override
	public void onStopShowRequest() {
		PlayerContext.getInstance().changeState(PlayerOnState.getInstance());
	}

	/*
	 * Handle rewind show event
	 */
	@Override
	public void onRewindRequest() {
		PlayerContext.getInstance().changeState(PlayerOnState.getInstance());
	}

	/*
	 * Handle fast forward show event
	 */
	@Override
	public void onFastForwardRequest() {
		PlayerContext.getInstance().changeState(PlayerOnState.getInstance());
	}

	/*
	 * Handle select show event
	 */
	@Override
	public void onOnRequest() {
		PlayerContext.getInstance().changeState(PlayerOnState.getInstance());
	}

	@Override
	public void enter() {
		PlayerContext.getInstance().showScreenSaverOn();
	}

	@Override
	public void leave() {
		PlayerContext.getInstance().showPlayerOn();
	}

}
