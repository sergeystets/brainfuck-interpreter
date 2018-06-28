package brainfuck.parser;

import static java.util.stream.Collectors.toList;

import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import brainfuck.command.Command;
import brainfuck.command.impl.Decrement;
import brainfuck.command.impl.EndLoop;
import brainfuck.command.impl.Increment;
import brainfuck.command.impl.MoveLeft;
import brainfuck.command.impl.MoveRight;
import brainfuck.command.impl.Output;
import brainfuck.command.impl.StartLoop;

public class CommandParser {

    private static final Map<Character, Command> AVAILABLE_COMMANDS = new HashMap<>();

    static {
        AVAILABLE_COMMANDS.put('+', new Increment());
        AVAILABLE_COMMANDS.put('-', new Decrement());
        AVAILABLE_COMMANDS.put('>', new MoveRight());
        AVAILABLE_COMMANDS.put('<', new MoveLeft());
        AVAILABLE_COMMANDS.put('[', new StartLoop());
        AVAILABLE_COMMANDS.put(']', new EndLoop());
        AVAILABLE_COMMANDS.put('.', new Output());
    }

    public List<Command> parse(String program) {
        Stream<Character> characters = CharBuffer.wrap(program.toCharArray()).chars().mapToObj(c -> (char) c);
        return characters.map(AVAILABLE_COMMANDS::get).filter(Objects::nonNull).collect(toList());
    }
}
