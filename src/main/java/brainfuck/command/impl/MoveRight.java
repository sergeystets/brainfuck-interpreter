package brainfuck.command.impl;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import brainfuck.Memory;
import brainfuck.command.Command;

public class MoveRight implements Command {

    @Override
    public Optional<Character> run(Memory memory, AtomicInteger commandPointer) {
        memory.incrementPointer();
        return Optional.empty();
    }
}
