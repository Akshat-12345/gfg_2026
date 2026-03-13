class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        // code here
        if(m*k > arr.length){
            return -1;
        }
        
        int MAX = 0;
        for(int i = 0 ; i < arr.length ; i++){
            MAX = Math.max(MAX,arr[i]);
        }
        
        int start = 1;
        int end = MAX;
        int ans = 0;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            
            if(calculate(arr,k,m, mid)){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        return ans;
    }
    
    public boolean calculate(int[] arr, int k, int m,int mid){
        int total = m * k;
        int count = 0;
        int bouqet = 0;
        
        for(int i = 0; i < arr.length ; i++){
            if(arr[i] <= mid){
                count++;
            }else{
                count = 0;
                
            }
           
            if(count == k){
                bouqet++;
                count = 0;
            }
            
            if(bouqet >= m){
                return true;
            }
        }
        
        return false;
    }
    
}