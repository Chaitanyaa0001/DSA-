#include<bits/stdc++.h>
using namespace std;
// 🧩 Practice Question
// Given an integer array nums containing positive and negative integers, rearrange the array so that:
// 1. Positive and negative numbers appear alternately as long as both types are available.
// 2. The rearrangement should preserve the relative order of positive numbers among themselves and negative numbers among themselves.
// 3. If one type runs out before the other, append all remaining elements of the other type at the end.
// 4. Return the rearranged array.
// 5. You may use extra space.
// Input:
// [1, 2, 3, -1, -2]

// Output:
// [1, -1, 2, -2, 3]

// Input:
// [-1, 2, -3, 4, 5, 6]

// Output:
// [2, -1, 4, -3, 5, 6]

vector<int> maintainorder(vector<int> nums){
    int n = nums.size();
    vector<int> pos;
    vector<int> neg;
    int countP = 0;
    int countN = 0;
    for(int i = 0; i < n; i++){
        if(nums[i]  < 0){
            neg.push_back(nums[i]);
            countN++;
        }else{
            countP++;
            pos.push_back(nums[i]);
        }
    }

    int r = min(neg.size(),  pos.size());
    vector<int> ans;
    for(int i =0; i < r; i++ ){
        ans.push_back(pos[i]);
        ans.push_back(neg[i]);
    }
    if(countP > countN){
        for(int i = r; i < pos.size(); i++){    
            ans.push_back(pos[i]);
        }
    }else if(countN > countP){
        for(int i = r; i  < neg.size(); i++){
            ans.push_back(neg[i]);
        }
    }
    return ans;
}
int main(){
    int n; 
    cin >> n;
    vector<int> nums(n);
    for(int i = 0; i < n; i++){
        cin >> nums[i];
    }
    auto res = maintainorder(nums);

    for(int i : res){
        cout << i << endl;
    }
    return 0;
} 