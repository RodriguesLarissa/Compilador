package ast;

import structures.Variable;

public class CmdLeitura extends AbstractCommand {

    private String id;
    private Variable var;

    public CmdLeitura(String id, Variable var) {
        this.id = id;
        this.var = var;
    }

    @Override
    public String genJavaCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        return "CmdLeitura [id=" + id + ", var=" + var + "]";
    }

}
