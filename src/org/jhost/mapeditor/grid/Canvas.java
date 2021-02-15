package org.jhost.mapeditor.grid;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.jhost.mapeditor.Handlers.MapKeyboardHandler;

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

    public Canvas(int width, int height, int cellSize){
        init(width, height, cellSize);
    }

    private void init(int width, int height, int cellSize){
        this.cellSize = cellSize;
        this.colls = width;
        this.rows = height;
        this.cells = new Cell[colls][rows];
        this.painting = false;
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

    public void paint(int col, int row, Color color){
        if(painting){
            cells[row][col].paint(color);
        }
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
