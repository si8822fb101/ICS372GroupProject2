package edu.ics372.groupProject2.states;

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
 * Represents the player on state
 *
 */
public class PlayerOnState extends PlayerState {

	private static PlayerOnState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private PlayerOnState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static PlayerOnState getInstance() {
		if (instance == null) {
			instance = new PlayerOnState();
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
	 * Handle show selection request
	 */
	@Override
	public void onSelectRequest() {
		PlayerContext.getInstance().changeState(SelectState.getInstance());
	}

	/*
	 * Handle 10 second times running out
	 */
	public void onTimerRunsOut() {
		PlayerContext.getInstance().changeState(ScreenSaverState.getInstance());
	}

	/**
	 * initialize the state
	 * 
	 */
	@Override
	public void enter() {
		PlayerContext.getInstance().showPlayerOn();
	}

	@Override
	public void leave() {
		PlayerContext.getInstance().showPlayerOff();
	}
}
