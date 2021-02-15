package org.jhost.mapeditor;

import org.jhost.mapeditor.IO.SaveFile;
import org.jhost.mapeditor.grid.Canvas;

public class App {
    public static void main(String[] args) {
        Canvas canvas = new Canvas(100, 100, 10);
        canvas.draw();
    }
}
