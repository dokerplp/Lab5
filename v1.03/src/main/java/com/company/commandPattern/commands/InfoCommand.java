package com.company.commandPattern.commands;

import com.company.commandPattern.Command;
import com.company.data.Product;

import java.util.List;

/**
 * Command types information about collection
 */
public class InfoCommand implements Command { //done //maybe

    private final List<Product> products;

    /**
     * AddIfMaxCommand Constructor
     * @param products - collection
     */
    public InfoCommand(List<Product> products) {
        this.products = products;
    }

    /**
     * Realization of this command
     */
    private void InfoRealization(){
        System.out.println(
                "Салам, сведения о коллекции:\n" +
                        "Тип: простой список обьектов\n" +
                        "Количество элементов: " + products.size() + "\n" +
                        "Последнее сохранение коллекции: " + Product.getLastSave() + "\n" +
                        "id последнего элемента: " + Product.getLastID() + "\n" +
                        "Последняя инициализация: " + Product.getLastInit()
        );
    }

    /**
     * Execution of this command
     */
    @Override
    public void execute(String Argument) {
        if (Argument != null) System.out.println("Эта комманда не требует никаих аргуметов так-то :)");
        InfoRealization();
    }
}
