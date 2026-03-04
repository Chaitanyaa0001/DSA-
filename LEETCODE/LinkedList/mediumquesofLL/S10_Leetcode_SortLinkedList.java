package LEETCODE.LinkedList.mediumquesofLL;

import LEETCODE.LinkedList.LinkedListUtil;
import LEETCODE.LinkedList.LinkedListUtil.Node;

public class S10_Leetcode_SortLinkedList {
    public static Node bruteforce(Node head){
        if(head == null || head.next == null){
            return head;
        }
        PriorityQueue<Integer> pq  = new PriorityQueue<>((a,b) -> a - b);
        Node temp = head;
        while(temp != null){
            pq.add(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            temp.val = pq.poll();
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {6,4,2,2,4,6};
        Node head = LinkedListUtil.arrayToLinkedList(arr);  
    }
    

}
