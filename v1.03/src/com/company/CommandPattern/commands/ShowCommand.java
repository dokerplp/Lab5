package com.company.CommandPattern.commands;

import com.company.CommandPattern.Command;
import com.company.Data.Product;

import java.util.List;

/**
 * Collection types all fields of each element
 */
public class ShowCommand implements Command { //done //maybe //TESTED!

    List<Product> products;

    /**
     * AddCommand Constructor
     * @param products - collection
     */
    public ShowCommand(List<Product> products) {
        this.products = products;
    }

    /**
     * Realization of this command
     */
    private void ShowRealization(){
        int i = 0;
        for (Product product : products){
            i++;
            System.out.println(
                    "Продукт номер " + i + "\n" +
                            "ID продукта: " + product.getId() + "\n" +
                            "Название продукта: " + product.getName() + "\n" +
                            "Координаты: " + "\n" +
                            "     X: " + product.getCoordinates().getX() + "\n" +
                            "     Y: " + product.getCoordinates().getY() + "\n" +
                            "Дата создания: " + product.getCreationDate() + "\n" +
                            "Цена: " + product.getPrice() + "\n" +
                            "Артикул : " + product.getPartNumber() + "\n" +
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
    }

    /**
     * Execution of this command
     */
    @Override
    public void execute(String Argument) {
        if (Argument != null) System.out.println("Эта комманда не требует никаих аргуметов так-то :)");
        ShowRealization();
    }

}
