/*
   class Node{
       int data;
       Node left;
       Node right;
       Node nextRight;
       Node(int data){
           this.data = data;
           left=null;
           right=null;
           nextRight = null;
       }
   }

   */

class Solution {
    public Node connect(Node root) {
        // code here.
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        Node temp = null;
        
        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(temp != null){
                temp.nextRight = currNode;
            }
            
            temp = currNode;
            
            if(currNode != null){
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
                
            }else{
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                    temp = null;
                }
            }
        }
        
        return root;
    }
}