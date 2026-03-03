package LEETCODE.LinkedList.mediumquesofLL;

import java.util.Stack;

import LEETCODE.LinkedList.LinkedListUtil.Node;

public class S6_leetcode_Palindrome {
    public static Boolean brute(Node head){
        Stack<Integer> st = new Stack<>();
        Node temp = head;
        while (temp != null) {
            st.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if(temp.val != st.peek()){
                return false;
            }
        }
        return true;

    }

    public static Node helperToReverse(Node slow){
        Node prev = null; Node temp  = slow;
        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    public static Boolean optimalsol(Node head){
        // findmiddle 
        Node slow  = head;
        Node fast = head;
        while (fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // find new head 
        Node newHead =  helperToReverse(slow.next);
        // take  2 pointers and check if its palindrome or not 
        Node p1 = head; Node p2 = newHead;
        while (p2 != null) {
             if(p1.val != p2.val){
                helperToReverse(newHead);
                return false;
             }
             p1 = p1.next;
             p2 = p2.next;
        }
        // we dont wnt to alter the data so return back to its original form 
        helperToReverse(newHead);

       return true;


    }
    public static void main(String[] args) {
        
    }
}
