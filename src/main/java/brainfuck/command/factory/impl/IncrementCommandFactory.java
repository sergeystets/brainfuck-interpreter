package brainfuck.command.factory.impl;

import brainfuck.command.Command;
import brainfuck.command.factory.CommandFactory;
import brainfuck.command.impl.Increment;

public class IncrementCommandFactory implements CommandFactory {

    private static final Increment INCREMENT = new Increment();

    @Override
    public Command get(int index, char[] chars) {
        return INCREMENT;
    }
}
