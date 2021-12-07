module edu.ics372.groupProject2 {
	requires javafx.controls;
	requires javafx.base;
	requires java.desktop;
	requires javafx.graphics;

	exports edu.ics372.groupProject2.display to javafx.graphics;
	exports edu.ics372.groupProject2.start to javafx.graphics;
}