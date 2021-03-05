package org.jhost.mapeditor.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.jhost.mapeditor.Translator.CellColor;

import java.util.Arrays;

public class Cursor extends Cell{

    private Canvas canvas;
    private boolean moving;
    private Direction direction;
    private CellColor colorToPaint;

    public Cursor(int size, Color color, Canvas canvas) {
        //test
        super(4, 0, size);
        super.fillColor(color);
        this.canvas = canvas;
        this.colorToPaint = CellColor.BLACK;
    }

    public void move(){
        canvas.paint(getColl(), getRow(), colorToPaint);
        switch (direction){
            case UP:
                //test
                if (getRow() > 4){
                    setRow(getRow() - 1);
                    cell.translate(0, -getSize());
                }
                break;
            case DOWN:
                //test
                if (getRow() < canvas.getRows() + 3){
                    setRow(getRow() + 1);
                    cell.translate(0, getSize());
                }
                break;
            case LEFT:
                if (getColl() > 0){
                    setColl(getColl() - 1);
                    cell.translate(-getSize(), 0);
                }
                break;
            case RIGHT:
                if (getColl() < canvas.getColls() - 1){
                    setColl(getColl() + 1);
                    cell.translate(getSize(), 0);
                }
        }
    }

    public void rotateColor(){
        int colorOrdinal = Arrays.stream(CellColor.values())
                .filter(c -> c.equals(colorToPaint)).findFirst().get().ordinal() + 1;
        colorToPaint= colorOrdinal >= CellColor.values().length ?
                CellColor.BLACK : CellColor.values()[colorOrdinal];
    }

    public boolean isMoving() {
        return moving;
    }

    public Direction getDirection() {
        return direction;
    }

    public CellColor getColorToPaint() {
        return colorToPaint;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
