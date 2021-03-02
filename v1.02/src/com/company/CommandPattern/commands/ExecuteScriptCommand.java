package com.company.CommandPattern.commands;

import com.company.CommandPattern.Command;
import com.company.exceptions.CantReadException;
import com.company.exceptions.FileDoesNotExistException;
import com.company.exceptions.IsDirException;
import com.company.exceptions.NotJsonException;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ExecuteScriptCommand implements Command {


    private void ExecuteScriptRealization(String path){
        File script = new File(path);
        try {
            if (!script.exists()) throw new FileDoesNotExistException();
            if (script.isDirectory()) throw new IsDirException();
            if (!script.canRead()) throw new CantReadException();

//            Scanner in = new Scanner(System.in);
//            Path newPath = Paths.get(path);
//            Scanner scanner = new Scanner(newPath);
//            while (scanner.hasNext()) in.next(scanner.next());

        } catch (FileDoesNotExistException e){
            System.out.println("Скрипт не сработал - файла не существует");
        } catch (IsDirException e){
            System.out.println("Скрипт не сработал - файла дириктория");
        } catch (CantReadException e){
            System.out.println("Скрипт не сработал - нет прав на чтение файла");
        }
    }

    @Override
    public void execute(String Argument) {
        if (Argument == null) System.out.println("Не хватает аргумета (Адрес скрипта)");
        else ExecuteScriptRealization(Argument);
    }
}
