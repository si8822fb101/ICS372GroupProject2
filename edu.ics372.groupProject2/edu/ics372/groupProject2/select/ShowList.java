package edu.ics372.groupProject2.select;

import javafx.collections.ObservableList;

public class ShowList {
	private static ShowList instance;
	private ObservableList<Show> shows;

	/**
	 * Private for the singleton pattern
	 */
	private ShowList() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static ShowList getInstance() {
		if (instance == null) {
			instance = new ShowList();
		}
		return instance;
	}

	public ObservableList<Show> getShows() {
		return this.shows;
	}

}
