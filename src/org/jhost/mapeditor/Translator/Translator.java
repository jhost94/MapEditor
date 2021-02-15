package org.jhost.mapeditor.Translator;

import java.util.Arrays;

public class Translator {
    public static CellColor getCellColorByChar(int n){
        return Arrays.stream(CellColor.values()).filter(cc -> cc.getColorCode() == n)
                .findFirst().orElse(CellColor.BLACK);
    }
}
