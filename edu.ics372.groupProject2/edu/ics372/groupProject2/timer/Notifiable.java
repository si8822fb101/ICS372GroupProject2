package edu.ics372.groupProject2.timer;

/**
 * An entity that can be notified of timing events
 * 
 * @author Qaalib Farah, Ayden Sinn, Nate Goetsch, Leng Vang, John Quinlan
 *
 */

public interface Notifiable {

	/**
	 * Process timer runs out event
	 */
	public void onTimerRunsOut();

	public void onTimerTicked(int timeLeft);

}
