package brainfuck.command.impl;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import brainfuck.Memory;
import brainfuck.command.Command;

public class Increment implements Command {

    @Override
    public Optional<Character> run(Memory memory, AtomicInteger commandPointer) {
        memory.putValue((byte) (memory.getValue() + 1));
        return Optional.empty();
    }
}
