package brainfuck.command.factory.impl;

import brainfuck.command.Command;
import brainfuck.command.factory.CommandFactory;
import brainfuck.command.impl.StartLoop;
import brainfuck.utils.LoopUtils;

public class StartLoopCommandFactory implements CommandFactory {

    @Override
    public Command get(int index, char[] chars) {
        return new StartLoop(LoopUtils.findLoopEnd(index, chars));
    }
}
