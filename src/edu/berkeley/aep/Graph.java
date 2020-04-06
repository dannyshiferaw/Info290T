package edu.berkeley.aep;

import java.util.*;

// understands how to represent connections between entities
public class Graph {

    Map<String, Set<String>> nodes;

    public Graph() {
        nodes = new HashMap<>();
    }

    public Graph(List<List<String>> edges) {
        this();
        edges.forEach(this::addEdge);
    }

    public void addNode(String node) {
        if (!(nodes.containsKey(node))) {
            nodes.put(node, new HashSet<>());
        }
    }

    public void addEdge(List<String> edge) {
        assert(edge.size() == 2);
        String start = edge.get(0);
        String destination = edge.get(1);

        if (!(nodes.containsKey(start))) {
            addNode(start);
        }
        nodes.get(start).add(destination);
    }

    public Set<String> getNeighbours(String node) {
        return nodes.getOrDefault(node, new HashSet<>());
    }

    public Set<String> getNodes() {
        return nodes.keySet();
    }


}
