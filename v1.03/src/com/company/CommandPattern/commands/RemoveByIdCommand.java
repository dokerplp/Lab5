package com.company.CommandPattern.commands;

import com.company.CommandPattern.Command;
import com.company.Data.Product;
import com.company.utility.ForData.DataChecker;
import com.company.utility.ForData.DataOperator;
import com.company.exceptions.IncorrectDataException;

import java.util.Iterator;
import java.util.List;

/**
 * Command deletes element by id, or types that there are no element with such id
 */
public class RemoveByIdCommand implements Command { //done //maybe //TESTED!

    int id;
    List<Product> products;
    DataOperator data;

    /**
     * AddCommand Constructor
     * @param products - collection
     * @param data - Class to run Data
     */
    public RemoveByIdCommand(List<Product> products, DataOperator data) {
        this.products = products;
        this.data = data;
    }

    /**
     * Realization of this command
     */
    private void RemoveByIdRealization(){
        boolean trigger = false;
        Iterator<Product> iterator = products.iterator();
        while(iterator.hasNext()){
            Product NextProduct = iterator.next();
            if (NextProduct.getId() == id) {
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
        if (Argument == null) System.out.println("Не хватает аргумета (Дробное число)");
        else {
            try {
                id = data.StringToInt(Argument);
                if (DataChecker.AboveZeroCheck(id)) RemoveByIdRealization();
                else System.out.println("Некорректный id");
            } catch (IncorrectDataException e){
                System.out.println("Введите целое число");
            }
        }
    }
}
