package org.jhost.mapeditor.Translator;

import org.academiadecodigo.simplegraphics.graphics.Color;

public enum CellColor {
    BLACK(Color.BLACK, "1"),
    YELLOW(Color.YELLOW, "2"),
    BLUE(Color.BLUE, "3");

    private Color color;
    private String colorCode;

    CellColor(Color color, String colorCode){
        this.color = color;
        this.colorCode = colorCode;
    }

    public String getColorCode(){
        return this.colorCode;
    }

    public Color getColor() {
        return color;
    }
}
