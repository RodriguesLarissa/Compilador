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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        return "CmdDecisao [condition=" + condition + ", listFalse=" + listFalse + ", listTrue=" + listTrue + "]";
    }

}
