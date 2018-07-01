package brainfuck.command.factory;

import brainfuck.command.Command;

public interface CommandFactory {

    Command get(int index, char[] chars);
}
