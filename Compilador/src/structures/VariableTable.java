package structures;

import java.util.ArrayList;
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

    public ArrayList<Variable> getAll() {
        ArrayList<Variable> xs = new ArrayList<Variable>();
        for (Variable var : map.values()) {
            xs.add(var);
        }
        return xs;
    }
}
