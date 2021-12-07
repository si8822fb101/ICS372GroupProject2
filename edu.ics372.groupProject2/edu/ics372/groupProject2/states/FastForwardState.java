package edu.ics372.groupProject2.states;

import edu.ics372.groupProject2.select.Show;
import edu.ics372.groupProject2.timer.Notifiable;
import edu.ics372.groupProject2.timer.Timer;

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
public class FastForwardState extends PlayerState implements Notifiable {
	private static FastForwardState instance;
	private Timer timer;
	private Show currentShow = PlayerContext.showSelected;

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

	/*
	 * Handle pause show event
	 */
	@Override
	public void onPauseShowRequest() {
		PlayerContext.getInstance().timer.stop();
		PlayerContext.getInstance().changeState(PauseState.getInstance());

	}

	/*
	 * Handle stop show event
	 */
	@Override
	public void onStopShowRequest() {
		PlayerContext.getInstance().timer.stop();
		PlayerContext.getInstance().showStoppedShow();
		PlayerContext.getInstance().showCompleteState();
		PlayerContext.getInstance().changeState(PlayerOnState.getInstance());

	}

	@Override
	public void onTimerTicked(int timeLeft) {
		PlayerContext.getInstance().timer.addTimeValue(-1);
		PlayerContext.getInstance().showShowFastForwarding();
	}

	@Override
	public void onTimerRunsOut() {
		PlayerContext.getInstance().showTimeLeft(0);
		PlayerContext.getInstance().showCompleteState();
		PlayerContext.getInstance().changeState(BeginningState.getInstance());//
	}

	@Override
	public void enter() {
		PlayerContext.getInstance().timer.setIsRewinding(false);
		PlayerContext.getInstance().timer.stop();
		timer = new Timer(this, PlayerContext.getInstance().timer.getTimeValue());
		PlayerContext.getInstance().setTimer(timer);
		PlayerContext.getInstance().showShowFastForwarding();
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

}
