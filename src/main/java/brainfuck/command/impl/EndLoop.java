package brainfuck.command.impl;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import brainfuck.Memory;
import brainfuck.command.Command;

public class EndLoop implements Command {

    private final int startsAt;

    public EndLoop(int startsAt) {
        this.startsAt = startsAt;
    }

    @Override
    public Optional<Character> run(Memory memory, AtomicInteger commandPointer) {
        if (memory.getValue() != 0) {
            commandPointer.set(startsAt);
        }
        return Optional.empty();
    }
}
