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
    static class Pair {
        int dist;
        Node val;
        
        Pair(int dist, Node val) {
            this.dist = dist;
            this.val = val;
        }
    }


    public ArrayList<Integer> bottomView(Node root){
        ArrayList<Integer> l = new ArrayList<>();
        if (root == null) {
            return l;
        }

        TreeMap<Integer, Integer> mp = new TreeMap<>();

        Queue<Pair> q = new LinkedList<Pair>();
        
        q.add(new Pair(0, root));
        
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Pair curr = q.remove();
                int currDist = curr.dist;
                Node currNode = curr.val;
                
                
                mp.put(currDist, currNode.data);
                
                if (currNode.left != null) {
                    q.add(new Pair(currDist - 1, currNode.left));
                }
                if (currNode.right != null) {
                    q.add(new Pair(currDist + 1, currNode.right));
                }
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            l.add(entry.getValue());
        }
        
        return l;
    }
}