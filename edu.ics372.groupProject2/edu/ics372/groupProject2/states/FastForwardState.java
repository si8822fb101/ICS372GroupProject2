package edu.ics372.groupProject2.states;

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
 * Represents the fast forwarding state
 *
 */
public class FastForwardState extends RemoteState {
	private static FastForwardState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private FastForwardState() {
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static FastForwardState getInstance() {
		if (instance == null) {
			instance = new FastForwardState();
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
	 * Handle play show event
	 */
	@Override
	public void onPlayShowRequest() {
		PlayerContext.getInstance().changeState(PlayState.getInstance());
	}

	@Override
	public void enter() {
		PlayerContext.getInstance().showShowFastForwarding();
	}

	@Override
	public void leave() {
		PlayerContext.getInstance().showPlayerOn();
	}

}