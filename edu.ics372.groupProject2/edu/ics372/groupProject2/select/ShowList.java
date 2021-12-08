package edu.ics372.groupProject2.select;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 
 * @author Qaalib Farah, Ayden Sinn, Nate Goetsch, Leng Vang, John Quinlan
 *
 *         Show List class is the collection class from show objects
 *
 */
public class ShowList {
	private static ShowList instance;
	private ObservableList<Show> shows;

	/**
	 * Private for the singleton pattern
	 */
	private ShowList() {
		shows = FXCollections.observableArrayList();
		for (int i = 0; i < 5; i++) {
			shows.add(new Show("n" + (i + 1), (i + 1) * 10));
		}
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
