package edu.ics372.groupproject2.states;

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
public class PlayerOnState extends RemoteState {

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
		RemoteContext.getInstance().changeState(PlayerOffState.getInstance());
	}
	/*
	 * All of the methods below would become acceptable once a show is selected
	 * Since, that has not been implemented yet. We assume that once the player is
	 * turned on. Then a show is auto selected by the player.
	 */

	/*
	 * Handle play show event
	 */
	@Override
	public void onPlayShowRequest() {
		RemoteContext.getInstance().changeState(PlayState.getInstance());
	}

	/*
	 * Handle pause show event
	 */
	@Override
	public void onPauseShowRequest() {
		RemoteContext.getInstance().changeState(PauseState.getInstance());
	}

	/*
	 * Handle stop show event
	 */
	@Override
	public void onStopShowRequest() {
		RemoteContext.getInstance().changeState(StopState.getInstance());
	}

	/*
	 * Handle fast forward show event
	 */
	@Override
	public void onFastForwardRequest() {
		RemoteContext.getInstance().changeState(FastForwardState.getInstance());
	}

	/*
	 * Handle rewind show event
	 */
	@Override
	public void onRewindRequest() {
		RemoteContext.getInstance().changeState(RewindState.getInstance());
	}

	/*
	 * The above methods will only work once a show has been selected. Which a show
	 * being selected has not quite been implemented yet...
	 */

	/**
	 * initialize the state
	 * 
	 */
	@Override
	public void enter() {
		RemoteContext.getInstance().showPlayerOn();
	}

	@Override
	public void leave() {
		RemoteContext.getInstance().showPlayerOff();
	}
}
