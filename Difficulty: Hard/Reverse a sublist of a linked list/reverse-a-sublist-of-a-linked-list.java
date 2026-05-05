// User function Template for Java

/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/
class Solution {
    public static Node reverseBetween(int a, int b, Node head) {
        // code here
        if (head == null || a == b) return head;
        Node dummy = new Node(0);
        dummy.next = head;
        Node temp = dummy;
        
        for(int i = 1; i < a; i++){
            temp = temp.next;
        }
        
        Node left = temp;
        Node headAfter = left.next;
        
        temp = temp.next;
        
        
        Node curr = temp;
        Node prev = null;
        
        for(int i = a ; i <= b ; i++){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        Node nodeAfter = curr;
        headAfter.next = nodeAfter;
        left.next = prev;
        
        return dummy.next;
    }
}