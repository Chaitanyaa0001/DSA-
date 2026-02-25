package LEETCODE.LinkedList.doubleLinkedlist;

public class deletitionDll {
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
    // ---------------------------------------------------------------------------------
    public static Node headofdll(Node head){

        if(head == null ||  head.next == null){
            return null;
        }           
        Node prev = head;
        head = head.next;

        head.back = null;
        prev.next= null;
        return head;
    }
    // ----------------------------------------------------------------------------------
    public static Node tailofdll(Node head){
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        Node prev = temp.back;
        prev.next = null;
        temp.back = null;
        return head;
    }
    // ----------------------------------------------------------------------------------------
    public static Node kelement(Node head, int k ){
        
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,6,7,9};
        Node head = arrtodll(arr);
        // head 
        // Node headd = headofdll(head);
        // printall(headd);
        Node Tail = tailofdll(head);
        printall(Tail);
        // tail 

    }
}
