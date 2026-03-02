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
            if(temp.val != st.peek())
        }
    }
    public static void main(String[] args) {
        
    }
}
