package ast;

import Helper.UsefulChar;

public abstract class AbstractCommand {
    public abstract String genJavaCode(int qntTabs);

    public abstract String genPythonCode(int qntTabs);

    public String toTabs(int qntTabs) {
        return UsefulChar.TAB.repeat(qntTabs);
    }
}
