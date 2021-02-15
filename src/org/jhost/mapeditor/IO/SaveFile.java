package org.jhost.mapeditor.IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SaveFile {
    private BufferedReader breader;

    public SaveFile() {

    }

    public String load(String path) {
        String result = "";
        try {
            this.breader = new BufferedReader(new FileReader(path));
            result = doLoad();
        } catch (
                FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                breader.close();
            } catch (IOException e){

            }
        }
        return result;
    }

    private String doLoad(){
        return breader.lines().reduce("", (acc, word) -> acc + word + "\n\r");
    }
}
