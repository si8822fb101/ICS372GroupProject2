package edu.ics372.groupProject2.timer;

/**
 * An entity that can be notified of timing events
 * 
 * @author Brahma Dathan
 *
 */
public interface Notifiable {
  /**
   * Process timer ticks
   */
  public void OnTimerTick(int timerValue);

  /**
   * Process timer runs out event
   */
  public void onTimerRunsOut();

}
