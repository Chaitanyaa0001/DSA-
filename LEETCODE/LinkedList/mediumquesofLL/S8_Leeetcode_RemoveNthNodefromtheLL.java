package LEETCODE.LinkedList.mediumquesofLL;

import LEETCODE.LinkedList.LinkedListUtil;
import LEETCODE.LinkedList.LinkedListUtil.Node;

public class S8_Leeetcode_RemoveNthNodefromtheLL {
    public static Node bruteForce(Node head, int n){
            if(head == null){
            return head;
        }
        if(head.next == null){
            if(n == 1){
                return null;
            }
        }
        Node temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        if(count == n){
            return head.next;
        }
        count = count - n;
        temp = head;
        while(temp != null){
            count--;
            if(count == 0){
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }
    public static Node optinal(Node head, int n){
        Node temp = head;
        Node fast  = head;
        for(int i = 0; i < n ; i++){
            fast = fast.next;
        }
        Node slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    public static void main(String[] args) {
        int arr [] = {1,23,4,5,6};
        Node head = LinkedListUtil.arrayToLinkedList(arr);


    }
}