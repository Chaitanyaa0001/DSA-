#include<bits/stdc++.h>
using namespace std;

int main(){

    priority_queue<int> q;  // maxheap
    
    q.push(10);    // Add element
    q.pop();      // Remove top element
    q.top();      // Get top element
    q.size();     // Number of elements
    q.empty();    // Check if empty
    
    priority_queue<int, vector<int>, greater<int>> pq;

    // now pair in max heap and min heap  
    priority_queue<pair<int,int>> q; // maxheap

    priority_queue <pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> p; 
    // for min heap 




    return 0;
}
