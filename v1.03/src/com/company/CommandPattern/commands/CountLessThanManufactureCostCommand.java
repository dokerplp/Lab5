package com.company.CommandPattern.commands;

import com.company.CommandPattern.Command;
import com.company.Data.Product;
import com.company.utility.DataOperator;
import com.company.exceptions.IncorrectDataException;

import java.util.List;

/**
 * Command counts amount of elements which manufacture cost is less than some number
 */
public class CountLessThanManufactureCostCommand implements Command { //done //maybe //TESTED!

    List<Product> products;
    DataOperator data;
    float manufactureCost;

    /**
     * AddIfMaxCommand Constructor
     * @param products - collection
     * @param data - Class to run Data
     */
    public CountLessThanManufactureCostCommand(List<Product> products, DataOperator data) {
        this.products = products;
        this.data = data;
    }

    /**
     * Realization of this command
     */
    private void CountLessThanManufactureCostRealization(){
        int counter = 0;
        for (Product product : products){
            if (product.getManufactureCost() == manufactureCost) counter++;
        }
        System.out.println(counter);
    }

    /**
     * Execution of this command
     */
    @Override
    public void execute(String Argument) {
        if (Argument == null) System.out.println("Не хватает аргумета (Дробное число)");
        else {
            try {
                manufactureCost = data.StringToFloat(Argument);
                CountLessThanManufactureCostRealization();
            } catch (IncorrectDataException e){
                System.out.println("Введите дробное число");
            }
        }
    }
}
