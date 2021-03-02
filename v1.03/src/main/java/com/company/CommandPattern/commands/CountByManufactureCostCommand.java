package com.company.CommandPattern.commands;

import com.company.CommandPattern.Command;
import com.company.Data.Product;
import com.company.utility.ForData.DataOperator;
import com.company.exceptions.IncorrectDataException;

import java.util.List;

/**
 * Command counts amount of elements which manufacture cost is equals to some number
 */
public class CountByManufactureCostCommand implements Command {  //done //maybe //TESTED! //OK

    private final List<Product> products;
    private final DataOperator data;
    private float manufactureCost;

    /**
     * AddIfMaxCommand Constructor
     * @param products - collection
     * @param data - Class to run Data
     */
    public CountByManufactureCostCommand(List<Product> products, DataOperator data) {
        this.products = products;
        this.data = data;
    }

    /**
     * Realization of this command
     */
    private void CountByManufactureCostRealization(){
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
                CountByManufactureCostRealization();
            } catch (IncorrectDataException e){
                System.out.println("Введите дробное число");
            }
        }
    }
}
