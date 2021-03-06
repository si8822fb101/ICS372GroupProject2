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

import edu.ics372.groupProject2.select.Show;
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
 * Represents the pause show state
 *
 */
public class PauseState extends PlayerState implements Notifiable { // Notifiable implementation?
	private static PauseState instance;
	private Timer timer;
	private Show currentPausedShow = PlayerContext.showSelected;

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
		PlayerContext.getInstance().showPlayerOff();
	}

	@Override
	public void onStopShowRequest() {
		PlayerContext.getInstance().changeState(CompleteState.getInstance());
	}

	@Override
	public void onTimerTicked(int timeLeft) {
		PlayerContext.getInstance().showPausedShow();
	}

	/*
	 * Handle play show event
	 */
	@Override
	public void onPlayShowRequest() {
		timer = new Timer(this, PlayerContext.getInstance().timer.getTimeValue());
		PlayerContext.getInstance().changeState(PlayState.getInstance());
	}

	@Override
	public void enter() {
		PlayerContext.getInstance().timer.stop();
		PlayerContext.getInstance().showTimeLeft(PlayerContext.getInstance().timer.getTimeValue());
		PlayerContext.getInstance().showPausedShow();
	}

	@Override
	public void leave() {

	}

}
