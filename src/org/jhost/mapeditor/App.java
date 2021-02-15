package org.jhost.mapeditor;

import org.jhost.mapeditor.IO.SaveFile;

public class App {
    public static void main(String[] args) {
        String testFilePath = "resources/test.txt";
        SaveFile file = new SaveFile();
        String test = file.load(testFilePath);
        System.out.println(test);
        file.save("resources/test.txt", test);
    }
}
