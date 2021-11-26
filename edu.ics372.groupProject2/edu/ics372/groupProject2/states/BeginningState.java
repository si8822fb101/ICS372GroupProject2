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
//		PlayerContext.getInstance().changeState(ScreenSaverState.getInstance());
	}

	@Override
	public void enter() {
<<<<<<< HEAD:edu.ics372.groupProject2/edu/ics372/groupProject2/states/SelectState.java
<<<<<<< HEAD
		isShowSelected = true;
		timer = new Timer(this, 10000);
		PlayerContext.getInstance().showSelectedShow(showSelected);
=======
		timer = new Timer(this, 10000);
		PlayerContext.getInstance().showSelectedShow();
>>>>>>> 53dba9b (revamped the design)
=======
		timer = new Timer(this, 10000);
		PlayerContext.getInstance().showBeginningShow();
>>>>>>> main:edu.ics372.groupProject2/edu/ics372/groupProject2/states/BeginningState.java
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

}