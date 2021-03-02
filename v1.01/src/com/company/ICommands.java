package com.company;

import java.lang.invoke.SwitchPoint;
import java.time.ZonedDateTime;
import java.util.*;
import java.io.Console;
import java.util.function.Predicate;

public interface ICommands{

    Scanner Console = new Scanner(System.in);

    static void help(){
        System.out.println(
                "Салам, мои комманды:\n" +
                "help - выводит справку по доступным командам\n" +
                "info - выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show - выводит в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add - добавит новый элемент в коллекцию\n" + //add(element)
                "update - обновит значение элемента коллекции, id которого равен заданному\n" + //(update(id, element))
                "remove_by_id - удалит элемент из коллекции по его id\n" + //remove_by_id(id)
                "clear - очистит коллекцию\n" +
                "save - сохранит коллекцию в файл\n" +
                "execute_script - считает и исполнит скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" + //execute_script(file_name)
                "exit - завершит программу (без сохранения в файл)\n" +
                "add_if_max - добавит новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\n" + //dd_if_max(element)
                "shuffle - перемешает элементы коллекции в случайном порядке\n" +
                "remove_greater - удалит из коллекции все элементы, превышающие заданный\n" + //remove_greater(element)
                "average_of_price - выведет среднее значение поля price для всех элементов коллекции\n" +
                "count_by_manufacture_cost - выведет количество элементов, значение поля manufactureCost которых равно заданному\n" + //count_by_manufacture_cost(manufactureCost)
                "count_less_than_manufacture_cost - выведет количество элементов, значение поля manufactureCost которых меньше заданного\n" //count_less_than_manufacture_cost(manufactureCost)
        );
    } //!

