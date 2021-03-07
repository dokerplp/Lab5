package com.company.commandPattern.commands;

import com.company.commandPattern.Command;
import com.company.exceptions.InfinityRecursionException;
import com.company.exceptions.IsFileException;
import com.company.utility.forCommands.FileOperator;
import com.company.utility.forCommands.RequestsQueue;
import com.company.exceptions.CantReadException;
import com.company.exceptions.FileDoesNotExistException;
import com.company.utility.forData.DataBase;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Command execute user's script
 */
public class ExecuteScriptCommand implements Command { ///good

    private final DataBase base; //Queue

    public ExecuteScriptCommand(DataBase base){
        this.base = base;
    }

    /**
     * Realization of this command
     * @param path - script path
     */
    private void ExecuteScriptRealization(String path){

        RequestsQueue queue = base.getQueue();

        File script = new File(path);
        try { //File checking
            FileOperator.FileExist(script);
            FileOperator.IsFile(script);
            FileOperator.Readable(script);

            queue.setStatus(false); //Program wont write writing invitation

            Scanner requests = new Scanner(script); //Check script
            List<String> list = new ArrayList<>(); //List of commands

            while (requests.hasNext()) list.add(requests.next());
            queue.pushAll(list);

            InfinityRecursionException.newRec();

        } catch (FileDoesNotExistException e){
            System.out.println("Скрипт не сработал - файла не существует");
        } catch (IsFileException e){
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