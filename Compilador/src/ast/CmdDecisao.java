package ast;

import java.util.ArrayList;

public class CmdDecisao extends AbstractCommand {

    private String condition;
    private ArrayList<AbstractCommand> listTrue;
    private ArrayList<AbstractCommand> listFalse;

    public CmdDecisao(String condition, ArrayList<AbstractCommand> listTrue, ArrayList<AbstractCommand> listFalse) {
        this.condition = condition;
        this.listTrue = listTrue;
        this.listFalse = listFalse;
    }

    public CmdDecisao() {

    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setListTrue(ArrayList<AbstractCommand> listTrue) {
        this.listTrue = listTrue;
    }

    public void setListFalse(ArrayList<AbstractCommand> listFalse) {
        this.listFalse = listFalse;
    }

    @Override
    public String genJavaCode() {
        StringBuilder str = new StringBuilder();
        str.append("if (" + condition + ") {\n");
        for (AbstractCommand cmd : listTrue) {
            str.append(cmd.genJavaCode());
        }
        str.append("\n}");
        if (listFalse.size() > 0) {
            str.append(" else {\n");
            for (AbstractCommand cmd : listFalse) {
                str.append(cmd.genJavaCode());
            }
            str.append("\n}");

        }
        return str.toString();
    }

    @Override
    public String toString() {
        return "CmdDecisao [condition=" + condition + ", listFalse=" + listFalse + ", listTrue=" + listTrue + "]";
    }

}
