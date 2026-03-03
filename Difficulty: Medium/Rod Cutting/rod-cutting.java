class Solution {
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        
        int [][] dp = new int[n+1][n+1];
        
        for(int i = 1; i <= n ;i++){
            for(int j = 1; j <= n ;j++){
                 int w = price[i-1];
                 if(i <= j){
                     dp[i][j] = Math.max(w + dp[i][j-i],dp[i-1][j]);
                 }else{
                     dp[i][j] = dp[i-1][j];
                 }
            }
        }
        
        return dp[n][n];
    }
}