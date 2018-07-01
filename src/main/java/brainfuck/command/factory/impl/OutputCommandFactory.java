package brainfuck.command.factory.impl;

import brainfuck.command.Command;
import brainfuck.command.factory.CommandFactory;
import brainfuck.command.impl.Output;

public class OutputCommandFactory implements CommandFactory {

    private static final Output OUTPUT = new Output();

    @Override
    public Command get(int index, char[] chars) {
        return OUTPUT;
    }
}
