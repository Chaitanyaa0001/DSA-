#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> ans;
    void solve(int index, int n, const vector<int>& nums, vector<int>& ds) {
        if (index >= n) {
            ans.push_back(ds);
            return;
        }        
        ds.push_back(nums[index]);
        solve(index + 1, n, nums, ds);
        
        ds.pop_back();
        solve(index + 1, n, nums, ds);
    }

    // other approch could be 
    void solve2(int index, int n, vector<int>& nums, vector<int>& ds){
        
        ans.push_back(ds);
        for(int i = index; i < nums.size(); i++){
            ds.push_back(nums[i]);
            solve2(i+1, n, nums, ds);
            ds.pop_back();
        }
    }
    vector<vector<int>> subsets(int n,vector<int>& nums) {
        vector<int> ds;
        solve(0, n, nums, ds);
        return ans;
    }
};

int main() {
    int n;
    cout << "Enter size of array: ";
    cin >> n;
    
    vector<int> nums(n);
    cout << "Enter elements: ";
    for (int i = 0; i < n; i++) {
        cin >> nums[i];
    }
    
    Solution obj;
    vector<vector<int>> result = obj.subsets(n, nums);
    
    cout << "\nGenerated Subsets:\n";
    for (auto& subset : result) {
        cout << "[ ";
        for (int num : subset) {
            cout << num << " ";
        }
        cout << "]\n";
    }
    
    return 0;
}