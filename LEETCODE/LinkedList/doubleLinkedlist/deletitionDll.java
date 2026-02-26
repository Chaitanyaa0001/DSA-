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
        if(head == null){
            return null;
        }
        if(  k == 1 ){
            Node temp = head;
            head = head.next;
            temp.next = null;
            head.back = null;
            return head;
        }
        Node temp = head; int count = 0;
        while (temp != null) {
            count++;
            if(count == k){
                break;
            }
            temp = temp.next;
        }
        Node prev = temp.back;
        Node front = temp.next;

        if(prev == null && front == null){
            return null;
        }else if( front == null){
            prev.next = null;
            temp.back = null;
        }else{
            prev.next = front;
            front.back = prev;
            temp.next = null;
            temp.back = null;
        }

        return head ;
    }

    public static Node delfromnode(Node temp){
        // in this the given node is not head 
       Node prev = temp.back;
       Node front = temp.next;

       if( front == null){
        prev.next = null;
        temp.back = null;
        return temp;
       }
       prev.next = front;
       front.back = prev;
       temp.next = null;
       temp.back = null;
       return temp;

    }
    public static void main(String[] args) {
        int arr[] = {10,20,30,40};
        Node head = arrtodll(arr);
        // head 
        // Node headd = headofdll(head);
        // printall(headd);
        // tail 
        // Node Tail = tailofdll(head);
        // printall(Tail);
        Node Kele = kelement(head, 1);
        printall(Kele);

    }
}
