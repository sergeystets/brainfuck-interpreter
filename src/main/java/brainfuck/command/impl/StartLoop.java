package brainfuck.command.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import brainfuck.command.Command;

public class StartLoop implements Command {

    @Override
    public void run(StringBuilder resultAggregator,
                    AtomicInteger commandIdx,
                    AtomicInteger memoryIdx,
                    char[] memory,
                    List<Command> commands) {
        if (memory[memoryIdx.get()] == 0) {
            int n = 1;
            while (n > 0) {
                Command nextCommand = commands.get(commandIdx.incrementAndGet());
                if (nextCommand instanceof StartLoop) {
                    n++;
                }
                if (nextCommand instanceof EndLoop) {
                    n--;
                }
            }
        }
    }
}
