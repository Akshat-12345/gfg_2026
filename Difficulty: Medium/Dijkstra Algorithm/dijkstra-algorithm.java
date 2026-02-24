class Solution {
    class pair{
        int to;
        int wt;
        public pair(int to, int wt){
            this.to = to;
            this.wt = wt;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        
        for(int i = 0; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            
            adj.get(u).add(new pair(v,w));
            adj.get(v).add(new pair(u,w));
        }
        
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new pair(src,0));
        int [] distance = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src] = 0;
        
        while(!pq.isEmpty()){
            pair curr = pq.poll();
            int node = curr.to;
            int dist = curr.wt;
            
            
            for(int i = 0 ; i < adj.get(node).size() ; i++){
                pair x = adj.get(node).get(i);
                if(distance[x.to] == Integer.MAX_VALUE){
                    distance[x.to] = x.wt + dist;
                    pq.add(new pair(x.to,distance[x.to]));
                }else if (distance[x.to] > x.wt + dist){
                    distance[x.to] = x.wt + dist;
                    pq.add(new pair(x.to,distance[x.to]));
                }
            }
            
        }
        
        return distance;
    }
}