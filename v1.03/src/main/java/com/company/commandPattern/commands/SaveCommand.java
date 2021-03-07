package com.company.commandPattern.commands;

import com.company.commandPattern.Command;
import com.company.data.Product;
import com.company.utility.forCommands.FileOperator;
import com.company.utility.forData.DataBase;
import com.company.utility.json.JSON_Builder;

import java.io.PrintWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Command saves collection in json file
 */
public class SaveCommand implements Command {

    private DataBase base;
    private final List<Product> products;

    /**
     * AddCommand Constructor
     * @param base - collection
     */
    public SaveCommand(DataBase base) {
        this.base = base;
        products = base.getBase();
    }

    /**
     * Realization of this command
     */
    private void SaveRealization() throws FileNotFoundException {
        String path = CheckFileOrCreateFile();
        if (path != null){
            File file = new File(path);
            JSON_Builder builder = new JSON_Builder();

            PrintWriter pw = new PrintWriter(file);
            String line = builder.packCollection(products);
            pw.print(line);
            pw.close();
        }
    }

    /**
     *This method checks if the environment variable is working.
     *If it is so method saves collection in that file, else it create new file
     * @return path to saving file
     */
    private String CheckFileOrCreateFile(){
        try {
            String path = System.getenv("LAB");
            FileOperator.EnvExist(path);
            File DJEYSON = new File(path);
            FileOperator.FileExist(DJEYSON);
            FileOperator.IsFile(DJEYSON);
            FileOperator.IsJSON(path);
            FileOperator.Writable(DJEYSON);
            return path;
        } catch (Exception e) {
            System.out.println("Возникли проблемы с исходным файлом\nНовый файл создан и сохранен в домашней дириктории");;
        }
        return null;
    }

    /**
     * Execution of this command
     */
    @Override
    public void execute(String Argument) {
        if (Argument != null) System.out.println("Эта комманда не требует никаих аргуметов так-то :)");
        try{
            SaveRealization();
            base.getFields().setLastSave();
            System.out.println("Сохранено!");
        } catch (FileNotFoundException e) {
            System.out.println("Сохранение не состоялось");
        }
    }
}
