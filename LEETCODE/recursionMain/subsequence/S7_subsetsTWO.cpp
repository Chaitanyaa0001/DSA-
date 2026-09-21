#include<bits/stdc++.h>
using namespace std;


class solution{
    public:
    vector<vector<int>> ans;
    void solve(int index, vector<int> nums, vector<int> ds, int n){
            ans.push_back(ds);

        for(int i = index; i < nums.size(); i++){
            if(i  > index && nums[i] == nums[i-1]) continue;
            ds.push_back(nums[i]);
            solve(i+1,nums,ds,n);
            ds.pop_back();
        }
    }
    vector<vector<int>> subsets2(int n, vector<int>nums){
        vector<int> ds;
        sort(nums.begin(), nums.end());
        solve(0,nums,ds,n);
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
    solution s1;
    auto result = s1.subsets2(n,nums);
    for (auto& subset : result) {
        cout << "[ ";
        for (int num : subset) {
            cout << num << " ";
        }
        cout << "]\n";
    }
    return 0;
}