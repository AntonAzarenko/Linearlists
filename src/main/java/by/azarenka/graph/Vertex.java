package by.azarenka.graph;

public class Vertex<T> {

    private T label;

    private boolean isVisited;

    private int index;

    public Vertex(T label, int index) {
        this.label = label;
        this.index = index;
        this.isVisited = false;
    }

    public int getIndex() {
        return index;
    }

    public T getLabel() {
        return label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
