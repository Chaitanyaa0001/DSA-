package LEETCODE.LinkedList.doubleLinkedlist;

import java.util.Stack;

public class reverseDLL {
     static class Node {
        int data;
        Node next;
        Node back;
        Node(int data, Node next, Node back){
            this.data = data;
            this.next = next;
            this.back = back;
        }
        Node(int data){
            this.data = data;
            this.next = null;
            this.back = null;
        }
    }

    public static Node arrtodll(int[]arr){
        int n = arr.length;
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i = 1; i < n; i++){
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
    public static void printall(Node head){
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    // ------------------------------------------------------------------------------------- Brute force 
    public static Node RevserseaLinkedList(Node head){
        if(head == null ){
            return null;
        }
        Node temp = head;
        Stack<Integer> st = new Stack<>();
        while (temp != null) {
         st.push(temp.data);
         temp = temp.next;
        }
        Node temp2 = head;
        while (temp2 != null) {
         temp2.data = st.pop();
         temp2 = temp2.next;
        }
       
         return head ;
    }
    public static void main(String[] args) {
        
    }
}
