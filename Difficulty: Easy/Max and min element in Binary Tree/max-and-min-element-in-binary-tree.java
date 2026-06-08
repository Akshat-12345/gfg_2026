/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    
    public static int findMax(Node root) {
        // code here
        if(root == null){
            return Integer.MIN_VALUE;
        }
        
        int l = findMax(root.left);
        int r = findMax(root.right);
        
        return Math.max(root.data,Math.max(l,r));
    }

    public static int findMin(Node root) {
        
        // code here
        if(root == null){
            return Integer.MAX_VALUE;
        }
        
        int l = findMin(root.left);
        int r = findMin(root.right);
        
        return Math.min(root.data,Math.min(l,r));
    }
}