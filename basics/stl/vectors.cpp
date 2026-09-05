#include<iostream>
#include<vector>
using namespace std;

int main(){
    vector<int> v;
    v.push_back(2);
    v.size();
    v.pop_back();
    v.capacity();
    v.front();  // return fron ele
    v.back(); // re turn back element
    v.erase(v.begin() + 1);
    v.erase(v.begin() + 1, v.begin() + 4);
    v.clear();
    
    return 0;
}