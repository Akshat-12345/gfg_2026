// User function Template for Java
class Solution {
    class pair{
        int to;
        int wt;
        public pair(int to , int wt){
            this.to = to;
            this.wt = wt;
        }
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        int indegree[] = new int[V];
        for (int i = 0; i < edges.length ; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new pair(v,wt));
            indegree[v]++;
        }
    
        ArrayList <Integer> result = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
            
        }
        
        while (!q.isEmpty()) {
            
            int curr = q.poll();
            result.add(curr);
            
            for(pair x : adj.get(curr)) {
                int t = x.to;
                indegree[t]--;
                
                if(indegree[t] == 0){
                    q.add(t);
                }
            }
        }
        
        
        int dist[] = new int[V];
        Arrays.fill(dist, (int)1e9);
        dist[0] = 0;  


        for (int node : result) {
            if (dist[node] != (int)1e9) {
                for (pair x : adj.get(node)) {
                    int v = x.to;
                    int wt = x.wt;
                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == (int)1e9) {
                dist[i] = -1;
            }
        }

        return dist;
    
    }
}