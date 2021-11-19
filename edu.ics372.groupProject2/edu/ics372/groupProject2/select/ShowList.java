package edu.ics372.groupProject2.select;

import javafx.collections.ObservableList;

public class ShowList extends SelectControl {
	private static ShowList instance;
	private ObservableList<Show> shows;
	private Show selectedShow;

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

	public Show getShow() {
		return this.selectedShow;
	}

	public void setShow(Show show) {
		this.selectedShow = show;
	}

}
