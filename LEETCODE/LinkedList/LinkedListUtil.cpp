#include<bits/stdc++.h>
using namespace std;


class Node{
    public:
    int data;
    Node* next;
    Node(int data){
        this->data = data;
        this->next = nullptr;
    }
};

// or 

struct Nodee
{
    /* data */
    int data ;
    Nodee* next;
    Nodee(int data){
        this->data = data;
        this->next = nullptr;
    }
};

int main(){

    Node* head = new Node(10);

    head->next = new Node(20);
    head->next->next = new Node(30);
    head->next->next->next = new Node(40);
    return 0;
}