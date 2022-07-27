package ast;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import structures.Variable;
import structures.VariableTable;

public class Program {
    private VariableTable varTable;
    private ArrayList<AbstractCommand> cmds;

    public void generateJavaFile() {
        StringBuilder finalFile = new StringBuilder();
        finalFile.append("import java.util.Scanner;\n");
        finalFile.append("public class MainClass {\n");
        finalFile.append("  public static void main(String args[]){\n ");
        finalFile.append("      Scanner scan = new Scanner(System.in);\n");

        for (Variable var : varTable.getAll()) {
            finalFile.append(var.genJavaCode() + "\n");
        }
        for (AbstractCommand cmd : cmds) {
            finalFile.append(cmd.genJavaCode() + "\n");
        }
        finalFile.append("  }\n");
        finalFile.append("}");

        try {
            FileWriter fr = new FileWriter(new File("MainClass.java"));
            fr.write(finalFile.toString());
            fr.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setVarTable(VariableTable varTable) {
        this.varTable = varTable;
    }

    public void setCmds(ArrayList<AbstractCommand> cmds) {
        this.cmds = cmds;
    }

}
