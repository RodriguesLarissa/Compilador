package ast;

public class CmdEscrita extends AbstractCommand {

    private String id;

    public CmdEscrita(String id) {
        this.id = id;
    }

    @Override
    public String genJavaCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        return "CmdEscrita [id=" + id + "]";
    }

}
