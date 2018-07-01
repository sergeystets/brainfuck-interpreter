package brainfuck.command.impl;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import brainfuck.Memory;
import brainfuck.command.Command;

public class StartLoop implements Command {

    private final int endsAt;

    public StartLoop(int endsAt) {
        this.endsAt = endsAt;
    }

    @Override
    public Optional<Character> run(Memory memory, AtomicInteger commandPointer) {
        if (memory.getValue() == 0) {
            commandPointer.set(endsAt);
        }
        return Optional.empty();
    }
}
