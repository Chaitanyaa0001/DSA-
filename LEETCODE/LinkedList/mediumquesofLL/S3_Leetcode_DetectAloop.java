package LEETCODE.LinkedList.mediumquesofLL;

import java.util.HashMap;

import LEETCODE.LinkedList.LinkedListUtil;
import LEETCODE.LinkedList.LinkedListUtil.Node;
// Given head, the head of a linked list, determine if the linked list has a cycle in it.
// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
// Return true if there is a cycle in the linked list. Otherwise, return false.
public class S3_Leetcode_DetectAloop {
    public static Boolean brute(Node head){
        HashMap<Node,Integer> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            if(map.containsKey(temp)){
                return true;
            }
            map.put(temp, 1);
            temp = temp.next; 
        }
        return false;
    }
    public  static Boolean hasCycle(Node head) {
        Node slow = head;

        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,5,6,8,9};
        Node head = LinkedListUtil.arrayToLinkedList(arr);
    }
}
