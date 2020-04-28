// CSE 205: 11333 | Tue/Thu 4:30 PM
// Assignment: Six Final Project
// Author: Joseph H Cottingham | 1216723703
// Description: Holds data for current location, including all parts if the gameobject cover more then one black in the matrix

package Snake.GameObject;

public class Position {
    private int[] yValues;
    private int[] xValues;
    public int length;

    public Position(int[] yValues, int[] xValues, int length) {
        this.yValues = yValues;
        this.xValues = xValues;
        this.length = length;
    }

    public void setYX(int[] yValues, int[] xValues, int length) {
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
