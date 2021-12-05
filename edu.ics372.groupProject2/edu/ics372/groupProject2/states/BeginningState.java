package edu.ics372.groupProject2.states;

import edu.ics372.groupProject2.timer.Notifiable;
import edu.ics372.groupProject2.timer.Timer;

/**
 *
 * Represents the idle; show beginning state
 *
 * @author Qaalib Farah
 *
 */
public class BeginningState extends PlayerState implements Notifiable {

	private static BeginningState instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	private BeginningState() {
		instance = this;
	}

	/**
	 * For the singleton pattern
	 *
	 * @return the object
	 */
	public static BeginningState getInstance() {
		if (instance == null) {
			instance = new BeginningState();
		}

		return instance;
	}

	/**
	 * Handle Of request
	 */
	@Override
	public void onOffRequest() {
		PlayerContext.getInstance().changeState(PlayerOffState.getInstance());

	}

	/*
	 * Handle play show request
	 */
	@Override
	public void onPlayShowRequest() {
		PlayerContext.getInstance().changeState(PlayState.getInstance());
		PlayerContext.getInstance().showPlayingShow();
	}

	/**
	 * Handle selecting a show
	 */
	@Override
	public void onSelectShowRequest() {
		PlayerContext.getInstance().changeState(BeginningState.getInstance());
	}

	/*
	 * Process clock ticks Generates the timer runs out event
	 */
	public void onTimerRunsOut() {
		PlayerContext.getInstance().changeState(ScreenSaverState.getInstance());
	}

	@Override
	public void onTimerTicked(int timeLeft) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enter() {
		// System.out.println("Entering beginning(select) state");
		PlayerContext.getInstance().showSelectedShow();
		timer = new Timer(this, 10);
		PlayerContext.getInstance().setTimer(timer);
	}

	@Override
	public void leave() {
		// System.out.println("Leaving beginning(select) state");
		timer.stop();
		timer = null;
		PlayerContext.getInstance().setTimer(timer);
	}

}
