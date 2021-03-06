package main.java;

import main.java.JSONTypes.JSONElement;
import main.java.Printer.DefaultWriter;
import main.java.Printer.JSONBuilder;

public class Main {
    public static void main(String[] args) {
        testJacey();
    }

    private static void testJacey() {
        DefaultWriter writy = (DefaultWriter) tryBuilder(new DefaultWriter());
        String json = writy.getOutpuString();
        System.out.println(json);

        try {
            System.out.println(Lexer.lex(json));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Jacey bb = new Jacey();

        JSONElement tree = null;
        try {
            tree = bb.fromString(json);
            String print = bb.print(tree);
            System.out.println(print);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static JSONBuilder tryBuilder(JSONBuilder buildy) {

        buildy.startObject();
        buildy.putKey("\"array\"");

        buildy.startArray();
        buildy.putNull();
        buildy.putString("\"hello\"");

        buildy.startArray();
        buildy.putFalse();
        buildy.putTrue();
        buildy.putNumber("666.123E-12");
        buildy.endArray();

        buildy.startObject();
        buildy.putKey("\"x\"");
        buildy.putNumber("-42.23");
        buildy.putKey("\"y\"");
        buildy.putNumber("69e2");
        buildy.endObject();

        buildy.endArray();

        buildy.putKey("\"type\"");
        buildy.putString("\"kurwa\"");

        buildy.endObject();
        return buildy;
    }
}
