class Solution {
    Integer [] dp;
    public int numberOfWays(int n) {
        // code here
        dp = new Integer[ n +  1];
        
        return solve(n);
    }
    
    public int solve(int n){
        if(n < 0){
            return 0;
        }
        
        if(n == 0){
            return 1;
        }
        
        if(dp[n] != null){
            return dp[n];
        }
        
        int take = solve(n-1);
        int notTake = solve(n-2);
        
        return dp[n] = take + notTake;
    }
};