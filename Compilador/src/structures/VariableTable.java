package structures;

import java.util.HashMap;

public class VariableTable {
    private HashMap<String, Variable> map;

    public VariableTable() {
        map = new HashMap<String, Variable>();
    }

    public boolean exists(String name) {
        return map.get(name) != null;
    }

    public void add(Variable v) {
        map.put(v.getName(), v);
    }

    public Variable getVariable(String name) {
        return map.get(name);
    }
}
