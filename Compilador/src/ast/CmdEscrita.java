package ast;

public class CmdEscrita extends AbstractCommand {

    private String id;

    public CmdEscrita(String id) {
        this.id = id;
    }

    @Override
    public String genJavaCode(int qntTabs) {
        return toTabs(qntTabs) + "System.out.println(" + id + ");";
    }

    @Override
    public String genPythonCode(int qntTabs) {
        return toTabs(qntTabs) + "print(" + id + ")";
    }

    @Override
    public String toString() {
        return "CmdEscrita [id=" + id + "]";
    }

}
