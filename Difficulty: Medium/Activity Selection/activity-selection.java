class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here
        int n = start.length;
        int [][] res = new int [n][2];
        
        for(int i = 0 ; i < n ; i++){
            res[i][0] = start[i];
            res[i][1] = finish[i];
        }
        
        Arrays.sort(res, Comparator.comparingInt( o -> o[1]));
        int count = 1;
        int time = res[0][1];
        
        for(int i = 1; i < n ; i++){
            if(time < res[i][0]){
                count++;
                time = res[i][1];
            }
        }
        
        return count;
    }
}
