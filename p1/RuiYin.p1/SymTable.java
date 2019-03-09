import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Rui Yin 
 * @date 2019-01-28 13:30
 */
public class SymTable {
    private List<HashMap<String, Sym>> tables;

    /**
     * constructor  initialize the SymTable's List field to contain a single, empty HashMap.
     */
    public SymTable(){
        tables = new ArrayList<>();
        tables.add(new HashMap<>());
    }

    /**
     * If this SymTable's list is empty, throw an EmptySymTableException.
     * If either idName or sym (or both) is null, throw a WrongArgumentException
     * If the first HashMap in the list already contains the given id name as a key, throw a DuplicateSymException.
     * add the given idName and sym to the first HashMap in the list
     * @param idName
     * @param sym
     * @throws DuplicateSymException
     * @throws EmptySymTableException
     * @throws WrongArgumentException
     */
    public void addDecl(String idName, Sym sym) throws DuplicateSymException,EmptySymTableException,WrongArgumentException{
        if (tables.isEmpty()) {
            throw new EmptySymTableException();
        }
        if (null == idName && null != sym) {
            throw new WrongArgumentException("Id name is null.");
        }
        if (null != idName && null == sym) {
            throw new WrongArgumentException("Sym is null.");
        }
        if (null == idName && null == sym) {
            throw new WrongArgumentException("Id name and sym are null.");
        }
        for (HashMap<String, Sym> map : tables) {
            if (map.get(idName) != null) {
                throw new DuplicateSymException();
            }
        }
        HashMap<String, Sym> map = tables.get(0);
        map.put(idName, sym);
    }

    /**
     * Add a new, empty HashMap to the front of the list.
     */
    public void addScope() {
        tables.add(0, new HashMap<>());
    }

    /**
     * If this SymTable's list is empty, throw an EmptySymTableException.
     * if the first HashMap in the list contains id name as a key, return the associated Sym; otherwise, return null.
     * @param idName
     * @return
     * @throws EmptySymTableException
     */
    public Sym lookupLocal(String idName) throws EmptySymTableException {
        if (tables.isEmpty()) {
            throw new EmptySymTableException();
        }
        HashMap<String, Sym> firstMap = tables.get(0);
        return firstMap.get(idName);
    }

    /**
     * If this SymTable's list is empty, throw an EmptySymTableException.
     * If any HashMap in the list contains idName as a key, return the first associated Sym (i.e., the one from the HashMap that is closest to the front of the list); otherwise, return null.
     * @param idName
     * @return
     * @throws EmptySymTableException
     */
    public Sym lookupGlobal(String idName) throws EmptySymTableException {
        if (tables.isEmpty()) {
            throw new EmptySymTableException();
        }
        for (HashMap<String, Sym> map : tables) {
            if (map.get(idName) != null) {
                return map.get(idName);
            }
        }
        return null;
    }

    /**
     * If this SymTable's list is empty, throw an EmptySymTableException.
     * remove the HashMap from the front of the list.
     * @throws EmptySymTableException
     */
    public void removeScope() throws EmptySymTableException {
        if (tables.isEmpty()) {
            throw new EmptySymTableException();
        }
        tables.remove(0);
    }

    /**
     * print the elements in the tables
     */
    public void print() {
        System.out.println("\n=== Sym Table ===\n");
        for (HashMap<String, Sym> M : tables) {
            System.out.println(M.toString());
        }
    }
}
