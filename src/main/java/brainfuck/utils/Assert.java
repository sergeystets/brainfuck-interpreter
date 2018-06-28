package brainfuck.utils;

import static java.util.Objects.isNull;

public final class Assert {

    private Assert() {
    }

    public static void isNotBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notNull(Object object, String message) {
        if (isNull(object)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isTrue(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }
}
