class Solution {
    public static boolean isRotated(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();
        
        if(n != m){
            return false;
        }
        
        if (n < 2) {
            return s1.equals(s2);
        }
        
        String forward = s1.substring(0,2);
        String forwardBody = s1.substring(2,n);
        String forwardString = forwardBody + forward;
        
        String backward = s1.substring(n-2,n);
        String backwardBody = s1.substring(0,n-2);
        
        String str = backward + backwardBody;
        
        if(str.equals(s2) || forwardString.equals(s2)){
            return true;
        }
        
        return false;
    }
}