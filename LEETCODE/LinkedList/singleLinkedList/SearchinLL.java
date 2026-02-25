package LEETCODE.LinkedList.singleLinkedList;

public class SearchinLL {
    static class Node {
        int data ;
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
    public  static Node LinkedList(int [] arr){
        Node head = new Node(arr[0]);
        Node mover  = head;

        for(int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    } 

    public static Boolean Searching (Node head, int val){
        // tc -> O(n)
        Node temp = head;
        while (temp != null) {
            if(temp.data == val){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }


    public static void main(String[] args) {
        int [] arr = {2,3,4,5,6};
        Node head = LinkedList(arr);

        System.out.println(Searching(head, 10));

       
    }
}
