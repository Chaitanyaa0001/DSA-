package LEETCODE.LinkedList.singleLinkedList;

public class ArrayIntoLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    public static void main(String[] args) {
        int [] arr = {2,4,1,5,3};
        Node head = new  Node(arr[0]);
        Node mover = head;
        for(int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        System.out.println(head.data);

        // traversing  

        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        // length 
         Node temp1 = head; int count = 0;
        while (temp1 != null) {
            System.out.println(temp1.data);
            temp1 = temp1.next;
            count++;
        }
        System.out.println(count);

    }
}
