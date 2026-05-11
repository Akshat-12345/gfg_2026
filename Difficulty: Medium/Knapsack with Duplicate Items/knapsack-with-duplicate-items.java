class Solution {
    Integer [][] dp;
    
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
        int m = wt.length;
        dp = new Integer [n+1][capacity + 1];
        
        return solve(0,val,wt,capacity);
    }
    
    public int solve(int i , int [] val , int [] wt , int w){
        int n = val.length;
        
        if(i == n || w <= 0){
            return 0;
        }
        
        if(dp[i][w] != null){
            return dp[i][w];
        }
        
        int take = Integer.MIN_VALUE;
        if(wt[i] <= w){
            take = val[i] + solve(i,val,wt,w - wt[i]);
        }
        
        int notTake = solve(i+1, val , wt , w);
        
        return dp[i][w] = Math.max(take,notTake);
    }
    
}