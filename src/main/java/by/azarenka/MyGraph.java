package by.azarenka;

import java.util.List;

public interface MyGraph<T> {
    /**
     * Appends vertex and ups count on the one.
     *
     * @param label
     */
    void addVertex(T label);

    /**
     * Creates a connection between two vertices.
     *
     * @param from
     * @param to
     */
    void connect(T from, T to);

    /**
     * Returns all vertices connected to the specified vertex.
     *
     * @param vertex
     * @return
     */
    List<T> getVerticesConnectedTo(T vertex);

    /**
     * Checks graph to contains element
     *
     * @param vertex
     * @return if contains <code>true</code>
     */
    boolean contains(T vertex);

    /**
     * Returns count elements of graph
     *
     * @return
     */
    int size();

    /**
     * Removes vertex and connections between related to her vertices.
     *
     * @param vertex
     * @return
     */
    boolean remove(T vertex);

    /**
     * Returns the list of vertices that a connects to a specified vertex.
     *
     * @param to
     * @return
     */
    List<T> getInwardEdges(T to);

    /**
     * Returns the list of vertices that a specified vertex connects to.
     *
     * @param from
     * @return
     */
    List<T> getOutwardEdges(T from);

    /**
     * go-round in the depth
     *
     * @param vertex
     */
    void dfs(T vertex);

    /**
     * Go-round in the width
     *
     * @param vertex
     */
    void bfs(T vertex);
}
