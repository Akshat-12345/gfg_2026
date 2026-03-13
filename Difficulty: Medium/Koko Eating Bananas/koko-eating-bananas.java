class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        int Max = 0;
        for(int i = 0 ; i < arr.length ; i++){
            Max =Math.max(Max,arr[i]);
        }
        
        
        int start = 1;
        int end = Max;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            
            int hour = 0;
            for(int i = 0 ; i < arr.length ; i++){
                hour += (arr[i] + mid - 1) / mid;//Math.ceil(arr[i]/mid);
            }
            
            if(hour > k){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        return start;
    }
}
