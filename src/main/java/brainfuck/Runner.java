package brainfuck;

import brainfuck.interpreter.Interpreter;
import brainfuck.parser.CommandParser;

public class Runner {

    private static final String USAGE = "Usage java -jar brainfuck.jar <program-instructions-string>";

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Missing required string parameter.");
            System.out.println(USAGE);
            return;
        }
        String program = args[0];
        Interpreter interpreter = new Interpreter(new CommandParser(), 1024);
        System.out.println("Result -> " + interpreter.interpret(program));
    }
}
