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
 * Represents the door closed state
 *
 */
public class PlayerOffState extends RemoteState {

	private static PlayerOffState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private PlayerOffState() {
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static PlayerOffState getInstance() {
		if (instance == null) {
			instance = new PlayerOffState();
		}
		return instance;
	}

	/**
	 * Handle player on event
	 */
	@Override
	public void onOnRequest() {
		RemoteContext.getInstance().changeState(PlayerOnState.getInstance());
	}

	/**
	 * initialize the state
	 * 
	 */
	@Override
	public void enter() {
		RemoteContext.getInstance().showPlayerOff();
	}

	@Override
	public void leave() {
		RemoteContext.getInstance().showPlayerOn();
	}
}