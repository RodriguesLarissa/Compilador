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
    public String genJavaCode(int qntTabs) {
        String f = "";
        if (var.getType() == Variable.INT) {
            f = "nextInt();";
        } else if (var.getType() == Variable.DOUBLE) {
            f = "nextDouble();";
        } else {
            f = "nextLine();";
        }
        return toTabs(qntTabs) + id + " = scan." + f;
    }

    @Override
    public String toString() {
        return "CmdLeitura [id=" + id + ", var=" + var + "]";
    }

}
