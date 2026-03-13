class Solution {
    int floorSqrt(int x) {
        // code here
        int start = 0;
        int end = x;

        int ans = 0;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(mid * mid > x){
                end = mid -1;
            }else if ( mid * mid <= x){
                ans = mid;
                start = mid + 1;
            }
        }

        return ans;
    }
    

}