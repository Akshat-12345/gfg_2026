/* The functions which
builds the segment tree */
class GfG {
    static int st[];
    static int nums [];
    
    public static int[] constructST(int nums[], int n) {
        // Add your code here
        GfG.nums = nums;
        st = new int[4*n];
        buildTree(0,0,n-1);
        return st;
    }
    
    public static void buildTree(int i, int s , int e){
        if(s == e){
            st[i] = nums[s];
            return;
        }
        
        int mid = (s+e)/2;
        buildTree(2*i+1,s,mid);
        buildTree(2*i+2,mid+1,e);
        
        st[i] = Math.min(st[2*i+1],st[2*i+2]);
    }

    /* The functions returns the
      min element in the range
      from l and r */
    public static int RMQ(int st[], int n, int l, int r) {
        // Add your code here
        return getMin(0,0,n-1,l,r);
    }
    
    public static int getMin(int i, int s, int e, int l , int r){
        if(e < l || s > r){
            return Integer.MAX_VALUE;
        }else if( s >= l && e <= r){
            return st[i];
        }else{
            int mid = (s+e)/2;
            
            int li = getMin(2*i+1, s, mid,l,r);
            int ri = getMin(2*i+2,mid+1,e,l,r);
            
            return Math.min(li,ri);
        }
    }
}