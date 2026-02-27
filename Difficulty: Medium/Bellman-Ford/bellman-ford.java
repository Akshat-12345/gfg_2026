// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int [] dist = new int[V];
        int INF = 100000000;
        Arrays.fill(dist,INF);
        dist[src] = 0;
        
        int i = 0;
        while(i < V-1){
            for(int j = 0 ; j < edges.length ; j++){
                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];
                
                if(dist[u] == INF){
                    continue;
                }else{
                    int calcDist = dist[u] + w;
                    if(calcDist < dist[v]){
                        dist[v] = calcDist;
                    }
                }
                
            }
            i++;
        }
        
        
        for(int j = 0 ; j < edges.length ; j++){
            int u = edges[j][0];
            int v = edges[j][1];
            int w = edges[j][2];
            if(dist[u] == INF){
                    continue;
            }else{
                int calcDist = dist[u] + w;
                if(calcDist < dist[v]){
                    int [] arr = {-1};
                    return arr;
                }
            }
        }
        
        
        
        return dist;
    }
}
