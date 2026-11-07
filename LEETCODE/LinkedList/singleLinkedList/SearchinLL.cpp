#include<bits/stdc++.h>
using namespace std;


struct Node{
    int data;
    Node* next;
    Node(int data){
        this->data = data;
        this->next = nullptr;
    }
};

bool search(Node* head, int val){
    Node* temp = head;
    while (temp != nullptr){
        /* code */
        if(val == temp->data){
            return true;
        }
    }
    return false;
}
int main(){

    return 0;
}