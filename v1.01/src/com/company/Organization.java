package com.company;

public class Organization{

    static private int LastID = 48759;


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
            Checking(name, employeesCount, type, officialAddress);
            this.name = name;
        } catch (CreationException e){
            //Все очень плоха
        }
    }

    private long employeesCount; //Значение поля должно быть больше 0
    public long getEmployeesCount(){
        return employeesCount;
    }
    public void setEmployeesCount(long employeesCount) {
        try {
            Checking(name, employeesCount, type, officialAddress);
            this.employeesCount = employeesCount;
        } catch (CreationException e){
            //Все очень плоха
        }
    }

    private OrganizationType type; //Поле не может быть null
    public OrganizationType getType(){
        return type;
    }
    public void setType(OrganizationType type) {
        try {
            Checking(name, employeesCount, type, officialAddress);
            this.type = type;
        } catch (CreationException e){
            //Все очень плоха
        }
    }

    private Address officialAddress; //Поле может быть null
    public Address getOfficialAddress(){
        return officialAddress;
    }


    public Organization(String name, long employeesCount, OrganizationType type, Address officialAddress){
        try {
            Checking(name,employeesCount,type,officialAddress);
            this.id = NewID();
            this.name = name;
            this.employeesCount = employeesCount;
            this.type = type;
            this.officialAddress = officialAddress;
        } catch (CreationException e){
            // Все очень плоха
        }
    }

    private void Checking(String name, long employeesCount, OrganizationType type, Address officialAddress) throws CreationException{
        boolean trigger = true;

        if (name.equals("") || name == null){
            trigger = false;
            System.out.println("Недопустимое значение имени");
        }
        if(employeesCount == 0){
            trigger = false;
            System.out.println("Недопустимое число рабочих");
        }
        if(type == null){
            trigger = false;
            System.out.println("Недопустимый тип организации");
        }
        if(officialAddress == null){
            trigger = false;
            System.out.println("Недопустимый адресс");
        }

        if (!trigger) throw new CreationException();
    }








}
