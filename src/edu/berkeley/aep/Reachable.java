package edu.berkeley.aep;

import java.util.HashSet;
import java.util.Set;

// understands how tr
public class Reachable {
    Graph graph;
    Set<String> seen;
    Reachable(Graph graph) {
        this.graph = graph;
        seen = new HashSet<>();
    }

    public boolean canReach(String start, String destination) {
        seen.clear();
        return dfs(start, destination);
    }

    public boolean dfs(String curr, String dest) {
        if (curr.equals(dest)) {
            return true;
        }
        seen.add(curr);
        for (String neighbour: graph.getNeighbours(curr)) {
            boolean isSeen = seen.contains(neighbour);
            if (!isSeen && dfs(neighbour, dest)) {
                return true;
            }
        }
        return false;
    }
}
