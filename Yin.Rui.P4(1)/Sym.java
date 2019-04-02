import java.util.*;

public class Sym {

    final SymType type;
    
    public Sym(SymType type) {
        this.type = type;
    }
    
    public String toString() {
        return type.toString();
    }
}

enum SymType {
    Int {
        @Override
        public String toString() {
            return "int";
        }
    },
    Bool {
        @Override
        public String toString() {
            return "bool";
        }
    },
    Void {
        @Override
        public String toString() {
            return "void";
        }
    },
    Struct,
    StructDef,
    Func;

    @Override
    public String toString() {
        assert false;
        return "";
    }
}

class FuncSym extends Sym {
    final List<SymType> params = new ArrayList<SymType>();
    final SymType retType;

    FuncSym(SymType retType) {
        super(SymType.Func);
        this.retType = retType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean t = false;
        for (SymType ty : params) {
            if (t) {
                sb.append(", ");
            }
            sb.append(ty);
            t = true;
        }

        sb.append(" -> ").append(retType);

        return sb.toString();
    }
}

class StructDefSym extends Sym {
    Map<String, Sym> fields;

    StructDefSym() {
        super(SymType.StructDef);
    }

    @Override
    public String toString() {
        assert false;
        return "";
    }
}

class StructSym extends Sym {
    final String struct;
    final StructDefSym def;

    StructSym(String struct, StructDefSym def) {
        super(SymType.Struct);
        this.struct = struct;
        this.def = def;
    }

    @Override
    public String toString() {
        return struct;
    }
}