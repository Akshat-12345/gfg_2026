class Solution {
    public int aggressiveCows(int[] arr, int k) {
        // code here
        int s = 1;
        int min = 0;
        int max = 0;
        int n = arr.length;
        Arrays.sort(arr);
        
        for(int i = 0 ; i < n ; i++){
            min= Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        
        int e = max - min;
        
        int ans = 0;
        
        while(s <= e){
            int m = s + (e - s)/2;
            
            if(isPossible(arr, k , m)){
                ans = m;
                s = m + 1;
            }else{
                e = m - 1;
            }
        }
        
        return ans;
    }
    
     public boolean isPossible( int [] stalls, int k , int mid ){
        int n = stalls.length;
        int count = 1;
        int lastPos = stalls[0];
        
        for(int i = 0 ; i < n ; i++){
            if(stalls[i] - lastPos >= mid){
                count++;
                lastPos = stalls[i];
            }
        }
        
        if(count >= k){
            return true;
        }
        
        return false;
    }
}
