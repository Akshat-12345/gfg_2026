class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        int n = arr.length;
        int [][] res = new int [n][2];
        
        for(int i = 0; i < n ; i++){
            res[i][0] = arr[i];
            res[i][1] = dep[i];
        }
        
        Arrays.sort(res, Comparator.comparingInt( o -> o[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int max = 0;
        
        for(int i = 0 ; i < n ; i++){
            int at = res[i][0];
            int dp = res[i][1];
            
            while(!pq.isEmpty() && pq.peek() < at){
                pq.poll();
            }
            
            pq.add(dp);
            max = Math.max(max,pq.size());
        }
        
        return max;
        
    }
}
