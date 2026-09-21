#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int subsequence(int index, int sum, int n, int k, vector<int>& nums) {
        // Base case
        if(index >= n) {
            if(sum == k)
                return 1;
            return 0;
        }
        
        int take = subsequence(index + 1,sum + nums[index],n, k, nums);
        int nontake = subsequence(index + 1,sum,n, k, nums);
        return take + nontake;
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

    int count = obj.subsequence(0, 0, n, k, nums);

    cout << count << endl;

    return 0;
}