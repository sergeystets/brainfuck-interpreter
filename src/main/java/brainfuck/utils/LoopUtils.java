package brainfuck.utils;

public final class LoopUtils {

    private LoopUtils() {
    }

    public static int findLoopStart(int loopEndIndex, char[] chars) {
        return findLoopElement(loopEndIndex, chars, true);
    }

    public static int findLoopEnd(int loopStartIndex, char[] chars) {
        return findLoopElement(loopStartIndex, chars, false);
    }

    private static int findLoopElement(int index, char[] chars, boolean findStart) {
        int nesting = 1;
        while (nesting > 0) {
            char element = chars[findStart ? --index : ++index];
            if (element == '[') {
                nesting = findStart ? nesting - 1 : nesting + 1;
            }
            if (element == ']') {
                nesting = findStart ? nesting + 1 : nesting - 1;
            }
        }
        return index;
    }
}
