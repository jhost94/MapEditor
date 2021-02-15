package org.jhost.mapeditor.grid;

public interface Grid {
    int rowToY(int row);
    int collToX(int coll);

    int yToRow(int y);
    int xToColl(int x);
}
