package edu.ics372.groupProject2.states;

import edu.ics372.groupProject2.timer.Notifiable;
import edu.ics372.groupProject2.timer.Timer;

/**
 * Represent the Completed state
 *
 * @author Qaalib Farah, Ayden Sinn, Nate Goetsch, Leng Vang, John Quinlan
 *
 */

public class CompleteState extends PlayerState implements Notifiable {
	private static CompleteState instance;
	Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private CompleteState() {

	}

	/**
	 * For the singleton pattern
	 *
	 * @return the object
	 */
	public static CompleteState getInstance() {
		if (instance == null) {
			instance = new CompleteState();
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

	/**
	 * Handle selecting a show
	 */
	@Override
	public void onSelectShowRequest() {
		PlayerContext.getInstance().changeState(BeginningState.getInstance());
	}

	/**
	 * Handle Player play event
	 */
	@Override
	public void onPlayShowRequest() {
		PlayerContext.getInstance().changeState(PlayState.getInstance());
	}

	/**
	 * Handle Player stop event
	 */
	public void onStopRequest() {
		PlayerContext.getInstance().changeState(PlayerOnState.getInstance());
	}

	@Override
	public void onTimerRunsOut() {
		PlayerContext.getInstance().changeState(ScreenSaverState.getInstance());
	}

	@Override
	public void onTimerTicked(int timeLeft) {

	}

	/**
	 * initialize the state
	 *
	 */
	@Override
	public void enter() {
		PlayerContext.getInstance().showCompleteState();
		timer = new Timer(this, 10);
		PlayerContext.getInstance().setTimer(timer);
		PlayerContext.getInstance().timer.setIsRewinding(true);

	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		PlayerContext.getInstance().setTimer(timer);
	}

}
