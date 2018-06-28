package brainfuck.command.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import brainfuck.command.Command;

public class Increment implements Command {

    @Override
    public void run(StringBuilder resultAggregator,
                    AtomicInteger commandIdx,
                    AtomicInteger memoryIdx,
                    char[] memory,
                    List<Command> commands) {
        memory[memoryIdx.get()]++;
    }
}
