package org.jhost.mapeditor.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;

public class Cursor extends Cell{

    private Canvas canvas;
    private boolean moving;
    private Direction direction;

    public Cursor(int size, Color color, Canvas canvas) {
        super(0, 0, size);
        super.fillColor(color);
        this.canvas = canvas;
    }

    public void move(){
        canvas.paint(getColl(), getRow(), Color.BLACK);
        switch (direction){
            case UP:
                if (getRow() > 0){
                    setRow(getRow() - 1);
                    cell.translate(0, -getSize());
                }
                break;
            case DOWN:
                if (getRow() < canvas.getRows() - 1){
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


    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
