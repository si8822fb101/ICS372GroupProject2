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
 * Super class for all states
 * 
 *
 */
public abstract class PlayerState {

	/**
	 * Initializes the state
	 */
	public abstract void enter();

	/**
	 * Performs any necessary clean up while leaving the state
	 */
	public abstract void leave();

	/**
	 * Specifies the actions to be taken when the ON button is pressed
	 */
	public void onOnRequest() {

	}

	/**
	 * Specifies the actions to be taken when the OFF button is pressed
	 */
	public void onOffRequest() {

	}

	/**
	 * Specifies the actions to be taken when entering the BeginningState
	 */
	public void onBeginningStateRequest() {

	}

	/**
	 * Specifies the actions to be taken when the PLAY button is pressed
	 */
	public void onPlayShowRequest() {

	}

	/**
	 * Specifies the actions to be taken when the STOP button is pressed
	 */
	public void onStopShowRequest() {

	}

	/**
	 * Specifies the actions to be taken when the PAUSE button is pressed
	 */
	public void onPauseShowRequest() {

	}

	/**
	 * Specifies the actions to be taken when the FF(Fast Forwarding) button is
	 * pressed
	 */
	public void onFastForwardRequest() {

	}

	/**
	 * Specifies the actions to be taken when the REW(REWIND) button is pressed
	 */
	public void onRewindRequest() {

	}

	/**
	 * Specifies actions to be taken when a show is selected
	 */
	public void onSelectShowRequest() {

	}

	/**
	 * Specifies actions to be taken when a show is selected w/ show parameter
	 */
	public void onSelectShowRequest(Show show) {

	}

	/**
	 * Process clock ticks Generates the timer runs out event
	 */
	public void onTimerRunsOut() {

	}

	/**
	 * Process clock tick Generates the timer runs out event
	 */
	public void onTimerTick(int timerValue) {

	}

	/**
	 * Specifies actions when a show ends
	 */
	public void onShowEnds() {

	}

}
