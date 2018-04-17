package utility;

public class Obfuscator {

    public enum Modifier {
        COMMENT,
        TODO
    }

    public static String obfuscate(String pString) {
        return obfuscate(pString, "");
    }

    public static String obfuscate(String pString, String bComment) {
        return "/*" + bComment + toUnicode("*/") + toUnicode(pString) + toUnicode("/*") + "*/";
    }

    public static String toUnicode(String uString) {
        String unicode = "";
        for (char c: uString.toCharArray()) {
            unicode += toUnicode(c);
        }
        return unicode;
    }

    public static String toUnicode(Character uChar) {
        return "\\u" + Integer.toHexString(uChar | 0x10000).substring(1);
    }

}
