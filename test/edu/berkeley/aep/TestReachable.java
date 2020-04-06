package edu.berkeley.aep;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestReachable {

    static Graph graph;
    Reachable reachable;

    @BeforeClass
    public static void constructGraph() {
        List<List<String>> edges = new ArrayList<>();
        edges.add(Arrays.asList("h", "b"));
        edges.add(Arrays.asList("b", "a"));
        edges.add(Arrays.asList("b", "c"));
        edges.add(Arrays.asList("e", "b"));
        edges.add(Arrays.asList("c", "e"));
        edges.add(Arrays.asList("c", "e"));
        edges.add(Arrays.asList("c", "d"));
        edges.add(Arrays.asList("d", "e"));
        edges.add(Arrays.asList("a", "f"));
        graph = new Graph(edges);
        graph.addNode("d");
    }

    @Before
    public void setup() {
        reachable = new Reachable(graph);
    }

    @Test
    public void shouldBeAbleToReachSelf() {
        assertTrue(reachable.canReach("a", "a"));
        assertTrue(reachable.canReach("b", "b"));
        assertTrue(reachable.canReach("c", "c"));
        assertTrue(reachable.canReach("e", "e"));
    }

    @Test
    public void shouldBeAbleToReachNodeDFromH() {
        assertTrue(reachable.canReach("h", "d"));
    }


    @Test
    public void shouldBeAbleToReachFFromFromE() {
        assertTrue(reachable.canReach("e", "f"));
    }

    @Test
    public void nodeGShouldBeUnreachableFromEveryWhereElse() {
        assertFalse(reachable.canReach("a", "g"));
        assertFalse(reachable.canReach("b", "g"));
        assertFalse(reachable.canReach("c", "g"));
        assertFalse(reachable.canReach("e", "g"));
    }

    @Test
    public void shouldNotBeAbleToReachAnyNodeFromNodeG() {
        assertFalse(reachable.canReach("g", "a"));
        assertFalse(reachable.canReach("g", "b"));
        assertFalse(reachable.canReach("g", "c"));
        assertFalse(reachable.canReach("g", "e"));
    }


}
