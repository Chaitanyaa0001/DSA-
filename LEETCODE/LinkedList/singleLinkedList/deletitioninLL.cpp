#include<bits/stdc++.h>
using namespace std;



struct Node
{
    /* data */
    int val;
    Node* next;
    Node(int val){
        this->val = val;
        this->next = nullptr;
    }
};

Node* delete_head(Node* head){

    if(head  == nullptr){
        return nullptr;
    }
    Node* temp = head;
    temp = head->next;
    delete  (head);
    
    return temp;
}

Node* delete_from_tail(Node* head){

    if(head == nullptr){
        return nullptr;
    }
    Node* temp = head;
    while (temp->next->next != nullptr){
        temp = temp->next;
    }
    delete temp->next;
    temp->next = nullptr;

    return head;
}

Node* delete_the_kth_element(Node* head, int k){
    if(head == nullptr){
        return nullptr;
    }

    if(k == 1){
        Node* temp = head;
        temp= head->next;
        delete head;
        return temp;
    }

    int counter  = 0;
    Node* temp = head; Node* prev = nullptr;
    while(temp != nullptr){
        counter++;
        if(k == counter){
            prev->next = temp->next;
            delete temp;
            return head;
        }
        prev = temp;
        temp = temp->next;    
    }
    return head;
}
Node* delete_the_element(Node* head, int ele){
    if(head == nullptr){
        return nullptr;
    }

    if(head->val == ele){
        Node* temp = head;
        temp= head->next;
        delete head;
        return temp;
    }

    Node* temp = head; Node* prev = nullptr;
    while(temp != nullptr){
        if(temp->val == ele){
            prev->next = temp->next;
            delete temp;
            return head;
        }
        prev = temp;
        temp = temp->next;    
    }
    return head;
}


int main(){
    int n;
    return 0;
}