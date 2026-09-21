#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> ans;

    void subsequence(int index, int sum, int n, int k, vector<int>& nums, vector<int>& ds) {
        if(index >= n) {
            if(sum == k) {
                ans.push_back(ds);
            }
            return;
        }
        // Take
        sum += nums[index];
        ds.push_back(nums[index]);
        subsequence(index + 1, sum, n, k, nums, ds);
        // Backtrack
        sum -= nums[index];
        ds.pop_back();
        // Don't take
        subsequence(index + 1, sum, n, k, nums, ds);
    }
};

int main() {
    int n;
    cin >> n;
    vector<int> nums(n);
    for(int i = 0; i < n; i++) {
        cin >> nums[i];
    }
    int k;
    cin >> k;
    Solution obj;
    vector<int> ds;
    obj.subsequence(0, 0, n, k, nums, ds);
    for(auto subseq : obj.ans) {
        for(auto x : subseq) {
            cout << x << " ";
        }
        cout << endl;
    }
    return 0;
}