package org.jhost.mapeditor;

import org.jhost.mapeditor.IO.SaveFile;

public class App {
    public static void main(String[] args) {
        SaveFile file = new SaveFile();
        System.out.println(file.load("resources/test.txt"));
    }
}
