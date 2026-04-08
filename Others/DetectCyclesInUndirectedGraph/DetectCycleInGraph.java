package Others.DetectCyclesInUndirectedGraph;

import java.util.*;

class DetectCycleInGraph {
    public boolean checkForCycle(int src, int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[src] = true;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<Integer, Integer>(src, -1));
        while (!q.isEmpty()) {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();
            for (int adjacentNode : adj.get(node)) {
                if (vis[adjacentNode] == false) {
                    vis[adjacentNode] = true;
                    q.add(new Pair(adjacentNode, node));
                } else if (parent != adjacentNode) {
                    return true; // because there is another path to the node
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            vis[i] = false;
        }
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                if (checkForCycle(i, V, adj, vis))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycleInGraph detectCycleInGraph = new DetectCycleInGraph();

        // Test Case 1: Graph with a cycle
        // Graph structure:
        // 0 - 1
        // | |
        // 2 - 3
        // |
        // 4
        System.out.println("=== Test Case 1: Graph with a cycle ===");
        int V1 = 5;
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        for (int i = 0; i < V1; i++) {
            adj1.add(new ArrayList<>());
        }
        // Adding edges to create a cycle: 0 -> 1 -> 3 -> 2 -> 0
        adj1.get(0).add(1);
        adj1.get(0).add(2);
        adj1.get(1).add(0);
        adj1.get(1).add(3);
        adj1.get(2).add(0);
        adj1.get(2).add(3);
        adj1.get(3).add(1);
        adj1.get(3).add(2);
        adj1.get(3).add(4);
        adj1.get(4).add(3);

        System.out.println("Graph 1 has cycle: " + detectCycleInGraph.isCycle(V1, adj1));
        System.out.println();

        // Test Case 2: Graph without a cycle (Tree structure)
        // Graph structure:
        // 0 - 1 - 2
        // |
        // 3 - 4
        System.out.println("=== Test Case 2: Graph without a cycle (Tree) ===");
        int V2 = 5;
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < V2; i++) {
            adj2.add(new ArrayList<>());
        }
        // Adding edges (no cycle)
        adj2.get(0).add(1);
        adj2.get(1).add(0);
        adj2.get(1).add(2);
        adj2.get(1).add(3);
        adj2.get(2).add(1);
        adj2.get(3).add(1);
        adj2.get(3).add(4);
        adj2.get(4).add(3);

        System.out.println("Graph 2 has cycle: " + detectCycleInGraph.isCycle(V2, adj2));
        System.out.println();

        // Test Case 3: Graph with multiple cycles
        System.out.println("=== Test Case 3: Graph with multiple cycles ===");
        int V3 = 4;
        ArrayList<ArrayList<Integer>> adj3 = new ArrayList<>();
        for (int i = 0; i < V3; i++) {
            adj3.add(new ArrayList<>());
        }
        // Complete graph - multiple cycles
        adj3.get(0).add(1);
        adj3.get(0).add(2);
        adj3.get(0).add(3);
        adj3.get(1).add(0);
        adj3.get(1).add(2);
        adj3.get(1).add(3);
        adj3.get(2).add(0);
        adj3.get(2).add(1);
        adj3.get(2).add(3);
        adj3.get(3).add(0);
        adj3.get(3).add(1);
        adj3.get(3).add(2);

        System.out.println("Graph 3 has cycle: " + detectCycleInGraph.isCycle(V3, adj3));
        System.out.println();

        // Test Case 4: Disconnected graph with cycle in one component
        System.out.println("=== Test Case 4: Disconnected graph ===");
        int V4 = 6;
        ArrayList<ArrayList<Integer>> adj4 = new ArrayList<>();
        for (int i = 0; i < V4; i++) {
            adj4.add(new ArrayList<>());
        }
        // Component 1: has cycle (0-1-2-0)
        adj4.get(0).add(1);
        adj4.get(0).add(2);
        adj4.get(1).add(0);
        adj4.get(1).add(2);
        adj4.get(2).add(0);
        adj4.get(2).add(1);
        // Component 2: no cycle (3-4-5)
        adj4.get(3).add(4);
        adj4.get(4).add(3);
        adj4.get(4).add(5);
        adj4.get(5).add(4);

        System.out.println("Graph 4 has cycle: " + detectCycleInGraph.isCycle(V4, adj4));
    }
}
