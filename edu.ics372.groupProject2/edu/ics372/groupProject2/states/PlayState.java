package edu.ics372.groupProject2.states;

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
 * Represents the play show state
 *
 */
public class PlayState extends PlayerState implements Notifiable {
	private static PlayState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private PlayState() {
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static PlayState getInstance() {
		if (instance == null) {
			instance = new PlayState();
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
	 * Handle pause show event
	 */
	@Override
	public void onPauseShowRequest() {
		PlayerContext.getInstance().changeState(PauseState.getInstance());
	}

	/*
	 * Handle stop show event
	 */
	@Override
	public void onStopShowRequest() {
		PlayerContext.getInstance().changeState(PlayerOnState.getInstance());
	}

	/*
	 * Handle fast forward show event
	 */
	@Override
	public void onFastForwardRequest() {
		PlayerContext.getInstance().changeState(FastForwardState.getInstance());
	}

	/*
	 * Handle rewind show event
	 */
	@Override
	public void onRewindRequest() {
		PlayerContext.getInstance().changeState(RewindState.getInstance());
	}

	/**
	 * Process the timer runs out event
	 */
	@Override
	public void onTimerRunsOut() {
		PlayerContext.getInstance().showTimeLeft(0);
		this.onStopShowRequest();
	}

	@Override
	public void enter() {
		// timer = new Timer(this, getTimeOfSelectedShowHere);
		// need to implement showTime field for specific show play lengths.
		timer = new Timer(this, PlayerContext.getInstance().getShowSelected().getTime());
		PlayerContext.getInstance().showPlayingShow();
		PlayerContext.getInstance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void leave() {
		PlayerContext.getInstance().showStoppedShow();
		// timer = null;
		timer = null;

		// timer could possibly be set to 10, so it can begin countdown for
		// screen saver initializing
		timer.addTimeValue(10);

		// Possibly change showTimeLeft below to 0 or nothing at all
		PlayerContext.getInstance().showTimeLeft(0);

	}

}
