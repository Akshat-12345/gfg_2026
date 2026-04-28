class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        
        Integer [][] dp = new Integer [n + 1][W + 1];
        return solve(0 , W , val, wt, dp);
        
    }
    
    public int solve( int i , int w , int [] val , int [] wt, Integer [][] dp){
        int n = val.length;
        
        if(i == n || w == 0){
            return 0;
        }
        
        if(dp[i][w] != null){
            return dp[i][w];
        }
        
        int take = 0;
        if(wt[i] <= w){
            take = val[i] +  solve(i + 1 , w - wt[i], val , wt , dp);
        }
        
        int notTake = solve(i + 1 , w, val , wt , dp);
        
        return dp[i][w] = Math.max(take,notTake);
    }
}
