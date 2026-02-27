// User function template for JAVA

class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here
        int n= dist.length;
        int INF = 100000000;
        
        for(int inter = 0; inter < n ; inter++){
            for(int src = 0; src < n ; src++){
                
                for(int dest = 0 ; dest < n ; dest++){
                    if(dist[src][inter] != INF && dist[inter][dest] != INF){
                        dist[src][dest] = Math.min(dist[src][dest],dist[src][inter] + dist[inter][dest]);
                    }
                }
            }
        }
    }
}