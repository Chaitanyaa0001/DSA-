package LEETCODE.LinkedList.hardofLL;

import LEETCODE.LinkedList.LinkedListUtil;
import LEETCODE.LinkedList.LinkedListUtil.Node;

public class S2_Leetcode61_RotateALL {
    private static Node ReturnNthNode(Node head, int k){
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if(count == k){
                return temp;
            }
        }
        return temp;
    }
    private static Node rotateLL(Node head, int k){
        if(head == null || head.next == null || k == 0){
            return head;
        }
        int length=1;
        Node tail = head;
        while(tail.next != null){
            length++;
            tail = tail.next;
        }
        k = k % length;        
        tail.next = head;
        Node newHead = ReturnNthNode(head,length - k);  
        head = newHead.next;
        newHead.next = null;
        return head;
        // O(2n) time
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Node head = LinkedListUtil.arrayToLinkedList(arr);
        rotateLL(head, 0);
    }
}
