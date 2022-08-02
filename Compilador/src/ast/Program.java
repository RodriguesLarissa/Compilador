package ast;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import Helper.UsefulChar;
import structures.Variable;
import structures.VariableTable;

public class Program {
    private VariableTable varTable;
    private ArrayList<AbstractCommand> cmds;

    public void generateJavaFile() {
        StringBuilder finalFile = new StringBuilder();
        finalFile.append("import java.util.Scanner;\n");
        finalFile.append("public class MainClass {\n");
        finalFile.append(toTabs(1) + "public static void main(String args[]){\n ");
        finalFile.append(toTabs(2) + "Scanner scan = new Scanner(System.in);\n\n");

        for (Variable var : varTable.getAll()) {
            finalFile.append(var.genJavaCode(2) + "\n");
        }
        finalFile.append("\n");
        for (AbstractCommand cmd : cmds) {
            finalFile.append(cmd.genJavaCode(2) + "\n");
        }
        finalFile.append("\n" + toTabs(2) + "scan.close();\n");
        finalFile.append(toTabs(1) + "}\n");
        finalFile.append("}");

        try {
            FileWriter fr = new FileWriter(new File("MainClass.java"));
            fr.write(finalFile.toString());
            fr.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void generatePythonFile() {
        StringBuilder finalFile = new StringBuilder();
        for (Variable var : varTable.getAll()) {
            finalFile.append(var.genPythonCode(0) + "\n");
        }
        finalFile.append("\n");
        for (AbstractCommand cmd : cmds) {
            finalFile.append(cmd.genPythonCode(0) + "\n");
        }
        try {
            FileWriter fr = new FileWriter(new File("Main.py"));
            fr.write(finalFile.toString());
            fr.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<AbstractCommand> getCmds() {
        return cmds;
    }

    public void setVarTable(VariableTable varTable) {
        this.varTable = varTable;
    }

    public void setCmds(ArrayList<AbstractCommand> cmds) {
        this.cmds = cmds;
    }

    private String toTabs(int qntTabs) {
        return UsefulChar.TAB.repeat(qntTabs);
    }

}
