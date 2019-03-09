/**
 * Test SymTable
 * @author: Rui Yin 
 * @date 2019-01-28 13:56
 */
public class P1 {
    public static void main(String[] args) {
        SymTable symTable = new SymTable();
        // print the initialize SymTable
        symTable.print();
        System.out.println("-----------------------");

        // addDecl throw WrongArgumentException when idName and sym is null
        try {
            symTable.addDecl(null, null);
        } catch (EmptySymTableException | WrongArgumentException | DuplicateSymException e) {
            printException(e);
        }

        // addDecl throw WrongArgumentException when idName is null
        try {
            symTable.addDecl(null, new Sym("a"));
        } catch (EmptySymTableException | WrongArgumentException | DuplicateSymException e) {
            printException(e);
        }

        // addDecl throw WrongArgumentException when sym is null
        try {
            symTable.addDecl("a", null);
        } catch (EmptySymTableException | WrongArgumentException | DuplicateSymException e) {
            printException(e);
        }

        try {
            symTable.addDecl("a", new Sym("A"));
            symTable.addDecl("b", new Sym("B"));
            // the line code will throw DuplicateSymException
            symTable.addDecl("a", new Sym("A"));
        } catch (EmptySymTableException | WrongArgumentException | DuplicateSymException e) {
            printException(e);
        }

        symTable.print();
        System.out.println("------------------------------------");

        // test lookupLocal
        try {
            Sym symA = symTable.lookupLocal("a");
            //will print A
            System.out.println(symA);
            Sym symEmpty = symTable.lookupLocal("abc");
            //will print null
            System.out.println(symEmpty);
        } catch (EmptySymTableException e) {
            printException(e);
        }

        System.out.println("--------------------------");

        // test add Scope
        symTable.addScope();
        symTable.print();
        System.out.println("---------------------------");

        // test lookupGlobal
        try {
            Sym symA = symTable.lookupGlobal("a");
            // will print A
            System.out.println(symA);
            Sym symEmpty = symTable.lookupGlobal("aa");
            // will print null
            System.out.println(symEmpty);
        } catch (EmptySymTableException e) {
            printException(e);
        }

        System.out.println("--------------------------------");

        try {
            symTable.removeScope();
        } catch (EmptySymTableException e) {
            printException(e);
        }

        symTable.print();
        System.out.println("--------------------------------");

        // remove again and the tables in SymTable is empty
        try {
            symTable.removeScope();
        } catch (EmptySymTableException e) {
            printException(e);
        }

        // test addDecl EmptySymTableException
        try {
            symTable.addDecl("c", new Sym("C"));
        } catch (EmptySymTableException | WrongArgumentException | DuplicateSymException e) {
            printException(e);
        }

        // test lookupLocal EmptySymTableException
        try {
            symTable.lookupLocal("a");
        } catch (EmptySymTableException e) {
            printException(e);
        }

        // test lookupGlobal EmptySymTableException
        try {
            symTable.lookupGlobal("a");
        } catch (EmptySymTableException e) {
            printException(e);
        }

        // test removeScope EmptySymTableException
        try {
            symTable.removeScope();
        } catch (EmptySymTableException e) {
            printException(e);
        }
    }
    
	// test the final result in this case 
	// try doing it in a different perception
	 
    private static void printException(Exception e) {
        if (e instanceof EmptySymTableException) {
            System.out.println("Sym Table is empty");
        }
        if (e instanceof WrongArgumentException) {
            System.out.println(e.getMessage());
        }
        if (e instanceof DuplicateSymException) {
            System.out.println("duplicate elements in Sym Table");
        }
    }
}
