package edu.ics372.groupProject2.states;

import edu.ics372.groupProject2.timer.Notifiable;
import edu.ics372.groupProject2.timer.Timer;

/**
 * 
 * Represents the idle; show selected state
 * 
 * @author Qaalib Farah
 *
 */
public class SelectState extends PlayerState implements Notifiable {

	private static SelectState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private SelectState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static SelectState getInstance() {
		if (instance == null) {
			instance = new SelectState();
		}

		return instance;
	}

	public void onOffRequest() {
		PlayerContext.getInstance().changeState(PlayerOffState.getInstance());
	}

	/*
	 * Handle play show request
	 */
	@Override
	public void onPlayShowRequest() {
		PlayerContext.getInstance().changeState(PlayState.getInstance());
	}

	/*
	 * Process clock ticks Generates the timer runs out event
	 */
	public void onTimerRunsOut() {
//		PlayerContext.getInstance().changeState(ScreenSaverState.getInstance());
	}

	@Override
	public void enter() {
<<<<<<< HEAD
		isShowSelected = true;
		timer = new Timer(this, 10000);
		PlayerContext.getInstance().showSelectedShow(showSelected);
=======
		timer = new Timer(this, 10000);
		PlayerContext.getInstance().showSelectedShow();
>>>>>>> 53dba9b (revamped the design)
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

}