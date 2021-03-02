package com.company.CommandPattern.commands;

import com.company.CommandPattern.Command;
import com.company.Data.Product;
import com.company.utility.ForCommands.CreateNewProduct;
import com.company.utility.ForData.DataOperator;
import com.company.exceptions.IncorrectDataException;

import java.util.List;

/**
 * Collection updates fields of element by its id
 */
public class UpdateCommand implements Command { //done //maybe //TESTED!

    List<Product> products;
    DataOperator data;
    Product update = null;
    int id;

    /**
     * AddCommand Constructor
     * @param products - collection
     * @param data - Class to run Data
     */
    public UpdateCommand(List<Product> products, DataOperator data) {
        this.products = products;
        this.data = data;
    }

    /**
     * Realization of this command
     */
    private void UpdateRealization(){
        CreateNewProduct createNewProduct = new CreateNewProduct(update);
        System.out.println("Updating...");
        String now = "Текущее значение поля ";
        System.out.println(now + "\"Название продукта\": " + update.getName());
        if (Up()) createNewProduct.setName();
        System.out.println(now + "\"Координата X\": " + update.getCoordinates().getX());
        if (Up()) createNewProduct.setX();
        System.out.println(now + "\"Координата Y\": " + update.getCoordinates().getY());
        if (Up()) createNewProduct.setY();
        System.out.println(now + "\"Цена\": " + update.getPrice());
        if (Up()) createNewProduct.setPrice();
        System.out.println(now + "\"Артикул\": " + update.getPartNumber());
        if (Up()) createNewProduct.setPartNumber();
        System.out.println(now + "\"Цена производства\": " + update.getManufactureCost());
        if (Up()) createNewProduct.setMCost();
        System.out.println(now + "\"Единица измерения\": " + update.getUnitOfMeasure().getType());
        if (Up()) createNewProduct.setMeasure();
        System.out.println(now + "\"Название организации\": " + update.getManufacturer().getName());
        if (Up()) createNewProduct.setOrgName();
        System.out.println(now + "\"Количество работников\": " + update.getManufacturer().getEmployeesCount());
        if (Up()) createNewProduct.setEcount();
        System.out.println(now + "\"Тип компании\": " + update.getManufacturer().getType());
        if (Up()) createNewProduct.setType();
        System.out.println(now + "\"Улица\": " + update.getManufacturer().getOfficialAddress().getStreet());
        if (Up()) createNewProduct.setName();
        System.out.println(now + "\"Почтовый код\": " + update.getManufacturer().getOfficialAddress().getZipCode());
        if (Up()) createNewProduct.setZip();

        System.out.println("\nИзменения сохранены!");
    }

    /**
     * This method checks, does the person want to update field
     * @return the person decision
     */
    private boolean Up(){
        System.out.println("Желаете обновить поле?\nПустое поле - нет, любой символ - да");
        String ans = data.getSTRING();
        return !(ans == null);
    }

    /**
     * Execution of this command
     */
    @Override
    public void execute(String Argument) {
        if (Argument == null) System.out.println("Не хватает аргумета (Целое число)");
        else {
            try {
                id = data.StringToInt(Argument);
                for (Product product: products){
                    if(product.getId() == id){
                        update = product;
                    }
                }
                if (update != null) UpdateRealization();
                else System.out.println("Такого id не существует!");
            }catch (IncorrectDataException e){
                System.out.println("Введите целое число");
            }
        }
    }
}
