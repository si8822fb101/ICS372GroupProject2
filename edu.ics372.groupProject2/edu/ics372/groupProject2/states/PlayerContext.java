package edu.ics372.groupProject2.states;

import edu.ics372.groupProject2.display.PlayerDisplay;
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
 * The context is an observer for the clock and stores the context info for
 * states
 *
 */
public class PlayerContext {
	private PlayerDisplay display;
	private PlayerState currentState;
	private static PlayerContext instance;
	protected static boolean isShowSelected;
	protected static Show showSelected;

	/**
	 * Make it a singleton
	 */
	private PlayerContext() {
		instance = this;
		currentState = PlayerOffState.getInstance();// UPDATED THIS BY NATE G
	}

	/**
	 * Return the instance
	 *
	 * @return the object
	 */
	public static PlayerContext getInstance() {
		if (instance == null) {
			instance = new PlayerContext();
		}
		return instance;
	}

	/**
	 * The display could change. So we have to get its refrence.
	 *
	 * @param display The current display object
	 */
	public void setDisplay(PlayerDisplay display) {
		this.display = display;
	}

	/**
	 * Lets Player off state be the starting state adds the object as an observable
	 * for clock
	 */
	public void initialize() {
		instance.changeState(PlayerOffState.getInstance());// UPDATED THIS BY NATE G

	}

	/**
	 * Called from the states to change the current state
	 *
	 * @param nextState the next state
	 */
	public void changeState(PlayerState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

	/**
	 * Process turn player ON request
	 */
	public void onOnRequest() {
		currentState.onOnRequest();
	}

	/**
	 * Process transition to BeginningState request
	 */
	public void onBeginningStateRequest() {
		currentState.onBeginningStateRequest();
	}

	/**
	 * Process turn player OFF request
	 */
	public void onOffRequest() {
		currentState.onOffRequest();
	}

	/**
	 * Process play show PLAY request
	 */
	public void onPlayShowRequest() {
		currentState.onPlayShowRequest();
	}

	/**
	 * Process stop show STOP request
	 */
	public void onStopShowRequest() {
		this.showSelected = null;
		this.isShowSelected = false;
		currentState.onStopShowRequest();
	}

	/**
	 * Process pause show PAUSE request
	 */
	public void onPauseShowRequest() {
		currentState.onPauseShowRequest();
	}

	/**
	 * Process fast forwarding FF(Fast Forwarding show) request
	 */
	public void onFastForwardRequest() {
		currentState.onFastForwardRequest();
	}

	/**
	 * Process rewind REW(Rewind show) request
	 */
	public void onRewindRequest() {
		currentState.onRewindRequest();
	}

	/**
	 * Process select show request
	 */
	public void onSelectShowRequest(Show showDetails) {
		this.showSelected = showDetails;
		this.isShowSelected = true;
		currentState.onSelectShowRequest();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 *
	 * @param time time left for cooking
	 */
	public void showTimeLeft(int time) {
		display.showTimeLeft(time);
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 *
	 */
	public void showPlayerOn() {
		display.showPlayerOn();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 *
	 */
	public void showPlayerOff() {
		display.showPlayerOff();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 *
	 */

	public void showSelectedShow() {
		display.showSelectedShow(this.getShowSelected());


	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 *
	 */
	public void showPlayingShow() {
		display.showPlayingShow(this.showSelected);
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 *
	 */
	public void showPausedShow() {
		display.showPausedShow();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 *
	 */
	public void showStoppedShow() {
		display.showStoppedShow();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 *
	 */
	public void showShowRewinding() {
		display.showShowRewinding();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 *
	 */
	public void showShowFastForwarding() {
		display.showShowFastwording();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 *
	 */
	public void showScreenSaverOn() {
		display.showScreenSaverOn();
	}

	public void showStatusBeginningState() {
		display.showBeginningStateStatus();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 *
	 */
	public void showScreenSaverOff() {
		display.showScreenSaverOff();
	}

	public Show getShowSelected() {
		return this.showSelected;
	}

	public boolean isShowSelected() {
		return this.isShowSelected;
	}
}
