package brainfuck.command;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@FunctionalInterface
public interface Command {

    void run(StringBuilder resultAggregator,
             AtomicInteger commandIdx,
             AtomicInteger memoryIdx,
             char[] memory,
             List<Command> commands);
}
