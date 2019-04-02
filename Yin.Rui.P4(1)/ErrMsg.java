/**
 * ErrMsg
 *
 * This class is used to generate warning and fatal error messages.
 */
class ErrMsg {
    public static boolean hasError;

    /**
     * Generates a fatal error message.
     * @param lineNum line number for error location
     * @param charNum character number (i.e., column) for error location
     * @param msg associated message for error
     */
    static void fatal(int lineNum, int charNum, String msg) {
        System.err.println(lineNum + ":" + charNum + " ***ERROR*** " + msg);
        hasError = true;
    }

    static void voidVar(int lineNum, int charNum) {
        fatal(lineNum, charNum, "Non-function declared void");
    }

    static void noSuchStruct(int lineNum, int charNum) {
        fatal(lineNum, charNum, "Invalid name of struct type");
    }

    static void noSuchField(int lineNum, int charNum) {
        fatal(lineNum, charNum, "Invalid struct field name");
    }

    static void varNotStruct(int lineNum, int charNum) {
        fatal(lineNum, charNum, "Dot-access of non-struct type");
    }

    static void undeclName(int lineNum, int charNum) {
        fatal(lineNum, charNum, "Undeclared identifier");
    }

    static void dupName(int lineNum, int charNum) {
        fatal(lineNum, charNum, "Multiply declared identifier");
    }

    /**
     * Generates a warning message.
     * @param lineNum line number for warning location
     * @param charNum character number (i.e., column) for warning location
     * @param msg associated message for warning
     */
    static void warn(int lineNum, int charNum, String msg) {
        System.err.println(lineNum + ":" + charNum + " ***WARNING*** " + msg);
    }
}
