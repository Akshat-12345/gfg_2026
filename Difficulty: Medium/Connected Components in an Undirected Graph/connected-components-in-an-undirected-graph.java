class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0 ; i< V ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length ; i++ ){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean [] vis = new boolean[V];
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        
        for(int i = 0; i < V ; i++){
            
            if(!vis[i]){
                ArrayList<Integer> list = new ArrayList<>();
                dfs(i,adj,vis,list);
                arr.add(list);
            }
        
        }
        
        return arr;
    }
    
    // public void bfs(int i , ArrayList<ArrayList<Integer>> adj, boolean [] vis , ArrayList<Integer> list){
        
    //     Queue<Integer> q = new LinkedList<>();
    //     q.add(i);
    //     list.add(i);
    //     vis[i] = true;
        
    //     while(!q.isEmpty()){
    //         int node = q.remove();
    //         for(int j = 0 ; j < adj.get(node).size() ; j++){
    //             int curr = adj.get(node).get(j);
    //             if(!vis[curr]){
    //                 q.add(curr);
    //                 list.add(curr);
    //                 vis[curr] = true;
    //             }
    //         }
    //     }
    // }
    
    public void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> list) {
        vis[i] = true;
        list.add(i);
    
        for (int j = 0; j < adj.get(i).size(); j++) {
            int curr = adj.get(i).get(j);
            if (!vis[curr]) {
                dfs(curr, adj, vis, list);
            }
        }
    }

}