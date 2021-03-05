package org.jhost.mapeditor.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.jhost.mapeditor.Translator.CellColor;

public class Cell implements Grid{

    private int coll;
    private int row;
    private int size;

    protected Rectangle cell;
    private CellColor color;

    public Cell(int row, int coll, int size){
        this.coll = coll;
        this.row = row;
        this.size = size;
        cell = new Rectangle(collToX(coll), rowToY(row), size, size);
        setColor(CellColor.BLACK);
    }

    public void draw(){
        cell.draw();
    }

    public void fillColor(Color color){
        this.cell.setColor(color);
        this.cell.fill();
    }


    public void paint(CellColor color){
        if(this.color.equals(color) && cell.isFilled()){
            delete();
            return;
        }
        setColor(color);
        cell.fill();
    }

    public void delete(){
        cell.setColor(Color.BLACK);
        cell.draw();
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

    public void setColor(CellColor color){
        this.color = color;
        cell.setColor(color.getColor());
    }

    public CellColor getColor(){
        return this.color;
    }

    public String getColorCode(){
        return cell.isFilled() ? this.color.getColorCode() : "0";
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

    public boolean isFilled(){
        return cell.isFilled();
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
