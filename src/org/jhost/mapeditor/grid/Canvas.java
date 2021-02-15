package org.jhost.mapeditor.grid;


public class Canvas implements Grid{
    public static final int PADDING = 10;

    private Grid grid;

    private int cellSize;
    private int colls;
    private int rows;

    private Cell[][] cells;

    public Canvas(int width, int height, int cellSize){
        this.colls = width;
        this.rows = height;
        this.cellSize = cellSize;
        cells = new Cell[colls][rows];
    }

    //To fix
    public void draw(){
        for (int i = 0; i < colls; i++) {
            for (int j = 0; j < rows; j++) {
                cells[i][j] = new Cell(collToX(i), rowToY(j), cellSize);
                cells[i][j].draw();
            }
        }
    }

    @Override
    public int rowToY(int row) {
        return row * cellSize + PADDING;
    }

    @Override
    public int collToX(int coll) {
        return coll * cellSize + PADDING;
    }

    @Override
    public int yToRow(int y) {
        return y / cellSize - PADDING;
    }

    @Override
    public int xToColl(int x) {
        return x / cellSize - PADDING;
    }
}
