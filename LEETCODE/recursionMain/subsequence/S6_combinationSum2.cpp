#include<bits/stdc++.h>
using namespace std;


class Solution {
public:
    vector<int> ds;
    vector<vector<int>> ans;
    void solve(int index, vector<int>& nums, int k) {
        if (k == 0) {
            ans.push_back(ds);
            return;
        }
        for (int i = index; i < nums.size(); i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;
            if (nums[i] > k)
                break;
            ds.push_back(nums[i]);
            solve(i + 1, nums, k - nums[i]);
            ds.pop_back();
        }
    }
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        solve(0, candidates, target);
        return ans;
    }
};

int main(){
    int n;
    cin >> n;
    vector<int> nums(n);
    for(int i = 0; i < n; i++){
        cin >> nums[i];
    }
    return 0;
}