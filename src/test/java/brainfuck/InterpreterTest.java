package brainfuck;

import org.junit.Assert;
import org.junit.Test;

import brainfuck.interpreter.Interpreter;
import brainfuck.parser.CommandParser;

public class InterpreterTest {

    private static final int MEMORY_SIZE = 1024;

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenMemorySizeIsNegative() {
        new Interpreter(new CommandParser(), -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenMemorySizeIsZero() {
        new Interpreter(new CommandParser(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenCommandParserIsNull() {
        new Interpreter(null, MEMORY_SIZE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenProgramTextIsEmptyString() {
        interpreter().interpret("  ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenProgramTextIsNull() {
        interpreter().interpret(null);
    }

    @Test
    public void shouldReturnResultWhenSimpleProgramIsGiven() {
        // given
        final String helloWorld = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++" +
                ".>+.+++++++..+++.>++.<<+++++++++++++++.>.+++" +
                ".------.--------.>+.>.";
        final String expected = "Hello World!\n";

        // when
        String actual = interpreter().interpret(helloWorld);

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnResultWhenProgramContainsNestedLoops() {
        // given
        final String fibonacci = "+++++++++++>+>>>>++++++++++++++++++++++++++++++++++++++++++++>+++++++++++++++++++++" +
                "+++++++++++<<<<<<[>[>>>>>>+>+<<<<<<<-]>>>>>>>[<<<<<<<+>>>>>>>-]<[>++++++++++[-<-[>>+>+<<<-]>>>[<<<+>" +
                ">>-]+<[>[-]<[-]]>[<<[>>>+<<<-]>>[-]]<<]>>>[>>+>+<<<-]>>>[<<<+>>>-]+<[>[-]<[-]]>[<<+>>[-]]<<<<<<<]>>>" +
                ">>[++++++++++++++++++++++++++++++++++++++++++++++++.[-]]++++++++++<[->-<]>++++++++++++++++++++++++++" +
                "++++++++++++++++++++++.[-]<<<<<<<<<<<<[>>>+>+<<<<-]>>>>[<<<<+>>>>-]<-[>>.>.<<<[-]]<<[>>+>+<<<-]>>>[<" +
                "<<+>>>-]<<[<+>-]>[<+>-]<<<-]";

        final String expected = "1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89";

        // when
        String actual = interpreter().interpret(fibonacci);

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldIgnoreNotSupportedCharacters() {
        // given
        final String notSupportedChars = ",/123456789*";
        final String helloWorld = "++++++++++[>+++++++>" + notSupportedChars + "++++++++++>+++>+<<<<-]>++" +
                ".>+.+++++++..+++.>++.<<+++++++++++++++.>.+++" +
                ".------.--------.>+.>.";
        final String expected = "Hello World!\n";

        // when
        String actual = interpreter().interpret(helloWorld);

        // then
        Assert.assertEquals(expected, actual);
    }

    private static Interpreter interpreter() {
        return new Interpreter(new CommandParser(), MEMORY_SIZE);
    }
}
