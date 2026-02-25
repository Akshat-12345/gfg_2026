class Solution {
    // Function to return the minimum cost to react at bottom
    // right cell from top left cell.
    
    class pair {
        int from;
        int to;
        int wt;

        public pair(int from,int to, int wt) {
            this.from = from;
            this.to = to;
            this.wt = wt;
        }

    }
    
    int [] rows = {-1,1,0,0};
    int [] cols = {0,0,-1,1};
    
    public int minimumCostPath(int[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        
        int [][] minCost = new int [n][m];
        minCost[0][0] = grid[0][0];
        
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(minCost[i],Integer.MAX_VALUE);
        }
        
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> (a.wt - b.wt));
        pq.add(new pair(0,0,grid[0][0]));
        
        while(!pq.isEmpty()){
            pair curr = pq.poll();
            int currRow = curr.from;
            int currCol = curr.to;
            int currWt = curr.wt;
            
            for(int i = 0; i< 4; i++){
                int row = currRow + rows[i];
                int col = currCol + cols[i];
                
                if(row >= 0 && row < n && col >= 0 && col < m ){
                    if(currWt + grid[row][col] < minCost[row][col]){
                        minCost[row][col] = currWt + grid[row][col];
                        pq.add(new pair(row,col,minCost[row][col]));
                    }
                }
            }
            
        }
        
        return minCost[n-1][m-1];
    }
}