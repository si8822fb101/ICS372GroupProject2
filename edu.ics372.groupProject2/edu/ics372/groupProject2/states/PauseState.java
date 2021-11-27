package edu.ics372.groupProject2.states;
/*
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

import edu.ics372.groupProject2.timer.Notifiable;
import edu.ics372.groupProject2.timer.Timer;

/**
 * Represents the pause show state
 *
 */
public class PauseState extends PlayerState implements Notifiable { // Notifiable implementation?
	private static PauseState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private PauseState() {
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static PauseState getInstance() {
		if (instance == null) {
			instance = new PauseState();
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

	@Override
	public void onStopShowRequest() {
		PlayerContext.getInstance().changeState(CompleteState.getInstance());
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
		PlayerContext.getInstance().showPausedShow();
		PlayerContext.getInstance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void leave() {
		PlayerContext.getInstance().showStoppedShow();
	}

	@Override
	public void timerTicked(int timeLeft) { // not sure if if there is a need to implement timerTicked
		// TODO Auto-generated method stub

	}

}
