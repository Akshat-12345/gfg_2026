class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i< edges.length ; i++){
            int u = edges[i][0];
            int v =  edges[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int dist = 0;
        
        int [] maxDist = new int [V];
        boolean [] vis = new boolean[V];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;
        maxDist[src] = 0;
        
        
        while(!q.isEmpty()){
            
            int size = q.size();
            dist++;
            
            while(size > 0){
                int curr = q.remove();
                
                for(int i = 0 ; i < adj.get(curr).size() ; i++){
                    int element = adj.get(curr).get(i);
                    if(vis[element] == false){
                        vis[element] = true;
                        q.add(element);
                        maxDist[element] = dist;
                    }
                    
                }
                
                size--;
            }
            
        }
        
        for(int i = 0 ; i < vis.length ; i++){
            if(vis[i] == false){
                maxDist[i] = -1;
            }
        }
        return maxDist;
        
    }
}
