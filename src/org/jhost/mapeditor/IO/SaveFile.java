package org.jhost.mapeditor.IO;

import java.io.*;

public class SaveFile {
    private static final String NEWLINE = "\n";
    private BufferedReader breader;
    private BufferedWriter bwriter;

    public String load(String path) {
        String result = "";
        try {
            this.breader = new BufferedReader(new FileReader(path));
            result = readFile();
            breader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    public void save(String path, String s){
        try {
            bwriter = new BufferedWriter(new FileWriter(path));
            bwriter.write(s.trim());
            bwriter.close();
            System.out.println("saved in " + path);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


    //To be fixed
    private String readFile(){
        return breader.lines()
                .reduce("", (acc, line) -> !line.equals("\\s") ? acc + line + NEWLINE : acc);
    }
}
