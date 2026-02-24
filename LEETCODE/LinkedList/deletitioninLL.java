package LEETCODE.LinkedList;

import A2Darrays.number7s;

public class deletitioninLL {
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
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    // delete form head 
    public static Node deleteNode(Node head){
        //  h
        // 12   ->  5  ->  8  ->  7
        // temp
        Node temp = head;
        head = head.next;
        return head;
    }
    public static Node deleteformtail(Node head){
        Node temp = head;

        if(head == null || head.next == null){
            return null;
        }

        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
    public static Node deletefromKposition(Node head, int node){
        if(head == null){
            return head;
        }
        if( node == 1){
            Node temp = head;
            head = head.next;
            return head;
        }
        int count = 0;
        Node temp = head,  previous = null;
        while (temp != null) {
            count++;
            if(count == node){
                previous.next = previous.next.next;
                break;
            }
            previous = temp;
            temp = temp.next;
        }
        return head;

        // better approch 
        // while (temp != nul; count < node) {
            // previous = temp
            // temp = temp.next
            // count ++ 
        // }
        // if(temp != null){
        //     previous.next = temp.next;
        // }
    }
    public static Node valueapproch(Node head, int ele){
        if(head == null) return head ;

        if(head.data == ele){
            return head.next;
        }
        Node temp = head, prev =  null;

        while (temp != null) {
            if(temp.data == ele){
                prev.next = temp.next;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    // for multiple  occurance 
     public static Node valueapprochalloccurence(Node head, int ele){
        if(head == null) return head ;
        
        if(head.data == ele){
            return head.next;
        }
        Node temp = head, prev =  null;
        while (temp != null) {
            if(temp.data == ele){
                prev.next = temp.next;
            }else{
                prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
        int arr[] = {12,5,8,7,5,8,8,8,7,8,8};
        Node head = ArrayIntoLinkedList(arr);
        // from head 
        // Node deletenode =  deleteNode(head);
        // printfun(deletenode);

        // from tail 
        // Node deletenodeFromtail = deleteformtail(head);
        // printfun(deletenodeFromtail);

        // Node deleteformk = deletefromKposition(head,3);
        // printfun(deleteformk);
        Node deletevalue = valueapprochalloccurence(head, 8);
        printfun(deletevalue);

    }
}