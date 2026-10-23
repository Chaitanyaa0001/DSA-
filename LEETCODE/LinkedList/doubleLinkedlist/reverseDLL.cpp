
#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node* next;
    Node* back;

    Node(int data) {
        this->data = data;
        this->next = nullptr;
        this->back = nullptr;
    }
};

Node* reverse_the_linked_list(Node* head) {
    if (head == nullptr) {
        return nullptr;
    }

    Node* curr = head;
    Node* prev = nullptr;
    Node* front = nullptr;

    while (curr != nullptr) {
        front = curr->next;
        curr->next = prev;
        curr->back = front;

        prev = curr;
        curr = front;
    }

    return prev;
}

void printList(Node* head) {
    Node* temp = head;

    while (temp != nullptr) {
        cout << temp->data << " ";
        temp = temp->next;
    }

    cout << endl;
}

int main() {
    Node* head = new Node(1);
    head->next = new Node(2);
    head->next->back = head;

    head->next->next = new Node(3);
    head->next->next->back = head->next;

    cout << "Original list: ";
    printList(head);

    head = reverse_the_linked_list(head);

    cout << "Reversed list: ";
    printList(head);

    return 0;
}
