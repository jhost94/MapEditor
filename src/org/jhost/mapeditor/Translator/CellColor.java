package org.jhost.mapeditor.Translator;

import org.academiadecodigo.simplegraphics.graphics.Color;

public enum CellColor {
    BLACK(Color.BLACK, 1),
    YELLOW(Color.YELLOW, 2);

    private Color color;
    private int colorCode;

    CellColor(Color color, int colorCode){
        this.color = color;
        this.colorCode = colorCode;
    }

    public int getColorCode(){
        return this.colorCode;
    }

    public Color getColor() {
        return color;
    }
}
