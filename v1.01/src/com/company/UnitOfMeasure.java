package com.company;

public enum UnitOfMeasure {
    METERS("Метры"),
    CENTIMETERS("Сантиметры"),
    LITERS("Литры");

    private final String type;

    UnitOfMeasure(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
