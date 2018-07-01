package brainfuck.command;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import brainfuck.Memory;

@FunctionalInterface
public interface Command {

    Optional<Character> run(Memory memory, AtomicInteger commandPointer);
}
