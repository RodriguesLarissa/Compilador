package ast;

public class CmdAtr extends AbstractCommand {

    private String id;
    private String expr;

    public CmdAtr(String id, String expr) {
        this.id = id;
        this.expr = expr;
    }

    @Override
    public String genJavaCode(int qntTabs) {
        return toTabs(qntTabs) + id + " = " + expr + ";";
    }

    @Override
    public String genPythonCode(int qntTabs) {
        return toTabs(qntTabs) + id + " = " + expr;
    }

    @Override
    public String toString() {
        return "CmdAtr [expr=" + expr + ", id=" + id + "]";
    }

}
