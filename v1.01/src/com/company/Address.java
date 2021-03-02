package com.company;

public class Address {
    private String street; //Поле не может быть null
    public String getStreet(){
        return street;
    }

    private String zipCode; //Длина строки не должна быть больше 12, Поле может быть null
    public String getZipCode(){
        return zipCode;
    }

    public Address(String street, String zipCode){

        try {
            if (street != null && zipCode.length() <= 12) {
                this.street = street;
                this.zipCode = zipCode;
            } else throw new CreationException();
        } catch (CreationException e){
            //Все очень плоха
        }
    }

}
