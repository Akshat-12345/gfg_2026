class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        int [][] dp = new int [n + 1][target + 1];
        dp[0][0] = 1;
        
        for(int i = 1; i <= n ; i++){
            for(int j = 0; j <= target ; j++){
                int val = nums[i-1];
                if(j >= val){
                    dp[i][j] = dp[i-1][j - val] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][target];
    }
}