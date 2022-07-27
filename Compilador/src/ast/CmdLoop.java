package ast;

import java.util.ArrayList;

public class CmdLoop extends AbstractCommand {

    private String condition;
    private ArrayList<AbstractCommand> cmds;

    public CmdLoop(String condition, ArrayList<AbstractCommand> cmds) {
        this.condition = condition;
        this.cmds = cmds;
    }

    public CmdLoop() {

    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setCmds(ArrayList<AbstractCommand> cmds) {
        this.cmds = cmds;
    }

    @Override
    public String genJavaCode(int qntTabs) {

        StringBuilder str = new StringBuilder();
        str.append(toTabs(qntTabs) + "while (" + condition + ") {\n");
        for (AbstractCommand cmd : cmds) {
            str.append(cmd.genJavaCode(qntTabs + 1) + "\n");
        }
        str.append(toTabs(qntTabs) + "}");

        return str.toString();
    }

    @Override
    public String toString() {
        return "CmdLoop [cmds=" + cmds + ", condicao=" + condition + "]";
    }

}
