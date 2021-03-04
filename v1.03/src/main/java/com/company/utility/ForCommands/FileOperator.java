package com.company.utility.ForCommands;

import com.company.exceptions.*;

import java.io.File;

public class FileOperator {

    public static void Readable(File file) throws CantReadException{
        if (!file.canRead()) throw new CantReadException();
    }

    public static void Writable(File file) throws CantWriteException{
        if (!file.canWrite()) throw new CantWriteException();
    }

    public static void IsFile(File file) throws IsFileException{
        if (!file.isFile()) throw new IsFileException();
    }

    public static void EnvExist(String path) throws  EnvVarDoesNotExistException{
        if (path == null) throw new EnvVarDoesNotExistException();
    }

    public static void FileExist(File file) throws FileDoesNotExistException{
        if (!file.exists()) throw new FileDoesNotExistException();
    }

    public static void IsJSON(String path){
        String[] kostyl = path.split("\\.");
        if (!kostyl[kostyl.length - 1].equals("json")) throw new NotJsonException();
    }

}
