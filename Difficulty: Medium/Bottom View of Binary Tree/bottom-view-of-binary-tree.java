/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}
*/

class Solution {
    class pair{
        int data;
        int level;
        public pair(int data, int level){
            this.data = data;
            this.level = level;
        }
    }
    
    Map<Integer,pair> map = new TreeMap<>();
    
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        solve(root,0,0);
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int key : map.keySet()){
            arr.add(map.get(key).data);
        }
        
        return arr;
        
    }
    
    public void solve(Node root, int idx, int level){
        if (root == null){
            return;
        }
        
        solve(root.left, idx - 1, level + 1);
        solve(root.right, idx + 1, level + 1);
        
        if(!map.containsKey(idx) || map.get(idx).level <= level){
            map.put(idx , new pair(root.data,level));
        }
        
    }
}