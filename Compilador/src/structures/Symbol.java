package structures;

import Helper.UsefulChar;

public abstract class Symbol {
    protected String name;

    public abstract String genJavaCode(int qntTabs);

    public String toTabs(int qntTabs) {
        return UsefulChar.TAB.repeat(qntTabs);
    }

    public Symbol(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Symbol [name=" + name + "]";
    }

}
