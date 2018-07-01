package brainfuck.command.factory.impl;

import brainfuck.command.Command;
import brainfuck.command.factory.CommandFactory;
import brainfuck.command.impl.MoveRight;

public class MoveRightCommandFactory implements CommandFactory {

    private static final MoveRight MOVE_RIGHT = new MoveRight();

    @Override
    public Command get(int index, char[] chars) {
        return MOVE_RIGHT;
    }
}
