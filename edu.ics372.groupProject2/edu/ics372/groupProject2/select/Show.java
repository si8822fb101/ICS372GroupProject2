package edu.ics372.groupProject2.select;

/**
 * 
 * 
 * @author Qaalib Farah, Ayden Sinn, Nate Goetsch, Leng Vang, John Quinlan
 * 
 * 
 *         Show class representing a show object that can be used to play,
 *         pause, etc.
 * 
 */
public class Show {

	private String name;
	private int time;

	public Show(String name, int time) {
		this.name = name;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String toString() {
		return "" + name + " " + time;
	}
}
