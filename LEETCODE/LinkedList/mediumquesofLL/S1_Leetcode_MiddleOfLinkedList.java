package LEETCODE.LinkedList.mediumquesofLL;

import org.w3c.dom.NodeList;

import LEETCODE.LinkedList.LinkedListUtil;
import LEETCODE.LinkedList.LinkedListUtil.Node;

public class S1_Leetcode_MiddleOfLinkedList {

    public static  Node BruteForce(Node head){
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        count = count / 2 + 1;
        temp = head;
        while (temp != null) {
            count--;
            if(count == 0){
                return temp;
            }
            temp = temp.next;
        }
        return temp;
    }
    public static Node TortoiseHareAlgorithm(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        Node head = LinkedListUtil.arrayToLinkedList(arr);

        Node mid = BruteForce(head);
        LinkedListUtil.print(mid);
    }
}
