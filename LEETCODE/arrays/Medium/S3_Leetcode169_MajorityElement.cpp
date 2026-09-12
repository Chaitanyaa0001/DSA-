#include<bits/stdc++.h>
using namespace std;

int majority(vector<int> nums){
    int n = nums.size();
    unordered_map<int,int> map;
    for(auto it : nums){
        map[it]++;
    }
    for(auto it : map){
        if(it.second > n/2){
            return it.first;
        }
    }
    return -1;
}
int main(){
    int n;
    cin >> n;
    vector<int> v(n);
    for(auto i : v){
        cin >> i;
    }
}