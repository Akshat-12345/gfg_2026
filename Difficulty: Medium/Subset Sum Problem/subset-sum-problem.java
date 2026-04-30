class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        boolean [][] dp = new  boolean [n + 1][sum + 1];
        
        for(int i = 0 ; i <= n ; i++){
            dp[i][0] = true;
        }
        
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= sum ; j++){
                int val = arr[i-1];
                
                if( j >= val){
                    dp[i][j] = dp[i-1][j- val] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][sum];
    }
}