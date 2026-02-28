package LEETCODE.LinkedList.mediumquesofLL;

import java.util.HashMap;

import LEETCODE.LinkedList.LinkedListUtil;
import LEETCODE.LinkedList.LinkedListUtil.Node;

public class S4_StartingPointInLL {
    public static Node brutueforce(Node head){
        HashMap<Node,Integer> map = new HashMap<>();
        Node temp = head;
         while(temp != null){
            if(map.containsKey(temp)){
                return temp;
            }
            map.put(temp,1);
            temp = temp.next;
        }
        return null;
    }
    public static Node optimal(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow  = slow.next;
            fast = fast.next.next;
            if(slow ==  fast){
                    slow  = head;
                while( fast != slow){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        Node head = LinkedListUtil.arrayToLinkedList(arr);

    }
}