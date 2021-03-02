package com.company.CommandPattern.commands;

import com.company.CommandPattern.Command;
import com.company.exceptions.InfinityRecursionException;
import com.company.utility.ForCommands.RequestsQueue;
import com.company.exceptions.CantReadException;
import com.company.exceptions.FileDoesNotExistException;
import com.company.exceptions.IsDirException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Command execute user's script
 */
public class ExecuteScriptCommand implements Command {

    /**
     * Realization of this command
     * @param path - script path
     */
    private void ExecuteScriptRealization(String path){
        File script = new File(path);
        try {
            if (!script.exists()) throw new FileDoesNotExistException();
            if (script.isDirectory()) throw new IsDirException();
            if (!script.canRead()) throw new CantReadException();

            RequestsQueue.status = false;
            Scanner requests = new Scanner(script);
            List<String> list = new ArrayList<>();
            while (requests.hasNext()) list.add(requests.next());
            RequestsQueue.pushAll(list);

            InfinityRecursionException.newRec();

        } catch (FileDoesNotExistException e){
            System.out.println("Скрипт не сработал - файла не существует");
        } catch (IsDirException e){
            System.out.println("Скрипт не сработал - путь ведет к дириктории, а не файлу");
        } catch (CantReadException e){
            System.out.println("Скрипт не сработал - нет прав на чтение файла");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Execution of this command
     */
    @Override
    public void execute(String Argument) {
        if (Argument == null) System.out.println("Не хватает аргумета (Адрес скрипта)");
        else ExecuteScriptRealization(Argument);
    }
}
