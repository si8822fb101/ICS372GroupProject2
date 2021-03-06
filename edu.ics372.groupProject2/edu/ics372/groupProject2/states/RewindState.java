package edu.ics372.groupProject2.states;

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
 * Represents the rewind show state
 *
 */
public class RewindState extends PlayerState implements Notifiable {
	private static RewindState instance;
	private Timer timer;
	private Show currentShow = PlayerContext.showSelected;

	/**
	 * Private constructor for the singleton pattern
	 */
	private RewindState() {
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static RewindState getInstance() {
		if (instance == null) {
			instance = new RewindState();
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

	@Override
	public void onTimerTicked(int timeLeft) {
		PlayerContext.getInstance().timer.addTimeValue(-1);
		PlayerContext.getInstance().showShowRewinding();
	}

	@Override
	public void onTimerRunsOut() {
		PlayerContext.getInstance().showTimeLeft(0);
		PlayerContext.getInstance().showCompleteState();
		PlayerContext.getInstance().changeState(BeginningState.getInstance());//
	}

	@Override
	public void enter() {
		PlayerContext.getInstance().timer.stop();
		timer = new Timer(this, PlayerContext.getInstance().timer.getTimeValue());
		PlayerContext.getInstance().setTimer(timer);
		PlayerContext.getInstance().timer.setIsRewinding(true);
		PlayerContext.getInstance().showShowRewinding();
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

}
