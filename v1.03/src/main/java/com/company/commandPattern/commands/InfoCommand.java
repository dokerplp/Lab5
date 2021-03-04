package com.company.commandPattern.commands;

import com.company.commandPattern.Command;
import com.company.data.Product;
import com.company.utility.forData.DataBase;

import java.util.List;

/**
 * Command types information about collection
 */
public class InfoCommand implements Command { //done //maybe

    private final DataBase base;
    private final List<Product> products;

    /**
     * AddIfMaxCommand Constructor
     * @param base - collection
     */
    public InfoCommand(DataBase base) {
        this.base = base;
        products = base.getBase();
    }

    /**
     * Realization of this command
     */
    private void InfoRealization(){
        System.out.println(
                "Салам, сведения о коллекции:\n" +
                        "Тип: простой список обьектов\n" +
                        "Количество элементов: " + products.size() + "\n" +
                        "Последнее сохранение коллекции: " + base.getLastSave() + "\n" +
                        "id последнего элемента: " + base.getOrgLastId() + "\n" +
                        "Последняя инициализация: " + base.getLastInit()
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
