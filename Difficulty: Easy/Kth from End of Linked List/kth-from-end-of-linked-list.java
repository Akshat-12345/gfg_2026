/* Structure of node
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
} */

class Solution {

    // Function to find the data of kth node from
    // the end of a linked list.

    int getKthFromLast(Node head, int k) {
        int size = 1;
        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
            size++;
        }
        
        if(k > size){
            return -1;
        }
        
        if(size == k){
            return head.data;
        }

        int pos = size - k;
        Node prev = head;

        for(int i = 0 ; i < pos ; i++){
           prev = prev.next;
        }

        
        return prev.data;


    }

}