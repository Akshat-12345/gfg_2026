class Solution {
    // int n = 0;
    
    static class Dsu{
        int parent [];
        public Dsu(int n){
            parent = new int[n];
            for(int i = 0; i < n ; i++){
                parent[i] = i;
            }
        }

        public int find (int x ){
            if(parent[x] == x){
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public boolean union(int x , int y){
            int parentX = find(x);
            int parentY = find(y);

            if(parentX != parentY){
               parent[y] = x;
            }         
            
            if(parentX == parentY){
                return true;
            }
            
            return false;
        }
    }
    
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        // ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        // for(int i = 0 ; i< V ; i++){
        //     ArrayList<Integer> list = new ArrayList<>();
        //     adj.add(list);
        // }
        
        // for(int i = 0 ; i < edges.length ; i++){
        //     int u =  edges[i][0];
        //     int v = edges[i][1];
        //     adj.get(u).add(v);
        //     adj.get(v).add(u);
        // }
        // n = adj.size();
        // boolean [] vis = new boolean[n];
        
        // for(int i = 0 ; i < n; i++){
        //     if(!vis[i]){
        //         if(bfs(adj,i,vis)){
        //             return true;
        //         }
        //     }
        // }
        // return false;
        
        // int [] parent = new int[n];
   
        // for(int i = 0 ; i < n ;i++){
        //     if(!vis[i]){
        //         parent[i] = -1;
        //         if(dfs(i,adj,vis, parent)){
        //             return true;
        //         }
        //     }
        // }
        // return false;
        
        Dsu d = new Dsu(V);
        
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            if(d.union(u,v)){
                return true;
            }
        }
        return false;
    }
    
    
    

    //  public boolean dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int[] parent) {
    //       vis[i] = true;

    //       for (int neigh : adj.get(i)) {
    //           if (!vis[neigh]) {
    //               parent[neigh] = i;
    //               if (dfs(neigh, adj, vis, parent)) {
    //                   return true;  
    //               }
    //           }
    //           else if (neigh != parent[i]) {
    //               return true;       
    //           }
    //       }
    //       return false;
// }

}