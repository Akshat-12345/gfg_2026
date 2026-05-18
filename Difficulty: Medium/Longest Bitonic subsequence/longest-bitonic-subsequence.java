class Solution {
    public static int longestBitonicSequence(int n, int[] nums) {
        // code here

        int [] res = new int [n];
        Arrays.fill(res,1);

        for(int i = 1 ; i < n ; i++){
            for(int j = i - 1 ; j >= 0 ; j--){
                if(nums[i] > nums[j]){
                   res[i] = Math.max(res[i],res[j] + 1);
                }
            }
        }
        
        int [] res1 = new int [n];
        Arrays.fill(res1,1);
        
        for(int i = n - 2 ; i >= 0 ; i--){
            for(int j = i + 1 ; j < n ; j++){
                if(nums[i] > nums[j]){
                   res1[i] = Math.max(res1[i],res1[j] + 1);
                }
            }
        }

        int maxVal = 0;
        for(int i = 0 ; i < n ; i++){
            if (res[i] > 1 && res1[i] > 1) {
                int val = res[i] + res1[i] - 1;
                maxVal = Math.max(maxVal, val);
            }
        }
        
        return maxVal;
    }
    
    
    
    // public int solve(int i , int prev , int [] nums, Integer [][] dp,int state){
    //     int n = nums.length;

    //     if(i == n){
    //         return 0;
    //     }

    //     if(dp[i][prev + 1][state] != null){
    //         return dp[i][prev + 1][state];
    //     }
        
    //     int take = 0;
        
    //     if(state == 0){
    //         if(prev == -1 || nums[i] > nums[prev]){
    //             take = 1 + solve(i + 1 , i, nums, dp, state);
    //         }
    //     }else{
    //         if(prev == -1 || nums[i] < nums[prev]){
    //             take = 1 + solve(i + 1 , i, nums, dp , state);
    //         }
    //     }

    //     int notTake = solve(i + 1, prev , nums , dp,state);

    //     return dp[i][prev + 1][state] = Math.max(take , notTake);

    // }
}
