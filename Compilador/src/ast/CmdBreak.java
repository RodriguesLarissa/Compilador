package ast;

public class CmdBreak extends AbstractCommand {

    public CmdBreak() {
    }

    public static final String pythonBreakName = "BPLCV1";

    @Override
    public String genJavaCode(int qntTabs) {
        return toTabs(qntTabs) + "break;";
    }

    @Override
    public String genPythonCode(int qntTabs) {
        return toTabs(qntTabs) + pythonBreakName + " = False";
    }
}
