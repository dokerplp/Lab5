package com.company.commandPattern.commands;

import com.company.commandPattern.Command;
import com.company.data.Product;
import com.company.utility.forData.DataBase;
import com.company.utility.forData.DataOperator;
import com.company.exceptions.IncorrectDataException;

import java.util.List;

/**
 * Command counts amount of elements which manufacture cost is less than some number
 */
public class CountLessThanManufactureCostCommand implements Command { //Good

    private final List<Product> products; //Collection
    private final DataOperator data; //Utility for operating data
    private float manufactureCost; //Argument

    /**
     * AddIfMaxCommand Constructor
     * @param base - collection
     * @param data - Class to run Data
     */
    public CountLessThanManufactureCostCommand(DataBase base, DataOperator data) {
        this.products = base.getBase();
        this.data = data;
    }

    /**
     * Realization of this command
     */
    private void CountLessThanManufactureCostRealization(){
        int counter = 0;
        for (Product product : products){
            if (product.getManufactureCost() < manufactureCost) counter++;
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
