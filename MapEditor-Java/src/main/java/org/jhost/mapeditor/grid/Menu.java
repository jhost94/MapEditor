package org.jhost.mapeditor.grid;

import org.jhost.mapeditor.Translator.CellColor;

public class Menu implements Grid{

    private int menuCellSize;
    private Cell menuIconOne;
    private CellColor color;

    public Menu(int menuCellSize, CellColor color){
        this.color = color;
        this.menuCellSize = menuCellSize;
        this.menuIconOne = new Cell(0, 0, menuCellSize);
    }

    public void draw(){
        menuIconOne.fillColor(color.getColor());
    }

    public void changeColor(CellColor color){
        menuIconOne.fillColor(color.getColor());
    }

    @Override
    public int rowToY(int row) {
        return row * menuCellSize + Canvas.PADDING;
    }

    @Override
    public int collToX(int coll) {
        return coll * menuCellSize + Canvas.PADDING;
    }

    @Override
    public int yToRow(int y) {
        return (y - Canvas.PADDING) / menuCellSize;
    }

    @Override
    public int xToColl(int x) {
        System.out.println(x);
        return (x - Canvas.PADDING) / (menuCellSize / 3) + 1;
    }
}
