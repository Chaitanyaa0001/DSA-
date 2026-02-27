package LEETCODE.LinkedList.mediumquesofLL;

import java.util.Stack;

import LEETCODE.LinkedList.LinkedListUtil;
import LEETCODE.LinkedList.LinkedListUtil.Node;

public class S2_Leetcode_ReverseSingleLL {
    public static Node bruteStack(Node head){
        // tc : o(2N) sc : o(n)
        Stack<Integer>  stk = new Stack<>();
        Node temp = head;
        while(temp != null){
            stk.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            temp.val =  stk.pop();
            temp = temp.next;
        }
        return head;
    }
    public static Node optimalsol(Node head){
            Node prev = null;
          Node temp = head;
        while(temp != null){
                Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,4,5,6,8,9};
        Node head = LinkedListUtil.arrayToLinkedList(arr);

    }
}
