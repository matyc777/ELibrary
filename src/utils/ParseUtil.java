package utils;

public class ParseUtil {
    public static Integer tryParse(String value) {
        return tryParse(value, null);
    }

    public static Integer tryParse(String value, Integer defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
