package ast;

import java.util.ArrayList;

public class CmdLoop extends AbstractCommand {

    private String condicao;
    private ArrayList<AbstractCommand> cmds;

    public CmdLoop(String condicao, ArrayList<AbstractCommand> cmds) {
        this.condicao = condicao;
        this.cmds = cmds;
    }

    @Override
    public String genJavaCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        return "CmdLoop [cmds=" + cmds + ", condicao=" + condicao + "]";
    }

}
