
class Solution {
    public static int findCatalan(int n) {
        // code here
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    
    public static int solve(int n , int [] dp){
        if(n == 1 || n == 0){
            return 1;
        }
        
        if(dp[n] != -1){
            return dp[n];
        }
        
        int ans = 0;
        for(int i = 0; i < n ; i++){
            ans += solve(i,dp)*solve(n-i-1,dp);
        }
        
        return dp[n] = ans;
    }
}
