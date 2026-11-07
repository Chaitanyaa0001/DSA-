#include<bits/stdc++.h>
using namespace std;

struct Node
{
    int data;
    Node* next;
    Node* back;
    Node(int data){
        this->data = data;
        this->next = nullptr;
        this->back = nullptr;
    }
};

Node* delete_head(Node* head){
    if(head == nullptr){
        return nullptr;
    }
    if(head->next == nullptr){
        delete head;
        return nullptr;
    }
    Node* temp = head->next;
    head->next = nullptr;
    temp->back = nullptr;
    delete head;
    return temp;
}

Node* delete_tail(Node* head){
    if(head == nullptr){
        return nullptr;
    }
    if(head->next == nullptr){
        delete head;
        return nullptr;
    }
    Node* temp = head;
    while (temp->next->next != nullptr){
        temp = temp->next;
    }
    Node* tail = temp->next;
    tail->back = nullptr;
    temp->next = nullptr;
    delete tail;
    return head;
}

Node* delete_kth_node(Node* head, int k, int val) {
    if (head == nullptr || k <= 0) {
        return head;
    }
    if (k == 1) {
        Node* temp = head->next;
        if (temp != nullptr) {
            temp->back = nullptr;
        }
        delete head;
        return temp;
    }

    // Edge cases:
    // 1. Head: no back
    // 2. Middle nodes: both next and back
    // 3. Tail: no next

    int counter = 0;
    Node* temp = head;

    while (temp != nullptr) {
        counter++;

        if (counter == k) {
            break;
        }

        temp = temp->next;
    }

    // If k is greater than the length of the list
    if (temp == nullptr) {
        return head;
    }

    Node* prev = temp->back;
    Node* front = temp->next;

    if (front == nullptr) {
        // Tail node
        prev->next = nullptr;
        temp->back = nullptr;
        delete temp;
        return head;
    }
    else if (front != nullptr && prev != nullptr) {
        // Middle node
        prev->next = front;
        front->back = prev;

        delete temp;
        return head;
    }

    return head;
}

Node* delete_kth_val(Node* head, int val) {
    if (head == nullptr) {
        return head;
    }
    if (head->data == val) {
        Node* temp = head->next;
        if (temp != nullptr) {
            temp->back = nullptr;
        }
        delete head;
        return temp;
    }

    // Edge cases:
    // 1. Head: no back
    // 2. Middle nodes: both next and back
    // 3. Tail: no next

    int counter = 0;
    Node* temp = head;

    while (temp != nullptr) {
        counter++;

        if (temp->data == val) {
            break;
        }
        temp = temp->next;
    }

    // If k is greater than the length of the list
    if (temp == nullptr) {
        return head;
    }

    Node* prev = temp->back;
    Node* front = temp->next;

    if (front == nullptr) {
        // Tail node
        prev->next = nullptr;
        temp->back = nullptr;
        delete temp;
        return head;
    }
    else if (front != nullptr && prev != nullptr) {
        // Middle node
        prev->next = front;
        front->back = prev;

        delete temp;
        return head;
    }

    return head;
}


int main(){
    int n;

    return 0;
}