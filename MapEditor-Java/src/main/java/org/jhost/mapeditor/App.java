package org.jhost.mapeditor;

import org.jhost.mapeditor.grid.Canvas;

public class App {
    public static void main(String[] args) {
        Canvas canvas = new Canvas(120, 80, 10);
        canvas.draw();
    }
}
