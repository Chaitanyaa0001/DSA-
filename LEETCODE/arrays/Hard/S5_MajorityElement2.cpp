#include<bits/stdc++.h>
using namespace std;



int bruteforce(vector<int> nums, int n){
    unordered_map<int,int> map;
    
    for(int i =0; i < n; i++){
        map[nums[i]]++;
    }
    vector<int> ans;
    for(auto it : map){
        if(it.second > n/3){
            ans.push_back(it.first) ;
        }
    }
    return -1;
}

int main(){
    int n; 
    cin>> n;
    vector<int> v(n);

    for(int i = 0; i < n; i++){
        cin >> v[i];    
    }
    return 0;
}