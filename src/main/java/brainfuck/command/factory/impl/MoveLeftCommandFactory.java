package brainfuck.command.factory.impl;

import brainfuck.command.Command;
import brainfuck.command.factory.CommandFactory;
import brainfuck.command.impl.MoveLeft;

public class MoveLeftCommandFactory implements CommandFactory {

    private static final MoveLeft MOVE_LEFT = new MoveLeft();

    @Override
    public Command get(int index, char[] chars) {
        return MOVE_LEFT;
    }
}
