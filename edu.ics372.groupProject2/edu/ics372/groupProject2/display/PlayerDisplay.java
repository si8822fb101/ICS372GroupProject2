package edu.ics372.groupProject2.display;

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
 * Specifies what the display system should do. Note that the implementation has
 * a lot of freedom to choose its display.
 */
public interface PlayerDisplay {
	/**
	 * Displays the show time remaining
	 * 
	 * @param time remaining time
	 */
	public void showTimeLeft(int time);

	/**
	 * Indicate that the player is ON
	 */
	public void showPlayerOn();

	/**
	 * Indicate that the player is OFF
	 */
	public void showPlayerOff();

	/**
	 * Indicate that a show was selected
	 */
	public void showBeginningShow(Show showDetails);

	/**
	 * Indicate that the selected show is playing
	 */
	public void showPlayingShow(Show show, int time);

	/**
	 * indicate that the selected show is paused
	 */
	public void showPausedShow(Show show, int time);

	/**
	 * indicate that the selected show is paused
	 */
	public void showPausedShow();

	/**
	 * indicate that the selected show is stopped
	 */
	public void showStoppedShow();

	/**
	 * indicate that the selected show is rewinding
	 */
	public void showShowRewinding(Show show, int time);

	/**
	 * indicate that the selected show is fast forwarding
	 */
	public void showShowFastwording(Show show, int time);

	/**
	 * indicate that the screen saver is ON
	 */
	public void showScreenSaverOn();

	/**
	 * indicate that the screen saver is OFF
	 */
	public void showScreenSaverOff();

	/**
	 * shows the selected show
	 */
	public void showSelectedShow(Show showSelected);

	/**
	 * Shows the beginning of a show
	 */
	public void showCompleteState();
}
