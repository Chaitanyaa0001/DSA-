package LEETCODE.LinkedList.mediumquesofLL;

import java.util.HashMap;

import LEETCODE.LinkedList.LinkedListUtil;
import LEETCODE.LinkedList.LinkedListUtil.Node;

public class S5_LengthoftheLoop {
    public static int brute(Node head){
        HashMap<Node,Integer> map = new HashMap<>();
        Node temp = head; int count = 0;
        while (temp != null) {
            if(map.containsKey(temp)){
                int len1 = map.get(temp);
                return count -len1;
            }
            map.put(temp,count);
            temp = temp.next;
            count++;
        }
        return count;
    }
    public static int optimal(Node head){
        Node temp  = head;
        Node slow  = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if( slow == fast){
                return  getlen(slow, fast);
            }
            
        }
        return 0;
    }
    private static int  getlen(Node slow, Node fast){
        int count = 1; fast = fast.next;
        while ( fast != slow) {
            count++;
            fast = fast.next;
        }
        return count;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9};
        Node head = LinkedListUtil.arrayToLinkedList(arr);

    }
}
