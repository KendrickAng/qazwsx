package simpledb.query;

/**
 * The class that denotes values stored in the database.
 *
 * @author Edward Sciore
 */
public class Constant implements Comparable<Constant> {
    private Integer ival = null;
    private String sval = null;

    public Constant(Integer ival) {
        this.ival = ival;
    }

    public Constant(String sval) {
        this.sval = sval;
    }

    public int asInt() {
        return ival;
    }

    public String asString() {
        return sval;
    }

    public boolean equals(Object obj) {
        Constant c = (Constant) obj;
        if (ival != null) {
            System.out.println("integer!");
            System.out.println(ival);
            System.out.println(c.ival);
        } else {
            System.out.println("string!");
            System.out.println(sval);
            System.out.println(c.sval);
        }
        return (ival != null) ? ival.equals(c.ival) : sval.equals(c.sval);
    }

    public boolean lt(Constant c) {
        return this.compareTo(c) < 0;
    }

    public boolean gt(Constant c) {
        return this.compareTo(c) > 0;
    }

    public boolean le(Constant c) {
        return lt(c) || this.equals(c);
    }

    public boolean ge(Constant c) {
        return gt(c) || this.equals(c);
    }

    public boolean ne(Constant c) {
        return !equals(c);
    }

    public int compareTo(Constant c) {
        return (ival != null) ? ival.compareTo(c.ival) : sval.compareTo(c.sval);
    }

    public int hashCode() {
        return (ival != null) ? ival.hashCode() : sval.hashCode();
    }

    public String toString() {
        return (ival != null) ? ival.toString() : sval;
    }
}
