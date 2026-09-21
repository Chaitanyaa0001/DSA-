#include<bits/stdc++.h>
using namespace std;

 vector<vector<int>> bruteforce(vector<int> nums, int target){
    int n = nums.size();
    vector<vector<int>> ans;
    for(int i =0; i < n; i++){
        for(int j = i+1; j < n; j++){
            for(int k = j+1; k < n; k++){
                if(nums[i] + nums[j] + nums[k] == target){
                    vector<int> temp = {nums[i],nums[j],nums[k]};
                    ans.push_back(temp);
                }
            }
        }
    }
    return ans;
}
vector<vector<int>> better(vector<int> nums, int target){
    int n = nums.size();
    vector<vector<int>> ans;
    for(int i =0; i < n; i++){
        unordered_set<int> set;
        for(int j = i+1; j < n; j++){
            int k = target - (nums[i] + nums[j]);
            if(set.find(k) != set.end()){
                vector<int> temp = {nums[i],nums[j],k};
                ans.push_back(temp);   
            }
            set.insert(nums[j]);
        }
    }
    return ans;
}
vector<vector<int>> optimal(vector<int> nums, int target){
    sort(nums.begin(), nums.end());
    int n =  nums.size();
    vector<vector<int>> ans;

    for(int i =0; i < n; i++){
        if(i > 0 && nums[i] == nums[i-1]) continue;
        int j = i+1;
        int k = n-1;
        long long sum = nums[i] + nums[j] + nums[k];

        while (j < k){

            if(sum > 0){
                k--;
            }else if( sum < 0){
                j++;
            }else{
                vector<int> temp = {nums[i], nums[j], nums[k]};
                ans.push_back(temp);
                k--;
                j++;
                while (j < k && nums[j] == nums[j-1]){
                    j++;
                }
                while (j < k && nums[k] == nums[k+1])
                {
                   k--;
                }
                
            }
        }
    }
    return ans;
    
}
int main(){

    return 0;
}