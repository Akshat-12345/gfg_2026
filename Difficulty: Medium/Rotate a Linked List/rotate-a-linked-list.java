/*
class Node {
    int data;
    Node next;

    Node(int d){
        data=d;
        next=null;
   }
}
*/

class Solution {
    public Node rotate(Node head, int k) {
        // code here
        if(head == null || k == 0){
            return head;
        }
        
        int size = 1;
        Node temp = head;
        
        while(temp.next != null){
            temp = temp.next;
            size++;
        }
        
        temp.next = head;
        
        int val = k % size;
        
        if(val == 0){
            temp.next = null;
            return head;
            
        }
        
        Node prev = head;
        for(int i = 1 ; i < val ; i++){
            prev = prev.next;
        }
        
        Node currHead = prev.next;
        prev.next = null;
        
        return currHead;
    }
}