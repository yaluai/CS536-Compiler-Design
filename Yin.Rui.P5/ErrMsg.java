/**
 * ErrMsg
 *
 * This class is used to generate warning and fatal error messages.
 */
class ErrMsg {
	private static boolean err = false;
	
    /**
     * Generates a fatal error message.
     * @param lineNum line number for error location
     * @param charNum character number (i.e., column) for error location
     * @param msg associated message for error
     */
    static void fatal(int lineNum, int charNum, String msg) {
		err = true;
        System.err.println(lineNum + ":" + charNum + " ***ERROR*** " + msg);
    }

    /**
     * Generates a fatal error message.
     * @param exp the expression resulting in the error
     * @param msg associated message for error
     */
    static void fatal(ExpNode exp, String msg) {
        int lineNum;
        int charNum;

        while (true) {
            if (exp instanceof IdNode) {
                lineNum = ((IdNode) exp).myLineNum;
                charNum = ((IdNode) exp).myCharNum;
                break;
            } else if (exp instanceof IntLitNode) {
                lineNum = ((IntLitNode) exp).myLineNum;
                charNum = ((IntLitNode) exp).myCharNum;
                break;
            } else if (exp instanceof StringLitNode) {
                lineNum = ((StringLitNode) exp).myLineNum;
                charNum = ((StringLitNode) exp).myCharNum;
                break;
            } else if (exp instanceof TrueNode) {
                lineNum = ((TrueNode) exp).myLineNum;
                charNum = ((TrueNode) exp).myCharNum;
                break;
            } else if (exp instanceof FalseNode) {
                lineNum = ((FalseNode) exp).myLineNum;
                charNum = ((FalseNode) exp).myCharNum;
                break;
            } else if (exp instanceof DotAccessExpNode) {
                exp = ((DotAccessExpNode) exp).myId;
            } else if (exp instanceof AssignNode) {
                exp = ((AssignNode) exp).myLhs;
            } else if (exp instanceof CallExpNode) {
                exp = ((CallExpNode) exp).myId;
            } else if (exp instanceof UnaryExpNode) {
                exp = ((UnaryExpNode) exp).myExp;
            } else if (exp instanceof BinaryExpNode) {
                exp = ((BinaryExpNode) exp).myExp1;
            } else {
                assert false;
            }
        }

        fatal(lineNum, charNum, msg);
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
	
    /**
     * Returns the err flag.
     */
    static boolean getErr() {
	return err;
    }
}
