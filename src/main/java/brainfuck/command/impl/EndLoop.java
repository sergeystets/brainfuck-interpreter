package brainfuck.command.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import brainfuck.command.Command;

public class EndLoop implements Command {

    @Override
    public void run(StringBuilder resultAggregator,
                    AtomicInteger commandIdx,
                    AtomicInteger memoryIdx,
                    char[] memory,
                    List<Command> commands) {
        if (memory[memoryIdx.get()] != 0) {
            int n = 1;
            while (n > 0) {
                Command prevCommand = commands.get(commandIdx.decrementAndGet());
                if (prevCommand instanceof StartLoop) {
                    n--;
                }
                if (prevCommand instanceof EndLoop) {
                    n++;
                }
            }
            commandIdx.decrementAndGet();
        }
    }
}
