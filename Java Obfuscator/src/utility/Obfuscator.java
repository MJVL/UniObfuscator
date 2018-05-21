package utility;

public final class Obfuscator {

    public static final String BLOCK_START = "/*";
    public static final String BLOCK_END = "*/";
    public static final String TODO = "TODO:";

    public enum Modifier {
        NONE,
        COMMENT,
        TODO
    }

    private Obfuscator() {
        throw new AssertionError();
    }

    public static String obfuscate(String pString) {
        return obfuscate(pString, "", Modifier.COMMENT);
    }

    public static String obfuscate(String pString, String bComment, Modifier cModifier) {
        return ((cModifier == Modifier.COMMENT || cModifier == Modifier.TODO) ?  BLOCK_START + ((cModifier == Modifier.TODO) ? " " + TODO : "") + bComment + toUnicode(BLOCK_END) : "") + toUnicode(pString) + ((cModifier == Modifier.COMMENT || cModifier == Modifier.TODO) ? toUnicode(BLOCK_START) + BLOCK_END : "");
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
