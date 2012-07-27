package org.jcrop;

public class Coordinates implements java.io.Serializable {

    public Coordinates(Integer x, Integer y, Integer x2, Integer y2) {
        if (isNullAndNotNegative(x) || isNullAndNotNegative(y)
                || (isNullAndNotNegative(x2)) || isNullAndNotNegative(y2) ) {
            throw new RuntimeException("Invalid coordinates: [x=" + x + ", y=" + y + ", x2=" + x2 + ", y2=" + y2 + "]");
        }

        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
    }

    private Integer x = 0;
    private Integer y = 0;
    private Integer x2 = 0;
    private Integer y2 = 0;

    public String toJsArray() {
        return "[" + x + ", " + y + ", " + x2 + ", " + y2 + "]";
    }

    protected boolean isNullAndNotNegative(Integer value) {
        return ((value == null) || (value < 0));
    }
    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getX2() {
        return x2;
    }

    public void setX2(Integer x2) {
        this.x2 = x2;
    }

    public Integer getY2() {
        return y2;
    }

    public void setY2(Integer y2) {
        this.y2 = y2;
    }

    @Override
    public String toString() {
        return "Coordinates [x=" + x + ", y=" + y + ", x2=" + x2 + ", y2=" + y2 + "]";
    }
}
