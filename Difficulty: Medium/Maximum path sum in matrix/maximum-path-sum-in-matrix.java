// User function Template for Java
class Solution {
    Integer [][] dp;
    public int maximumPath(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        dp = new Integer [n][m];
        
        int ans = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < m ; i++){
            ans = Math.max(ans,solve(0,i,mat));
        }
        
        return ans;
    }
    
    public int solve(int i , int j , int [][] mat){
        int n = mat.length;
        int m = mat[0].length;
        
        if( j < 0 || j >= m){
            return Integer.MIN_VALUE;
        }
        
        if(i == n-1){
            return mat[i][j];
        }
        
        if(dp[i][j] != null){
            return dp[i][j];
        }
        
        return dp[i][j] = Math.max(solve(i+1,j-1,mat), Math.max(solve(i+1,j,mat),solve(i+1,j+1,mat))) + mat[i][j];
    }
    
}