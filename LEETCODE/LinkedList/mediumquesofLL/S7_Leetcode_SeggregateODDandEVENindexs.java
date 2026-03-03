package LEETCODE.LinkedList.mediumquesofLL;

import java.util.ArrayList;

import LEETCODE.LinkedList.LinkedListUtil;
import LEETCODE.LinkedList.LinkedListUtil.Node;

public class S7_Leetcode_SeggregateODDandEVENindexs {
    public static Node Bruteforce(Node head){
        // first we will calculate and store the odd daat into the list 
        if(head == null || head.next == null){
            return head;
        } 
        Node temp = head;
        ArrayList<Integer> list  = new ArrayList<>();
        // add odd into the list 
        // TC : O(n/2)
        while (temp != null) {
            list.add(temp.val);
            if(temp.next == null) break;
            temp = temp.next.next;
        }
        // add even now 
        // TC : O(n/2)
        temp = head.next;
        while (temp != null) {
            list.add(temp.val);
            if(temp.next == null) break;
            temp = temp.next;
        }
        // now put into the LL 
        // TC : O(n)
        int i = 0;
        temp = head;
        while (temp != null) {
            temp.val =  list.get(i++);
            temp = temp.next;
        }
        return head;
        // total TC : O(2N) and Sc: O(n);
    }

    public static Node optimal(Node head){
        Node even = head.next; Node odd = head; Node evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,5,6,8,};
        Node head = LinkedListUtil.arrayToLinkedList(arr);

    }
}
