package brainfuck.command.factory.impl;

import brainfuck.command.Command;
import brainfuck.command.factory.CommandFactory;
import brainfuck.command.impl.Decrement;

public class DecrementCommandFactory implements CommandFactory {

    private static final Decrement DECREMENT = new Decrement();

    @Override
    public Command get(int index, char[] chars) {
        return DECREMENT;
    }
}
