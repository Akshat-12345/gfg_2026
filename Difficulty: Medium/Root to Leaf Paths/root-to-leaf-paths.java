/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        
        solve(root,curr,res);
        return res;
    }
    
    public static void solve (Node root, ArrayList<Integer> curr , ArrayList<ArrayList<Integer>> res){
        if(root == null){
            return;
        }
        
        curr.add(root.data);
        
        if(root.left == null && root.right == null){
            res.add(new ArrayList<>(curr));
            
        } else {
            solve(root.left, curr, res);
            solve(root.right, curr, res);
        }
        
        curr.remove(curr.size() - 1);
        
    }
}
