class Solution {
    public static int longestBitonicSequence(int n, int[] nums) {
        // code here
        int [][] dp = new int [n][2];
        
        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
            dp[i][1] = 0;
        }
        
        int ans = 0;
        
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(nums[j] < nums[i]){
                   dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                }
                
                
                if(nums[j] > nums[i]){
                    if(dp[j][0] > 1){
                        dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);  // d tak increaseong abb 3 se decrease toh hum increasing +1 kardena
                    }
                    
                    if(dp[j][1] > 0){
                        dp[i][1] = Math.max(dp[i][1] , dp[j][1] + 1);
                    }
                }
                
                
            }
            ans = Math.max(ans,dp[i][1]);
        }
        
        return ans;
        
    }
}
