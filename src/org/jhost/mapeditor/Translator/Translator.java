package org.jhost.mapeditor.Translator;

import java.util.Arrays;

public class Translator {
    public static CellColor getCellColorByChar(String n){
        return Arrays.stream(CellColor.values()).filter(cc -> cc.getColorCode().equals(n))
                .findFirst().orElse(CellColor.BLACK);
    }
}
