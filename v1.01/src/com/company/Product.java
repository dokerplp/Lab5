package com.company;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class Product {

    private boolean ObjCreated = false;
    public boolean isObjCreated() {
        return ObjCreated;
    }

    static private int LastID = 48759;
    public static int getLastID(){
        return LastID;
    }

    private static String LastSave = "коллекция еще не сохранялась!";
    public static String getLastSave(){
        return LastSave;
    }
    public static void setLastSave(String time){
        LastSave = time;
    }

    private static String LastInit = "инициализации еще не было";
    public static String getLastInit(){
        return LastInit;
    }
    public static void setLastInit(String time){
        LastInit = time;
    }

    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private int NewID(){
        LastID += 1;
        return LastID;
    }
    public int getId(){
        return id;
    }



    private String name; //Поле не может быть null, Строка не может быть пустой
    public String getName(){
        return name;
    }
    public void setName(String name) {
        try {
            Checking(name,coordinates,price,unitOfMeasure,manufacturer);
            this.name = name;
        } catch (CreationException e){
            //Все очень плоха
        }
    }

    private Coordinates coordinates; //Поле не может быть null
    public Coordinates getCoordinates(){
        return coordinates;
    }
    public void setCoordinates(Coordinates coordinates) {
        try {
            Checking(name,coordinates,price,unitOfMeasure,manufacturer);
            this.coordinates = coordinates;
        } catch (CreationException e){
            //Все очень плоха
        }
    }

    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    public ZonedDateTime getCreationDate(){
        return creationDate;
    }


    private long price; //Значение поля должно быть больше 0
    public long getPrice(){
        return price;
    }
    public void setPrice(long price) {
        try {
            Checking(name,coordinates,price,unitOfMeasure,manufacturer);
            this.price = price;
        } catch (CreationException e){
            //Все очень плоха
        }
    }

    private String partNumber; //Поле может быть null
    public String getPartNumber(){
        return partNumber;
    }
    public void setPartNumber(String partNumber) {
        if (partNumber.equals("null")) this.partNumber = null;
        else this.partNumber = partNumber;
    }

    private float manufactureCost;
    public float getManufactureCost(){
        return manufactureCost;
    }
    public void setManufactureCost(float manufactureCost) {
        this.manufactureCost = manufactureCost;
    }

    private UnitOfMeasure unitOfMeasure; //Поле не может быть null
    public UnitOfMeasure getUnitOfMeasure(){
        return unitOfMeasure;
    }
    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        try {
            Checking(name,coordinates,price,unitOfMeasure,manufacturer);
            this.unitOfMeasure = unitOfMeasure;
        } catch (CreationException e){
            //Все очень плоха
        }
    }

    private Organization manufacturer; //Поле не может быть null
    public Organization getManufacturer(){
        return manufacturer;
    }
    public void setManufacturer(Organization manufacturer) {
        try {
            Checking(name,coordinates,price,unitOfMeasure,manufacturer);
            this.manufacturer = manufacturer;
        } catch (CreationException e){
            //Все очень плоха
        }
    }


    public Product(String name, Coordinates coordinates, long price, String partNumber, float manufactureCost, UnitOfMeasure unitOfMeasure, Organization manufacturer){

        try {
            Checking(name,coordinates,price,unitOfMeasure,manufacturer);
            this.id = NewID();
            this.name = name;
            this.coordinates = coordinates;
            this.creationDate = ZonedDateTime.now();
            this.price = price;
            this.partNumber = partNumber;
            this.manufactureCost = manufactureCost;
            this.unitOfMeasure = unitOfMeasure;
            this.manufacturer = manufacturer;

            this.ObjCreated = true;
        } catch (CreationException e){
            //Все очень плохо
        }


    }

    private void Checking(String name, Coordinates coordinates, long price, UnitOfMeasure unitOfMeasure, Organization manufacturer) throws CreationException{
        boolean trigger = true;

        if (name.equals("") || name == null){
            trigger = false;
            System.out.println("Недопустимое значение имени");
        }
        if(coordinates == null){
            trigger = false;
            System.out.println("Недопустимые координаты");
        }
        if(price == 0){
            trigger = false;
            System.out.println("Цена должна быть больше 0");
        }
        if(unitOfMeasure == null){
            trigger = false;
            System.out.println("Недопустимый тип измерений");
        }
        if(manufacturer == null){
            trigger = false;
            System.out.println("Недопустимый тип изготовителя");
        }

        if (!trigger) throw new CreationException();
    }

}
