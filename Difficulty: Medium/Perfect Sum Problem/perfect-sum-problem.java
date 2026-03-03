class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int n =  nums.length;
        int [][] dp = new int [n+1][target+1];
        dp[0][0] = 1;
        
        for(int i = 1 ; i < n + 1; i++){
            for(int j = 0 ; j < dp[0].length ;j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j]; 
                }
            }
        }
        
        return dp[n][target];
    }
}