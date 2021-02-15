package org.jhost.mapeditor.grid;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.jhost.mapeditor.Handlers.MapKeyboardHandler;
import org.jhost.mapeditor.IO.SaveFile;
import org.jhost.mapeditor.Translator.CellColor;
import org.jhost.mapeditor.Translator.Translator;

public class Canvas{
    public static final int PADDING = 10;

    private int cellSize;
    private int colls;
    private int rows;

    //The grid
    private Cell[][] cells;
    private Cursor cursor;
    private boolean painting;

    //Keyboard handler
    private MapKeyboardHandler keyboardHandler;

    //Save/load IO
    private SaveFile saveFile;
    private String savePath;

    public Canvas(int width, int height, int cellSize){
        init(width, height, cellSize);
    }

    private void init(int width, int height, int cellSize){
        this.cellSize = cellSize;
        this.colls = width;
        this.rows = height;
        this.cells = new Cell[colls][rows];
        this.painting = false;
        this.saveFile = new SaveFile();
        this.savePath = "saves/save.txt";
    }

    //To fix
    public void draw(){
        for (int i = 0; i < colls; i++) {
            for (int j = 0; j < rows; j++) {
                cells[i][j] = new Cell(i, j, cellSize);
                cells[i][j].draw();
            }
        }
        drawCursor();
    }


    private void drawCursor(){
        keyboardHandler = new MapKeyboardHandler(this);
        cursor = new Cursor(cellSize, Color.YELLOW, this);
        keyboardHandler.setCursor(cursor);
    }

    public void paint(int col, int row, CellColor color){
        if(painting){
            cells[row][col].paint(color);
        }
    }

    public void save(){
        System.out.println("Saving");
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < colls; i++) {
            for (int j = 0; j < rows; j++) {
                s.append(cells[i][j].getColorCode());
            }
            s.append("\n");
        }
        System.out.println(s.toString().trim());
        saveFile.save(savePath, s.toString().trim());
    }

    public void load(){
        String s = saveFile.load(savePath);
        String[] sArr = s.split("");
        s.replaceAll("\\s", "");
        int x = 0;
        int y = 0;
        for (int i = 0; i < sArr.length; i++) {
            if(x > cells.length){
                x++;
                continue;
            }
            System.out.println(s.charAt(i));
            if (s.charAt(i) != 0){
                cells[x][y].paint(Translator.getCellColorByChar(Integer.parseInt(sArr[i])));
            }
        }
    }

    public void clear(){

    }

    public boolean isPainting() {
        return painting;
    }

    public void setPainting(boolean painting) {
        this.painting = painting;
    }


    public int getColls() {
        return colls;
    }

    public int getRows() {
        return rows;
    }
}
