package LEETCODE.LinkedList.doubleLinkedlist;

public class insertition {
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
    // ---------------------------------------------------------------------
    public static Node headinseet(Node head, int val){
        Node temp  = new Node(val,head,null);
        head.back = temp;
        return temp;
    }
    // ----------------------------------------------------------------------
    public static Node tailinsert(Node head, int ele){
        if(head == null) return null;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(ele,null,temp);
        temp.next = newNode;
        return head;
    }
    // -----------------------------------------------------------------
    public static Node beforetail(Node head, int ele){
        if(head == null){
            return head;
        }
        if(head.next == null){
            Node x = new Node(ele,head, null);
            head.back = x;
            return x;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(ele,temp.next,temp);
        temp.next.back = newNode;
        temp.next  =  newNode;
        return head ;
    }
    // ---------------------------------------------------------------
    public static Node kelement(Node head, int ele, int k){
        // if my list is empty return null 
        boolean flag = true;
        if(head == null){
            return null;
        }
        if(head.next == null ){
            if(k == 1){
                Node temp  = new Node(ele,head,null);
                head.back = temp;
                return temp;
            }else{
                System.out.println("false");
            }
        }
        if(k == 1){
            Node newNode = new Node(ele,head,null);
            head.back = newNode;
            return newNode;
        }
        
        Node temp = head; int count = 0;
        while (temp != null) {
            count++;
            if(count == k){
                break;
            }
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("position out of bound");
            return head;
        }
        Node prev = temp.back;
        Node newNode = new Node(ele,temp,prev);
        prev.next = newNode;
        temp.back = newNode;
        return head;
    }
    // ------------------------------------------------------------------------
    
    public static void main(String[] args) {
        int arr[] = {10,20,30,40};
        Node head = arrtodll(arr);

        // Node h = headinseet(head, 100);
        // printall(h);
        Node K = kelement(head, 100, 5);
        printall(K);
    }
}
