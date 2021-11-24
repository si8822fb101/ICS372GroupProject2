package edu.ics372.groupProject2.states;
import edu.ics372.groupProject2.timer.Notifiable;
import edu.ics372.groupProject2.timer.Timer;

/**
 * Represent the Completed state
 *
 * @author lengvang
 *
 */

public class CompleteState extends PlayerState implements Notifiable {
	private static CompleteState instance;
	private Timer timer;

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
		PlayerContext.getInstance().changeState(BeginningState.getInstance());
	}


	/**
	 * initialize the state
	 *
	 */

	@Override
	public void enter() {
		timer = new Timer(this, 10000);
		PlayerContext.getInstance().showScreenSaverOn();

	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

}
