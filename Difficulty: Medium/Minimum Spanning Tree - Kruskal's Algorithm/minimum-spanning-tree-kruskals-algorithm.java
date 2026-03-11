// User function Template for Java
class Solution {
    static class DSU{
        int [] parent;
        int [] rank;
        
        public DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0 ; i < n ; i++){
                parent[i] = i;
            }
        }
        
        public int find(int x){
            if(parent[x] == x){
                return x;
            }
            return parent[x] = find(parent[x]);
        }
        
        public void union(int x, int y){
            int parentX = find(x);
            int parentY = find(y);
            
            if(parentX == parentY){
                return;
            }
            
            if(rank[parentX] > rank[parentY]){
                parent[parentY] = parentX;
            }
            else if(rank[parentX] <  rank[parentY]){
                parent[parentX] = parentY;
            }else{
                parent[parentY] = parentX;
                rank[parentX]++;
            }
            
        }
    }
    
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        int n = edges.length;
        
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));
        DSU d = new DSU(V);
        int total = 0;
        
        for(int i = 0 ; i< n ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            
            int parentU = d.find(u);
            int parentV = d.find(v);
            
            if(parentU != parentV){
                d.union(u,v);
                total += w;
            }
        }
        
        return total;
    }
}
