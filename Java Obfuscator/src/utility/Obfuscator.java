package utility;

public class Obfuscator {

    public static final String BLOCK_START = "/*";
    public static final String BLOCK_END = "*/";

    public enum Modifier {
        COMMENT,
        TODO
    }

    public static String obfuscate(String pString) {
        return obfuscate(pString, "");
    }

    public static String obfuscate(String pString, String bComment) {
        return BLOCK_START + bComment + toUnicode(BLOCK_END) + toUnicode(pString) + toUnicode(BLOCK_START) + BLOCK_END;
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
