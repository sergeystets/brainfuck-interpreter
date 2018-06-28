package brainfuck.interpreter;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import brainfuck.command.Command;
import brainfuck.parser.CommandParser;
import brainfuck.utils.Assert;

public class Interpreter {

    private final int memorySize;
    private final CommandParser commandParser;

    public Interpreter(CommandParser commandParser, int memorySize) {
        Assert.isTrue(memorySize > 0, "memory size should be > 0 ");
        Assert.notNull(commandParser, "command parser can not be null");
        this.memorySize = memorySize;
        this.commandParser = commandParser;
    }

    public String interpret(String program) {
        Assert.isNotBlank(program, "program can not be blank");

        List<Command> commands = commandParser.parse(program);

        AtomicInteger commandIdx = new AtomicInteger();
        AtomicInteger memoryIdx = new AtomicInteger();
        char[] memory = new char[memorySize];
        StringBuilder resultAggregator = new StringBuilder();

        while (commandIdx.get() < commands.size()) {
            Command command = commands.get(commandIdx.get());
            command.run(resultAggregator, commandIdx, memoryIdx, memory, commands);
            commandIdx.incrementAndGet();
        }

        return resultAggregator.toString();
    }
}
