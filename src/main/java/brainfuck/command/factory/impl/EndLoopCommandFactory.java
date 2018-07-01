package brainfuck.command.factory.impl;

import brainfuck.command.Command;
import brainfuck.command.factory.CommandFactory;
import brainfuck.command.impl.EndLoop;
import brainfuck.utils.LoopUtils;

public class EndLoopCommandFactory implements CommandFactory {

    @Override
    public Command get(int index, char[] chars) {
        return new EndLoop(LoopUtils.findLoopStart(index, chars));
    }
}
