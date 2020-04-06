package edu.berkeley.aep;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class TestGraph {

    static List<List<String>> edges;

    @BeforeClass
    public static void setup() {
        edges = new ArrayList<>();
        edges.add(Arrays.asList("h", "b"));
        edges.add(Arrays.asList("b", "a"));
        edges.add(Arrays.asList("b", "c"));
        edges.add(Arrays.asList("e", "b"));
        edges.add(Arrays.asList("c", "e"));
        edges.add(Arrays.asList("c", "e"));
        edges.add(Arrays.asList("c", "d"));
        edges.add(Arrays.asList("d", "e"));
        edges.add(Arrays.asList("a", "f"));
    }

    @AfterClass
    public static void cleanup() {
        edges.clear();
    }

    @Test
    public void shouldBeAbleToAddEdges() {
        Graph graph = new Graph();
        edges.forEach(graph::addEdge);

        assertEquals(graph.getNeighbours("h"), Collections.singleton("b"));
        assertEquals(graph.getNeighbours("b"), new HashSet<>(Arrays.asList("a", "c")));
        assertEquals(graph.getNeighbours("c"), new HashSet<>(Arrays.asList("e", "d")));
    }

    @Test
    public void shouldBeAbleToConstructGraphFromListOfEdges() {
        Graph graph = new Graph(edges);

        assertEquals(graph.getNeighbours("h"), Collections.singleton("b"));
        assertEquals(graph.getNeighbours("b"), new HashSet<>(Arrays.asList("a", "c")));
        assertEquals(graph.getNeighbours("c"), new HashSet<>(Arrays.asList("e", "d")));
    }

    @Test
    public void shouldBeAbleToAddNodes() {
        Graph graph = new Graph();
        List<String> nodes = Arrays.asList("b", "c", "e", "h");
        nodes.forEach(graph::addNode);

        List<String> actual = new ArrayList<>(graph.getNodes());
        Collections.sort(actual);
        assertEquals(nodes, actual);
    }
}
