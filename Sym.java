/**
 * @author Rui Yin 
 * @date 2019-01-28 13:29
 */
public class Sym {

    private String type;

    /**
     * constructor  initialize the Sym to have the given type
     * @param type
     */
    public Sym(String type) {
        this.type = type;
    }

    /**
     * Return this Sym's type.
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * Return this Sym's type.
     * @return
     */
    @Override
    public String toString() {
        return type;
    }
}
