package org.jhost.mapeditor.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell implements Grid{

    private int coll;
    private int row;
    private int size;

    protected Rectangle cell;

    public Cell(int row, int coll, int size){
        this.coll = coll;
        this.row = row;
        this.size = size;
        cell = new Rectangle(collToX(coll), rowToY(row), size, size);
        cell.setColor(Color.BLACK);
    }

    public void draw(){
        cell.draw();
    }

    public void fillColor(Color color){
        this.cell.setColor(color);
        this.cell.fill();
    }


    public void paint(Color color){
        if(cell.getColor() == color && cell.isFilled()){
            System.out.println("Unpainting");
            cell.delete();
            cell.setColor(Color.BLACK);
            cell.draw();
            return;
        }
        System.out.println("Painting");
        cell.delete();
        cell.setColor(color);
        cell.fill();
    }
    

    @Override
    public int rowToY(int row) {
        return row * size + Canvas.PADDING;
    }

    @Override
    public int collToX(int coll) {
        return coll * size + Canvas.PADDING;
    }

    @Override
    public int yToRow(int y) {
        return y / size - Canvas.PADDING;
    }

    @Override
    public int xToColl(int x) {
        return x / size - Canvas.PADDING;
    }

    public int getSize() {
        return size;
    }

    public int getColl() {
        return coll;
    }

    public void setColl(int coll) {
        this.coll = coll;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
