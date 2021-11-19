package edu.ics372.groupProject2.select;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;

//Create a singleton class called ShowList with a list of Show objects.
//You need to figure out what a Show object should contain,
//The list could be an ObservableList.
//You could use the following code to select a show.

public class SelectControl extends ListView<Show> implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {
		ShowList.getInstance().getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Show>() {
			@Override
			public void changed(ObservableValue<? extends Show> observable, Show oldValue, Show newValue) {
				System.out.println(
						"ListView selection changed from oldValue = " + oldValue + " to newValue = " + newValue);
			}
		});
	}
}

