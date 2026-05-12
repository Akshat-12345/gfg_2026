class Solution {
    // int [][] dp;
    // public int cutRod(int[] price) {
    //     // code here
    //     int n = price.length;
    //     dp = new int [n + 1][n + 1];
        
    //     for(int i = 0; i <= n ; i++){
    //         Arrays.fill(dp[i] , -1);
    //     }
        
    //     int ans = solve(0 , price , n );
        
    //     if(ans == Integer.MIN_VALUE){
    //         return -1;
    //     }
        
    //     return ans;
    // }
    
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

    
    // public int solve(int i , int [] prices , int len){
    //     int n = prices.length;
    //     if(i == n ){
    //         if(len == 0){
    //             return 0;
    //         }
    //         return Integer.MIN_VALUE;
    //     }
        
    //     if(len == 0){
    //         return 0;
    //     }
        
    //     if(dp[i][len] != -1){
    //         return dp[i][len];
    //     }
        
    //     int take = Integer.MIN_VALUE;
        
    //     if(len >= (i+1) && solve( i , prices , len - (i + 1)) != Integer.MIN_VALUE){
    //         take = prices[i] + solve(i, prices, len - (i+1));
    //     }
        
    //     int notTake = solve(i + 1, prices, len);
        
    //     return dp[i][len] = Math.max(take,notTake);
    // }
}