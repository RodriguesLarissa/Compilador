package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.AbstractAction;

public class CmdSwitchCase extends AbstractCommand {
    private String id;
    private HashMap<String, ArrayList<AbstractCommand>> cases;
    private ArrayList<AbstractCommand> dfls;
    private final String findString = "FLCV1";

    public CmdSwitchCase(String id) {
        this.id = id;
        this.cases = new HashMap<String, ArrayList<AbstractCommand>>();
    }

    public void setDfls(ArrayList<AbstractCommand> dfls) {
        this.dfls = dfls;
    }

    public boolean existsCase(String id) {
        return cases.get(id) != null;
    }

    public void addCase(String id, ArrayList<AbstractCommand> cmd) {
        cases.put(id, cmd);
    }

    @Override
    public String genJavaCode(int qntTabs) {
        StringBuilder str = new StringBuilder();
        str.append(toTabs(qntTabs) + "switch (" + id + ") {\n");
        for (Entry<String, ArrayList<AbstractCommand>> e : cases.entrySet()) {
            str.append(toTabs(qntTabs) + "case " + e.getKey() + ":\n");
            for (AbstractCommand cmd : e.getValue()) {
                str.append(cmd.genJavaCode(qntTabs + 1) + "\n");
            }
        }
        str.append(toTabs(qntTabs) + "default:\n");
        for (AbstractCommand cmd : dfls) {
            str.append(cmd.genJavaCode(qntTabs + 1) + "\n");
        }

        str.append(toTabs(qntTabs) + "}");

        return str.toString();
    }

    @Override
    public String genPythonCode(int qntTabs) {
        StringBuilder str = new StringBuilder();
        AbstractCommand lastCmd = null;
        str.append(toTabs(qntTabs) + CmdBreak.pythonBreakName + " = False\n");
        str.append(toTabs(qntTabs) + findString + " = False\n");
        for (Entry<String, ArrayList<AbstractCommand>> e : cases.entrySet()) {
            str.append(toTabs(qntTabs) + "if " + id + "==" + e.getKey() + " or " + CmdBreak.pythonBreakName
                    + ":\n");
            for (AbstractCommand cmd : e.getValue()) {
                str.append(cmd.genPythonCode(qntTabs + 1) + "\n");
                lastCmd = cmd;
            }
            if (!(lastCmd instanceof CmdBreak)) {
                str.append(toTabs(qntTabs + 1) + CmdBreak.pythonBreakName + " = True\n");
            }
            str.append(toTabs(qntTabs + 1) + findString + " = True\n");
        }
        str.append(toTabs(qntTabs) + "if (not " + findString + ") or " + CmdBreak.pythonBreakName + ":\n");
        for (AbstractCommand cmd : dfls) {
            str.append(cmd.genPythonCode(qntTabs + 1) + "\n");
        }

        return str.toString();
    }

    @Override
    public String toString() {
        return "CmdSwitchCase [id=" + id + "]";
    }

}
