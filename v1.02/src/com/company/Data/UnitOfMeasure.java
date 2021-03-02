package com.company.Data;

/**
 * Enum of possible units of measure
 */
public enum UnitOfMeasure {
    METERS("Метры"),
    CENTIMETERS("Сантиметры"),
    LITERS("Литры");

    private final String type;
    /**
     * @return how it calls in Russian
     */
    public String getType(){
        return type;
    }

    /**
     * Constructor
     * @param type - name
     */
    UnitOfMeasure(String type){
        this.type = type;
    }

    /**
     * Method matches russian name to the enum object
     * @param measure - String of russian name
     * @return Organization type or null
     */
    public static UnitOfMeasure reverse(String measure){
        return switch (measure) {
            case "Сантиметры" -> UnitOfMeasure.CENTIMETERS;
            case "Метры" -> UnitOfMeasure.METERS;
            case "Литры" -> UnitOfMeasure.LITERS;
            default -> null;
        };
    }

}
