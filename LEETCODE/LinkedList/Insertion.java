package LEETCODE.LinkedList;

public class Insertion {
     static class Node{
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
    public static Node ArrayIntoLinkedList(int[] arr){
        int n = arr.length; 
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1; i < n; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    public static void  printfun(Node head){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node insertathead(Node head, int val){
        Node temp = new Node(val,head);
        return temp;
    }
    public static Node InsterAtTail(Node head, int val){
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(val);
        temp.next = newNode;
        return head;
    }

    public static Node Insertatk(Node head, int k, int val){
        if(head == null) return new Node(val);
        // k == 1
        if(k == 1){
            Node temp = new Node(val,head);
            return temp;
        }
        Node temp  = head; int count = 0;
        while (temp != null) {
            count++;
            if(count == k-1){
                Node x = new Node(val);
                x.next = temp.next;
                temp.next = x;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        int arr[] = {3,1,5,8};
        Node head = ArrayIntoLinkedList(arr);   
        // head
        Node heaad = insertathead(head, 10);
        printfun(heaad);
        //  tail at the end of ll
    }
}
