package com.company.CommandPattern.commands;

import com.company.CommandPattern.Command;
import com.company.Data.Product;
import com.company.exceptions.*;
import com.company.utility.JSON.JSON_Builder;

import java.io.PrintWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Command saves collection in json file
 */
public class SaveCommand implements Command {

    private final List<Product> products;

    /**
     * AddCommand Constructor
     * @param products - collection
     */
    public SaveCommand(List<Product> products) {
        this.products = products;
    }

    /**
     * Realization of this command
     */
    private void SaveRealization() throws FileNotFoundException {
        File file = new File(CheckFileOrCreateFile());
        JSON_Builder builder = new JSON_Builder();

        PrintWriter pw = new PrintWriter(file);
        String line = builder.packCollection(products);
        pw.print(line);
        pw.close();
    }

    /**
     *This method checks if the environment variable is working.
     *If it is so method saves collection in that file, else it create new file
     * @return path to saving file
     */
    private String CheckFileOrCreateFile(){
        try {
            String path = System.getenv("LAB");
            if (path == null) throw new EnvVarDoesNotExistException();
            File DJEYSON = new File(path);
            if (!DJEYSON.exists()) throw new FileDoesNotExistException();
            if (DJEYSON.isDirectory()) throw new IsDirException();
            String[] kostyl = path.split("\\.");
            if (!kostyl[kostyl.length - 1].equals("json")) throw new NotJsonException();
            if (!DJEYSON.canWrite()) throw new CantReadException();
            return path;
        } catch (Exception e) {
            System.out.println("Возникли проблемы с исходным файлом\nНовый файл создан и сохранен в домашней дириктории");
            return "/Users/twenty_one_thirteen/Desktop/Lab5.json";
        }

    }

    /**
     * Execution of this command
     */
    @Override
    public void execute(String Argument) {
        if (Argument != null) System.out.println("Эта комманда не требует никаих аргуметов так-то :)");
        try{
            SaveRealization();
            Product.setLastSave();
            System.out.println("Сохранено!");
        } catch (FileNotFoundException e) {
            System.out.println("Сохранение не состоялось");
        }
    }
}
