import java.util.*;

class Solution {
    // Inner class taaki GFG ke driver code ke saath conflict na ho
    static class Pair {
        int dist;
        Node val;
        
        Pair(int dist, Node val) {
            this.dist = dist;
            this.val = val;
        }
    }

    // Function to return a list of nodes visible from the top view 
    // from left to right in Binary Tree.
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> l = new ArrayList<>();
        if (root == null) {
            return l;
        }

        TreeMap<Integer, Integer> mp = new TreeMap<>();
        // Yahan strictly Pair specify kiya hai taaki compiler confuse na ho
        Queue<Pair> q = new LinkedList<Pair>();
        
        q.add(new Pair(0, root));
        
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Pair curr = q.remove();
                int currDist = curr.dist;
                Node currNode = curr.val;
                
                if (!mp.containsKey(currDist)) {
                    mp.put(currDist, currNode.data);
                }
                
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