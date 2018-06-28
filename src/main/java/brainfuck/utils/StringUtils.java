package brainfuck.utils;

import static java.util.Objects.isNull;

public final class StringUtils {

    private StringUtils() {
    }

    public static boolean isBlank(String string) {
        return isNull(string) || string.trim().length() == 0;
    }
}
