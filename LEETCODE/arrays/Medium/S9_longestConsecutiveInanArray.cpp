#include<bits/stdc++.h>
using namespace std;

int longestConsecutive(vector<int>& nums) {
    if (nums.empty()) return 0;
    int n = nums.size();
    unordered_set<int> set;
    for(auto it: nums){
        set.insert(it);
    }
    int maxcount = 1;
    for(auto it : set){
        if(set.find(it - 1) == set.end()){
            int count = 1;
            int ele  = it + 1;
            while (set.find(ele) != set.end()){
                count++;
                ele++;
                maxcount = max(count,maxcount);
            }
        }
    }
    return maxcount;
}


// O(nlogn)
int longestConsecutive(vector<int>& nums) {
    if (nums.empty()) return 0;
    sort(nums.begin(), nums.end());
    int count = 1;
    int maxcount = 1;
    for (int i = 1; i < nums.size(); i++) {
        // Consecutive number
        if (nums[i] == nums[i - 1] + 1) {
            count++;
        }
        // Duplicate -> ignore
        else if (nums[i] == nums[i - 1]) {
            continue;
        }
        // Sequence broken
        else {
            count = 1;
        }
        maxcount = max(maxcount, count);
    }
    return maxcount;
}

int main(){
    int n;
    cin >> n;
    vector<int> v(n);
    for(int i = 0; i < n; i++){
        cin >> v[i];
    }
    return 0;
}