package bsu.petraschka.Classes;

public class Vertex2 {
    private char label;  // метка А например
    public boolean wasVisited;

    public Vertex2(final char label) {
        this.label = label;
        wasVisited = false;
    }

    public char getLabel() {
        return this.label;
    }

    public boolean isWasVisited() {
        return this.wasVisited;
    }

    public void setWasVisited(final boolean wasVisited) {
        this.wasVisited = wasVisited;
    }
}
