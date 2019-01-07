package by.azarenka.graph;

import by.azarenka.*;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> implements MyGraph<T> {

    private final int VERTEX_MAX = 100;

    private Vertex<T>[] vertexArray;

    private MyStack stack;

    private int vertexCount = 0;

    private int[][] matrix;

    public Graph() {
        matrix = new int[VERTEX_MAX][VERTEX_MAX];
        for (int i = 0; i < VERTEX_MAX; i++) {
            for (int j = 0; j < VERTEX_MAX; j++) {
                matrix[i][j] = 0;
            }
        }
        vertexArray = new Vertex[VERTEX_MAX];
        stack = new MyStackImpl<>();
    }

    @Override
    public void addVertex(T label) {
        vertexArray[vertexCount] = new Vertex<T>(label, vertexCount);
        vertexCount = vertexCount + 1;
    }


    private void addEdge(int begin, int end) {
        matrix[begin][end] = 1;
        matrix[end][begin] = 0;
    }

    @Override
    public void connect(T from, T to) {
        if (contains(from) && contains(to)) {
            int begin = getIndex(from);
            int end = getIndex(to);
            addEdge(begin, end);
        }
    }

    @Override
    public List<T> getVerticesConnectedTo(T vertex) {
        List<T> list = new ArrayList<T>();
        if (contains(vertex)) {
            int index = getIndex(vertex);
            list = getInWard(index);
            list.addAll(getOutWard(index));
        }
        return list;
    }

    @Override
    public boolean contains(T vertex) {
        if (vertex != null) {
            for (int i = 0; i < vertexCount; i++) {
                if (vertexArray[i].getLabel().equals(vertex)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int size() {
        return vertexCount;
    }

    @Override
    public boolean remove(T vertex) {
        if (vertex != null) {
            if (contains(vertex)) {
                int index = getIndex(vertex);
                for (int i = 0; i < vertexCount; i++) {
                    if (matrix[index][i] == 1) {
                        matrix[index][i] = 0;
                    }
                }
                for (int i = 0; i < vertexCount; i++) {
                    if (matrix[i][index] == 1) {
                        matrix[i][index] = 0;
                    }
                }
                vertexArray[index] = null;
            }
        }
        return false;
    }

    @Override
    public List<T> getInwardEdges(T to) {
        List<T> list = new ArrayList<T>();
        if (contains(to)) {
            int index = getIndex(to);
            list = getInWard(index);
        }
        return list;
    }

    private List<T> getOutWard(int index) {
        List<T> list = new ArrayList<T>();
        for (int i = 0; i < VERTEX_MAX; i++) {
            if (matrix[i][index] == 1) {
                list.add(vertexArray[i].getLabel());
            }
        }
        return list;
    }

    private List<T> getInWard(int index) {
        List<T> list = new ArrayList<T>();
        for (int i = 0; i < VERTEX_MAX; i++) {
            if (matrix[index][i] == 1) {
                list.add(vertexArray[i].getLabel());
            }
        }
        return list;
    }

    @Override
    public List<T> getOutwardEdges(T from) {
        List<T> list = new ArrayList<T>();
        if (contains(from)) {
            int index = getIndex(from);
            list = getOutWard(index);
        }
        return list;
    }

    @Override
    public void dfs(T vertex) {
        int v = getIndex(vertex);
        vertexArray[v].setVisited(true);
        stack.push(v);
        while (!stack.isEmpty()) {
            int adjVertex = getUnvisitedVertex((int) stack.peek());
            if (adjVertex == -1)
                stack.pop();
            else {
                vertexArray[adjVertex].setVisited(true);
                System.out.print(vertexArray[adjVertex].getLabel() + " -> ");
                stack.push(adjVertex);
            }
        }

        for (Vertex vertex1 : vertexArray)
            if (vertex1 != null) {
                vertex1.setVisited(false);
            } else continue;
    }

    @Override
    public void bfs(T vertex) {
        int v = getIndex(vertex);
        vertexArray[v].setVisited(true);
        MyQueue queue = new MyQueueImpl<>(100);
        int index = 0;
        queue.offer(v);
        while (queue.size() > 0) {
            int currentVertex = (int) queue.poll();
            while ((index = getUnvisitedVertex(currentVertex)) != -1) {
                vertexArray[index].setVisited(true);
                System.out.print(vertexArray[index].getLabel() + " -> ");
                queue.offer(index);
            }
        }
    }

    private int getUnvisitedVertex(int vertex) {
        for (int i = 0; i < vertexCount; i++)
            if (matrix[vertex][i] == 1 && vertexArray[i].isVisited() == false)
                return i;

        return -1;
    }

    private int getIndex(T vertex) {
        int index = -1;
        for (int i = 0; i < vertexArray.length; i++) {
            if (vertexArray[i].getLabel().equals(vertex)) {
                index = vertexArray[i].getIndex();
                break;
            }
        }
        return index;
    }
}
