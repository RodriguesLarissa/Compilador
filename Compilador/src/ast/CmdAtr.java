package ast;

public class CmdAtr extends AbstractCommand {

    private String id;
    private String expr;

    public CmdAtr(String id, String expr) {
        this.id = id;
        this.expr = expr;
    }

    @Override
    public String genJavaCode() {
        return id + " = " + expr + ";";
    }

    @Override
    public String toString() {
        return "CmdAtr [expr=" + expr + ", id=" + id + "]";
    }

}
