package com.company.Data;

import com.company.utility.DataChecker;

/**
 * This class has information about product coordinates
 */
public class Coordinates {

    ////////////////////////////////////////////////////////////////////////

    /**
     * x coordinate, its getter and setter
     */
    private float x = 0f;
    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }

    /**
     * y coordinate, its getter and setter
     */
    private Integer y = null; //Максимальное значение поля: 125, Поле не может быть null
    public Integer getY() {
        return y;
    }
    public void setY(Integer y) {
        this.y = y;
    }

    ////////////////////////////////////////////////////////////////////////

    /**
     * This methods checks if the fields has right values
     * @return true if all fields are correct and false if not
     */
    public boolean correct(){
        boolean trigger = true;

        if (! (DataChecker.NotNullCheck(y) && y <= 125) ) return false;

        return trigger;
    }

}
