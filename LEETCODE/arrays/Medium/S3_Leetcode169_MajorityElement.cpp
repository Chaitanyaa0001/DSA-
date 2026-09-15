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


int majorityElement(vector<int>& nums) {
    int count = 0;
    int ele = 0;
    for(int i = 0; i < nums.size(); i++) {
        if(count == 0) {
            ele = nums[i];
            count = 1;
        }
        else if(ele == nums[i]) {
            count++;
        }
        else {
            count--;
        }
    }
    return ele;
}

int main(){
    int n;
    cin >> n;
    vector<int> v(n);
    for(auto i : v){
        cin >> i;
    }
}