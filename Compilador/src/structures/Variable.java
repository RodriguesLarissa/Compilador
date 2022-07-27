package structures;

public class Variable extends Symbol {
    public static final int INT = 0;
    public static final int DOUBLE = 1;
    public static final int STRING = 2;

    private int type;
    private String value;

    public Variable(String name, int type, String value) {
        super(name);
        this.type = type;
        this.value = value;
    }

    public String genJavaCode(int qntTabs) {
        String str;
        if (type == INT) {
            str = "int ";
        } else if (type == DOUBLE) {
            str = "double ";
        } else {
            str = "String ";
        }

        return super.toTabs(qntTabs) + str + " " + super.name + ";";
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTypeText() {
        switch (this.type) {
            case 0:
                return "int";
            case 1:
                return "double";
            case 2:
                return "String";
            default:
                return "not recognized type";
        }
    }

    @Override
    public String toString() {
        return "Variable [name=" + name + ",type=" + type + ", value=" + value + "]";
    }

}
