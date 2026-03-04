class Solution {
    static class pair {
    int l;
    int w;
    int h;
    int area;

    public pair(int l, int w, int h){
        this.l = l;
        this.w = w;
        this.h = h;
        this.area = l * w;
    }
}
    public static int maxHeight(int[] height, int[] width, int[] length) {
        // Code here
        int n = height.length;
        ArrayList<pair> arr = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            int h = height[i];
            int w = width[i];
            int l = length[i];
            
            arr.add(new pair(Math.max(w,l), Math.min(w,l), h));
            arr.add(new pair(Math.max(h,l), Math.min(h,l), w));
            arr.add(new pair(Math.max(h,w), Math.min(h,w), l));
        }
        
        Collections.sort(arr, (a,b) -> b.area - a.area);
        
        int m = arr.size();
        int[] dp = new int[m];

        for(int i = 0; i < m; i++){
            dp[i] = arr.get(i).h;
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 0; j < i; j++){

                if(arr.get(i).l < arr.get(j).l &&
                   arr.get(i).w < arr.get(j).w){

                    dp[i] = Math.max(dp[i], dp[j] + arr.get(i).h);
                }
            }
        }

        int ans = 0;
        for(int x : dp)
            ans = Math.max(ans, x);

        return ans;
    }
}