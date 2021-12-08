package edu.ics372.groupProject2.timer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import edu.ics372.groupProject2.states.PlayerContext;

public class Timer implements PropertyChangeListener {
	private int timeValue;
	private Notifiable client;
	private boolean isRewinding = false;

	/**
	 * Sets up the timer for a certain client with an initial time value
	 *
	 * @param client    the client, a Notifiable object
	 * @param timeValue the initial time value after which the timer runs out of
	 *                  time.
	 */
	public Timer(Notifiable client, int timeValue) {
		this.client = client;
		this.timeValue = timeValue;
		Clock.getInstance().addPropertyChangeListener(this);
	}

	/**
	 * The timer value could be changed using this method.
	 *
	 * @param value the increment (could be negative) for the time value.
	 */
	public void addTimeValue(int value) {
		timeValue += value;
	}

	/**
	 * Stops the timer by deleting itself from the list of observers
	 */
	public void stop() {
		Clock.getInstance().removePropertyChangeListener(this);
	}

	/**
	 * Returns the time value left
	 *
	 * @return the time value left in the timer
	 */
	public int getTimeValue() {
		return timeValue;
	}

	/*
	 * Returns the boolean condition of isRewinding
	 * 
	 * @return true if the show is rewinding, otherwise return false
	 */
	public boolean getIsRewinding() {
		return isRewinding;
	}

	public void setIsRewinding(boolean rewinding) {
		isRewinding = rewinding;
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		if (!isRewinding) {
			if (++timeValue >= PlayerContext.getInstance().getShowSelected().getTime()) {
				client.onTimerRunsOut();
				Clock.getInstance().removePropertyChangeListener(this);
			} else {
				client.onTimerTicked(timeValue);
			}
		} else {
			if (--timeValue <= 0) {
				client.onTimerRunsOut();
				Clock.getInstance().removePropertyChangeListener(this);
			} else {
				client.onTimerTicked(timeValue);
			}
		}
	}
}
