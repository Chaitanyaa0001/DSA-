#include<bits/stdc++.h>
using namespace std;


struct Node{
    /* data */
    int data;
    Node* next;
    Node(int data){
        this->data = data;
        this->next = nullptr;
    }
};

Node* insert_at_head(Node* head, int x){
    Node* temp = new Node(x);
    temp->next = head;
    return temp;
}
Node* insert_at_tail(Node* head, int x){
    Node* temp = head;

    while (temp->next != nullptr)
    {
        temp = temp->next;
    }
    Node* newNode = new Node(x);
    temp->next = newNode;
    return head;
}

Node* insert_at_k_position(Node* head, int k, int data){
    if(head  == NULL){
        return head;
    }
    if(k == 1){
        Node* node = new Node(data);
        node->next = head;
        return node;
    }
    int counter = 0;
    Node* temp = head; Node* prev = nullptr;
    while (temp != nullptr){
        /* code */
        counter++;
        if(counter == k){
            Node* newnode = new Node(data);
            prev->next = newnode;
            newnode->next = temp;
            return head;
        }
        prev  = temp;
        temp = temp->next;
    }
    return head;
}

Node* insert_at_val(Node* head, int ele){
    if(head == nullptr){
        return nullptr;
    }
    if(head->next != nullptr){
        if(head->data == ele){
            Node* temp = new Node(ele);
            head->next = temp;
            return head;
        }else{
            return nullptr;
        }
    }

    Node* temp = head; Node* prev  = nullptr;
    while (temp != nullptr){
            // 0 -> 1 -> 2 -> 3 -> 4 -> 5
                 // p    t 
        if(temp->data == ele){
            Node* newNode = new Node(ele);
            prev->next = newNode;
            newNode->next  = temp; 
            return head;
        }
        prev = temp;
        temp = temp->next;
    }
    return head;
}
int main(){
    return 0;
}