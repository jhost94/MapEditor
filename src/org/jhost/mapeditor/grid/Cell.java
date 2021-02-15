package org.jhost.mapeditor.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    private int coll;
    private int row;
    private int size;

    private Rectangle cell;

    public Cell(int row, int coll, int size){
        this.coll = coll;
        this.row = row;
        this.size = size;
        cell = new Rectangle(coll, row, size, size);
        cell.setColor(Color.BLACK);
    }

    public void draw(){
        cell.draw();
    }
}
