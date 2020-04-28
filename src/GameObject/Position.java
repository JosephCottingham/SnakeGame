package GameObject;

import javafx.geometry.HPos;

public class Position {
    private int[] yValues;
    private int[] xValues;
    public int length;

    public Position(int[] yValues, int[] xValues, int length){
        this.yValues = yValues;
        this.xValues = xValues;
        this.length = length;
    }

    public void setYX(int[] yValues, int[] xValues, int length){
        this.yValues = yValues;
        this.xValues = xValues;
        this.length = length;
    }

    public int getX(int index) {
        return xValues[index];
    }

    public int getY(int index) {
        return yValues[index];
    }

    public void setX(int index, int value) {
        xValues[index] = value;
    }

    public void setY(int index, int value) {
        yValues[index] = value;
    }

}
