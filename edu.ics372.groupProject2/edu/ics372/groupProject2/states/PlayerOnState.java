package edu.ics372.groupProject2.states;

import edu.ics372.groupProject2.timer.Notifiable;
import edu.ics372.groupProject2.timer.Timer;

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
 * Represents the player on state
 *
 */
public class PlayerOnState extends PlayerState implements Notifiable {

	private static PlayerOnState instance;
	private Timer timer;
//	private Show showSelected;

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
	 * Handle select show event
	 */
	@Override
	public void onSelectShowRequest() {
		PlayerContext.getInstance().showSelectedShow();
		PlayerContext.getInstance().changeState(BeginningState.getInstance()); // added transition into beginningState
		// once show is selected.
	}

	/*
	 * Handle timer runs out event
	 */
	@Override
	public void onTimerTicked(int timeLeft) {
	}

	public void onTimerRunsOut() {
		PlayerContext.getInstance().changeState(ScreenSaverState.getInstance());
	}

	/**
	 * initialize the state
	 *
	 */
	@Override
	public void enter() {
		// Player turned on enters a state where there is 10 seconds to press a button
		// on the controller. Otherwise the screen saver will be turned on
		PlayerContext.getInstance().showPlayerOn();
		timer = new Timer(this, 10);
		PlayerContext.getInstance().setTimer(timer);
		PlayerContext.getInstance().timer.setIsRewinding(true);
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		PlayerContext.getInstance().showPlayerOff();
		PlayerContext.getInstance().setTimer(timer);
	}

}
