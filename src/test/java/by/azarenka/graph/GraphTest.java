package by.azarenka.graph;

import by.azarenka.MyGraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GraphTest {

    private MyGraph<Integer> graph = new Graph<Integer>();

    private void assertMatch(int actual, int expected) {
        assertThat(actual).isEqualTo(expected);
    }

    private void assertMatch(List<Integer> expected, List<Integer> actual) {
        assertThat(actual).isEqualTo(expected);
    }

    @Before
    public void testSetUp() throws Exception {
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);

        graph.connect(1, 2);
        graph.connect(2, 3);
        graph.connect(3, 4);
        graph.connect(3, 6);
    }

    @After
    public void testTearDown() throws Exception {
        graph = new Graph<>();
    }

    @Test
    public void testAddVertex() {
        graph.addVertex(8);
        assertMatch(7, graph.size());
    }

    @Test
    public void testConnect() {
        graph.connect(2, 6);
        assertMatch(Arrays.asList(3, 6), graph.getInwardEdges(2));
    }

    @Test
    public void testGetVerticesConnectedTo() {
        assertMatch(Arrays.asList(4, 6, 2), graph.getVerticesConnectedTo(3));
    }

    @Test
    public void testGetVerticesConnectedToNotFound() {
        assertMatch(Arrays.asList(), graph.getVerticesConnectedTo(10));
    }

    @Test
    public void testGetVerticesConnectedToIsNull() {
        assertMatch(Arrays.asList(),graph.getVerticesConnectedTo(null));
    }

    @Test
    public void testContains() {
        assertThat(true).isEqualTo(graph.contains(3));
    }

    @Test
    public void testContainsIsFalse() {
        assertThat(false).isEqualTo(graph.contains(10));
    }

    @Test
    public void testRemove() {
        graph.remove(3);
        assertMatch(6, graph.size());
    }

    @Test
    public void testGetOutwardEdges() {
        assertMatch(Arrays.asList(1),graph.getOutwardEdges(2));
    }

    @Test
     public void testGetOutwardEdgesNotFound() {
        assertMatch(Arrays.asList(),graph.getOutwardEdges(10));
    }

    @Test
    public void testGetOutwardEdgesIsNull() {
        assertMatch(Arrays.asList(),graph.getOutwardEdges(null));
    }

    @Test
    public void testGetInwardEdges() {
        assertMatch(Arrays.asList(3),graph.getInwardEdges(2));
    }

    @Test
    public void testGetInwardEdgesNotFound() {
        assertMatch(Arrays.asList(),graph.getInwardEdges(10));
    }

    @Test
    public void testGetInwardEdgesIsNull() {
        assertMatch(Arrays.asList(),graph.getInwardEdges(null));
    }

    @Test
    public void testBfs(){
        graph.addVertex(8);
        graph.connect(6,8);
        graph.bfs(1);
    }

    @Test
    public void testDfs(){
        graph.addVertex(8);
        graph.connect(6,8);
        graph.dfs(1);
    }
}
