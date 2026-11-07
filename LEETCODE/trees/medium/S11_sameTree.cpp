#include<bits/stdc++.h>
using namespace std;


struct Node
{
    /* data */
    int data;
    Node* left;
    Node* right;
    Node(int data){
        this->data = data;
        this->left = left;
        this->right = right;
    }
};

bool sameTree(Node* p, Node* q){

    if( p == nullptr || q == nullptr){
        return (p == q);
    }

    return (p->data == q->data) && sameTree(p->left, q->left) && sameTree(p->right, q->right);
}
int main(){

}