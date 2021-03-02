package com.company;

public enum OrganizationType {
    PUBLIC ("Общественная"),
    GOVERNMENT ("Правительственная"),
    PRIVATE_LIMITED_COMPANY ("ЗАО");

    private final String type;

    OrganizationType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
