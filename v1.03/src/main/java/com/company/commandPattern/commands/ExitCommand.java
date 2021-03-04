package com.company.commandPattern.commands;

import com.company.commandPattern.Command;

/**
 * Command stops the program
 */
public class ExitCommand implements Command { //done //maybe //TESTED!

    /**
     * Realization of this command
     */
    private void ExitRealization(){
        System.exit(0);
    }

    /**
     * Execution of this command
     */
    @Override
    public void execute(String Argument) {
        if (Argument != null) System.out.println("Эта комманда не требует никаих аргуметов так-то :)");
        ExitRealization();
    }
}
