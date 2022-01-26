package simpledb.query;

import simpledb.parse.BadSyntaxException;

public class RelOp {
    private static final String LT = "<";
    private static final String LE = "<=";
    private static final String GT = ">";
    private static final String GE = ">=";
    private static final String EQ = "=";
    private static final String NE_FLAT = "!=";
    private static final String NE_DIAMOND = "<>";

    private final String op;

    public static RelOp lt() {
        return new RelOp(LT);
    }
    public static RelOp le() {
        return new RelOp(LE);
    }
    public static RelOp gt() {
        return new RelOp(GT);
    }
    public static RelOp ge() {
        return new RelOp(GE);
    }
    public static RelOp eq() {
        return new RelOp(EQ);
    }
    public static RelOp ne() {
        return new RelOp(NE_FLAT);
    }
    public static RelOp neDiamond() {
        return new RelOp(NE_DIAMOND);
    }

    public RelOp(String op) {
        this.op = op;
    }

    boolean evaluate(Constant c1, Constant c2) {
        switch (op) {
            case LT:
                return c1.lt(c2);
            case LE:
                return c1.le(c2);
            case GT:
                return c1.gt(c2);
            case GE:
                return c1.ge(c2);
            case EQ:
                return c1.equals(c2);
            case NE_FLAT:
            case NE_DIAMOND:
                return c1.ne(c2);
            default:
                throw new BadSyntaxException();
        }
    }
}
