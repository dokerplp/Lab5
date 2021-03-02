package com.company;

public class Coordinates {
    private float x;
    public float getX(){
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }

    private Integer y; //Максимальное значение поля: 125, Поле не может быть null
    public Integer getY(){
        return y;
    }
    public void setY(Integer y) {
        if (y <= 125) this.y = y;
        else System.out.println("Ошибка данных");
    }

    public Coordinates(float x, Integer y){

        try {
            if (y <= 125) {
                this.x = x;
                this.y = y;
            } else throw new CreationException();
        } catch (CreationException e){
            System.out.println("Ошибка данных (некорректные координаты)");
        }
    }




}
