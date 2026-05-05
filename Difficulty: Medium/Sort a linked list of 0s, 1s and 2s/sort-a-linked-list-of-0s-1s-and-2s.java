/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node segregate(Node head) {
        // code here
        Node temp = head;
        
        Node zero = null;
        Node one = null;
        Node two = null;
        
        Node zeroHead = null;
        Node oneHead = null;
        Node twoHead = null;
        
        while(temp != null){
            Node curr = temp;
            temp = temp.next;
            curr.next = null;
            
            if(curr.data == 0){
                if(zero == null){
                    zero = curr;
                    zeroHead = curr;
                }else{
                    zero.next = curr;
                    zero = zero.next;
                }
                
            }else if(curr.data == 1){
                if(one == null){
                    one = curr;
                    oneHead = curr;
                }else{
                    one.next = curr;
                    one = one.next;
                }
                
            }else{
                if(two == null){
                    two = curr;
                    twoHead = curr;
                }else{
                    two.next = curr;
                    two = two.next;
                }
                
            }
            
        }
        
        
       if(zero != null){
           if(oneHead != null){
               zero.next = oneHead;
           }else{
               zero.next = twoHead;
           }
       }
       
       if(one != null){
           one.next = twoHead;
       }
        
       
       if(zeroHead != null) return zeroHead;
       if(oneHead != null) return oneHead;
       
       return twoHead;
    }
}