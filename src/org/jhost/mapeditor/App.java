package org.jhost.mapeditor;

import org.jhost.mapeditor.IO.SaveFile;
import org.jhost.mapeditor.grid.Canvas;

public class App {
    public static void main(String[] args) {
        Canvas canvas = new Canvas(30, 30, 10);
        canvas.draw();

        SaveFile file = new SaveFile();
        String test = file.load("resources/test.txt");
        System.out.println(test);
        file.save("resources/test2.txt", test);
    }
}
