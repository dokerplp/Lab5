package com.company.Data;

/**
 * Enum of possible organization types
 */
public enum OrganizationType {

    PUBLIC ("Общественная"),
    GOVERNMENT ("Правительственная"),
    PRIVATE_LIMITED_COMPANY ("ЗАО");


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
    OrganizationType(String type){
        this.type = type;
    }

    /**
     * Method matches russian name to the enum object
     * @param measure - String of russian name
     * @return Organization type or null
     */
    public static OrganizationType reverse(String measure){
        return switch (measure) {
            case "Общественная" -> OrganizationType.PUBLIC;
            case "Правительственная" -> OrganizationType.GOVERNMENT;
            case "ЗАО" -> OrganizationType.PRIVATE_LIMITED_COMPANY;
            default -> null;
        };
    }
}
