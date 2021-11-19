package edu.ics372.groupProject2.states;

public class ScreenSaverState extends PlayerState {
	private static ScreenSaverState instance;

	/**
	 * private constructor for the singleton pattern
	 */
	private ScreenSaverState() {
	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static ScreenSaverState getInstance() {
		if (instance == null) {
			instance = new ScreenSaverState();
		}
		return instance;
	}

	@Override
	public void enter() {
		PlayerContext.getInstance().showScreenSaverOn();

	}

	@Override
	public void leave() {
		PlayerContext.getInstance().showScreenSaverOff();
	}

}
