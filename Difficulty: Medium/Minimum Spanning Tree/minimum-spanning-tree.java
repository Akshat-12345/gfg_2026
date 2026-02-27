import java.util.*;

class Solution {
    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int spanningTree(int V, int[][] edges) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        boolean[] visited = new boolean[V];

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.weight - b.weight);


        pq.add(new Pair(0, 0));

        int sum = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node;
            int wt = cur.weight;

            if (visited[node]) continue;

            visited[node] = true;
            sum += wt;

            for (Pair nbr : adj.get(node)) {
                if (!visited[nbr.node]) {
                    pq.add(new Pair(nbr.node, nbr.weight));
                }
            }
        }

        return sum;
    }
}

