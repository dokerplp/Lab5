package com.company.CommandPattern.commands;

import com.company.CommandPattern.Command;
import com.company.Data.Product;
import com.company.utility.ForData.DataOperator;
import com.company.exceptions.IncorrectDataException;

import java.util.Iterator;
import java.util.List;

/**
 * Command deletes all elements which price is more than some number
 */
public class RemoveGreaterCommand implements Command { //done //maybe //TESTED!

    List<Product> products;
    DataOperator data;
    long price;

    /**
     * AddCommand Constructor
     * @param products - collection
     * @param data - Class to run Data
     */
    public RemoveGreaterCommand(List<Product> products, DataOperator data) {
        this.products = products;
        this.data = data;
    }

    /**
     * Realization of this command
     */
    private void RemoveGreaterRealization(){
        boolean trigger = false;
        Iterator<Product> iterator = products.iterator();
        while(iterator.hasNext()){
            Product NextProduct = iterator.next();
            if (NextProduct.getPrice() > price) {
                iterator.remove();
                trigger = true;
            }
        }
        if(!trigger)System.out.println("Такого элемента не существует");
    }

    /**
     * Execution of this command
     */
    @Override
    public void execute(String Argument) {
        if (Argument == null) System.out.println("Не хватает аргумета (Целое число)");
        else {
            try {
                price = data.StringToInt(Argument);
                RemoveGreaterRealization();
            } catch (IncorrectDataException e){
                System.out.println("Введите целое число");
            }
        }
    }
}
