package brainfuck.command.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import brainfuck.command.Command;

public class Output implements Command {

    @Override
    public void run(StringBuilder resultAggregator,
                    AtomicInteger commandIdx,
                    AtomicInteger memoryIdx,
                    char[] memory,
                    List<Command> commands) {
        resultAggregator.append(memory[memoryIdx.get()]);
    }
}