    static void info(List<Product> products){
        System.out.println(
                "Салам, сведения о коллекции:\n" +
                "Тип: простой список обьектов\n" +
                "Количество элементов: " + products.size() + "\n" +
                "Последнее сохранение коллекции: " + Product.getLastSave() + "\n" +
                "id последнего элемента: " + Product.getLastID() + "\n" +
                "Последняя инициализация: " + Product.getLastInit()
        );
    } //done //!
    static void show(List<Product> products){
       int i = 0;
       for (Product product : products){
           i++;
           System.out.println(
                   "Продукт номер " + i + "\n" +
                   "ID продукта: " + product.getId() + "\n" +
                   "Название продукта: " + product.getName() + "\n" +
                   "Координаты: " + "\n" +
                   "     x: " + product.getCoordinates().getX() + "\n" +
                   "     y: " + product.getCoordinates().getY() + "\n" +
                   "Дата создания: " + product.getCreationDate() + "\n" +
                   "Цена: " + product.getPrice() + "\n" +
                   "Номер части: " + product.getPartNumber() + "\n" +
                   "Стоимость изготовления: " + product.getManufactureCost() + "\n" +
                   "Единица измерения: " + product.getUnitOfMeasure().getType() + "\n" +
                   "Изготовитель: " + "\n" +
                   "     ID компании: " + product.getManufacturer().getId() + "\n" +
                   "     Название компании: " + product.getManufacturer().getName() + "\n" +
                   "     Количество работников: " + product.getManufacturer().getEmployeesCount()+ "\n" +
                   "     Тип компании: " + product.getManufacturer().getType().getType() + "\n" +
                   "     Адрес: " + "\n" +
                   "          Улица: " + product.getManufacturer().getOfficialAddress().getStreet() + "\n" +
                   "          Почтовый индекс: " + product.getManufacturer().getOfficialAddress().getZipCode() + "\n"
           );
       }
    } //done
    static void add(List<Product> products){

        try {
            System.out.println("Заполните все поля, чтобы создать обьект");
            System.out.print("Название продукта: ");
            String name = Console.next();
            System.out.println("Координаты: ");
            System.out.print("     X: ");
            float X = Console.nextFloat();
            System.out.print("     Y: ");
            Integer Y = Console.nextInt();
            System.out.print("Цена: ");
            long price = Console.nextLong();
            System.out.print("Номер части: ");
            String partNumber = Console.next();
            System.out.print("Цена производства: ");
            float manufactureCost = Console.nextFloat();
            System.out.print("Выберите единицы измерения (1 - Метры, 2 - Сантиметры, 3 - Литры): ");
            UnitOfMeasure unitOfMeasure;
            String num = Console.next();
            switch (num) {
                case "1":
                    unitOfMeasure = UnitOfMeasure.CENTIMETERS;
                    break;
                case "2":
                    unitOfMeasure = UnitOfMeasure.METERS;
                    break;
                case "3":
                    unitOfMeasure = UnitOfMeasure.LITERS;
                    break;
                default:
                    unitOfMeasure = null;
                    break;
            }
            System.out.println("Изготовитель: ");
            System.out.print("     Название компании: ");
            String OrgName = Console.next();
            System.out.print("     Количество работников: ");
            long emplCount = Console.nextLong();
            System.out.print("     Тип компании: (1 - Общественная, 2 - Правительственная, 3 - ЗАО): ");
            OrganizationType type;
            String num2 = Console.next();
            switch (num2) {
                case "1":
                    type = OrganizationType.PUBLIC;
                    break;
                case "2":
                    type = OrganizationType.GOVERNMENT;
                    break;
                case "3":
                    type = OrganizationType.PRIVATE_LIMITED_COMPANY;
                    break;
                default:
                    type = null;
                    break;
            }
            System.out.println("     Адрес: ");
            System.out.print("          Улица: ");
            String street = Console.next();
            System.out.print("          Почтовый код: ");
            String zipCode = Console.next();

            Address address = new Address(street, zipCode);
            Organization organization = new Organization(OrgName, emplCount, type, address);
            Coordinates coordinates = new Coordinates(X, Y);
            Product product = new Product(name, coordinates, price, partNumber, manufactureCost, unitOfMeasure, organization);

            if (product.isObjCreated()) {
                products.add(product);
                Product.setLastInit(ZonedDateTime.now().toString());
            }
        } catch (Exception e){
            System.out.println("Недопустимый тип данных");
        }
    } //done
    static void update(List<Product> products, int id){

    }
//    static void update(List<Product> products, int id){
//        boolean trigger = false;
//        for (Product product : products){
//            if (product.getId() == id){
//                trigger = true;
//
//                System.out.println("Введите цифры, соответсвующие полям, которые вы хотите поменять\n(1 - Название, 2 - Координаты, 3 - Цена, 4 - Номер части, 5 - Стоимость изготовления, 6 - Единица измерения, 7 - Сведения об изготовителе)");
//                String num = Console.next();
//                if (num.contains("1")) {
//                    System.out.print("Введите новое название: ");
//                    String name = Console.next();
//                    product.setName(name);
//                }
//                if (num.contains("2")) {
//                    try{
//                        System.out.println("Введите новые координаты: ");
//                        System.out.print("     X: ");
//                        float X = Console.nextFloat();
//                        System.out.print("     Y: ");
//                        Integer Y = Console.nextInt();
//                        product.getCoordinates().setX(X);
//                        product.getCoordinates().setY(Y);
//                    } catch (Exception e){
//                        System.out.println("Ошибка данных");
//                    }
//                }
//                if (num.contains("3")) {
//                    try {
//                        System.out.print("Введите новую цену: ");
//                        long price = Console.nextLong();
//                        product.setPrice(price);
//                    } catch (Exception e){
//                        System.out.println("Ошибка данных");
//                    }
//                }
//                if (num.contains("4")) {
//                    System.out.print("Введите новый номер части: ");
//                    String partNumber = Console.next();
//                    product.setPartNumber(partNumber);
//                }
//                if (num.contains("5")) {
//                    try {
//                        System.out.print("Введите новую цену производства: ");
//                        float manufactureCost = Console.nextFloat();
//                        product.setManufactureCost(manufactureCost);
//                    } catch (Exception e){
//                        System.out.println("Ошибка данных");
//                    }
//                }
//                if (num.contains("6")) {
//                    System.out.print("Выберите новые единицы измерения (1 - Метры, 2 - Сантиметры, 3 - Литры): ");
//                    UnitOfMeasure unitOfMeasure;
//                    String num2 = Console.next();
//                    switch (num2) {
//                        case "1":
//                            unitOfMeasure = UnitOfMeasure.CENTIMETERS;
//                            break;
//                        case "2":
//                            unitOfMeasure = UnitOfMeasure.METERS;
//                            break;
//                        case "3":
//                            unitOfMeasure = UnitOfMeasure.LITERS;
//                            break;
//                        default:
//                            unitOfMeasure = null;
//                            break;
//                    }
//                }
//                if (num.contains("7")) {
//                    System.out.println("Введите цифры, соответсвующие полям, которые вы хотите поменять\n(1 - Название компании, 2 - Количество работников, 3 - Тип компании, 4 - Адрес");
//                    String num3 = Console.next();
//                    if (num3.contains("1")){
//                        System.out.print("Введите новый номер части: ");
//                        String name = Console.next();
//                        product.getManufacturer().;
//                    }
//                    if (num3.contains("2")){
//
//                    }
//                    if (num3.contains("3")){
//
//                    }
//                    if (num3.contains("4")){
//
//                    }
//
//                }
//            }
//        }
//        if (!trigger) System.out.println("Такого элемента не существует");
//
//
//    }
    static void remove_by_id(List<Product> products, int id){
        boolean trigger = false;

        ListIterator<Product> listIterator = products.listIterator();
        while(listIterator.hasNext()){
            Product product = listIterator.next();
            if (product.getId() == id) {
                listIterator.remove();
                trigger = true;
            }
        }
        if (!trigger) System.out.println("Такого элемента не существует");
    } //done
    static void clear(List<Product> products){
        products.clear();
    } //done
    static void save(){
        Product.setLastSave(ZonedDateTime.now().toString());

        //Сохранить в файл
    }
    static void execute_script(){

    }
    static boolean exit(){
        return false;
    } //done
    static void add_if_max(){

    }
    static void shuffle(){

    }
    static void remove_greater(){

    }
    static void average_of_price(List<Product> products){
        long Average = 0;
        int Counter = 0;
        for(Product product : products){
               Average += product.getPrice();
               Counter += 1;
        }
        if (Counter != 0) {
            float i = Average/Counter;
            System.out.println(i);
        }
        else System.out.println("Еще не существет ни одного продукта!");
    } //done
    static void count_by_manufacture_cost(List<Product> products, float Cost){
        int i = 0;
        for (Product product : products) {
            if(product.getManufactureCost() == Cost) i++;
        }
        System.out.println(i);
    } //done
    static void count_less_than_manufacture_cost(List<Product> products, float Cost){
        int i = 0;
        for (Product product : products) {
            if(product.getManufactureCost() < Cost) i++;
        }
        System.out.println(i);
    } //done
}
