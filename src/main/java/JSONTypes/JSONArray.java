package main.java.JSONTypes;

import java.util.ArrayList;

import main.java.JSONElementVisitor;

public class JSONArray implements JSONElement {

    private ArrayList<JSONElement> items;

    public JSONArray() {
        this.items = new ArrayList<JSONElement>();
    }

    public JSONArray(ArrayList<JSONElement> items) {
        this.items = items;
    }

    public void accept(JSONElementVisitor visitor) {
        visitor.visit(this);
    }

    public ArrayList<JSONElement> getItems() {
        return items;
    }

    @Override
    public boolean equals(JSONElement other) {
        return (other instanceof JSONArray) && ((JSONArray) other).items.equals(items);
    }

    public void add(JSONElement element) {
        items.add(element);
    }
}