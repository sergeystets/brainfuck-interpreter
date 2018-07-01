package brainfuck.parser;

import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import brainfuck.command.Command;
import brainfuck.command.factory.CommandFactory;
import brainfuck.command.factory.impl.DecrementCommandFactory;
import brainfuck.command.factory.impl.EndLoopCommandFactory;
import brainfuck.command.factory.impl.IncrementCommandFactory;
import brainfuck.command.factory.impl.MoveLeftCommandFactory;
import brainfuck.command.factory.impl.MoveRightCommandFactory;
import brainfuck.command.factory.impl.OutputCommandFactory;
import brainfuck.command.factory.impl.StartLoopCommandFactory;

public class CommandParser {

    private static final Map<Character, CommandFactory> AVAILABLE_COMMANDS = new HashMap<>();

    static {
        AVAILABLE_COMMANDS.put('+', new IncrementCommandFactory());
        AVAILABLE_COMMANDS.put('-', new DecrementCommandFactory());
        AVAILABLE_COMMANDS.put('>', new MoveRightCommandFactory());
        AVAILABLE_COMMANDS.put('<', new MoveLeftCommandFactory());
        AVAILABLE_COMMANDS.put('[', new StartLoopCommandFactory());
        AVAILABLE_COMMANDS.put(']', new EndLoopCommandFactory());
        AVAILABLE_COMMANDS.put('.', new OutputCommandFactory());
    }

    public List<Command> parse(String program) {
        char[] chars = program.toCharArray();
        List<Command> commands = new ArrayList<>();

        for (int index = 0; index < chars.length; index++) {
            CommandFactory commandFactory = AVAILABLE_COMMANDS.get(chars[index]);
            if (nonNull(commandFactory)) {
                commands.add(commandFactory.get(index, chars));
            }
        }

        return commands;
    }
}
