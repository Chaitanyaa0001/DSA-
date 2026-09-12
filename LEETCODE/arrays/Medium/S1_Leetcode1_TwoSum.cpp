#include<bits/stdc++.h>
using namespace std;

vector<int> twosum(vector<int> nums, int k){
    int n  = nums.size();
    for(int i = 0; i < n; i++){
        for(int j = i; j < n; j++){
            if(nums[i] + nums[j] == k){
                return vector<int>{i,j};
            }
        }
    }
    return {};
}
vector<int> better(vector<int> nums, int k){
    unordered_map<int,int> map;
    int n = nums.size();
    for(int i = 0; i < n;  i++){
        int rem = nums[i] - k;
        if(map.find(rem) != map.end()){
            int j = map[rem];
            return vector<int>{i,j};
        }
    }
    return {};
}

int main(){
    int n;
    int k ;
    cin >> n >> k;
    vector<int> v(n);
    for(int i = 0; i < n; i++){
        cin >> v[i];
    }
    return 0;
}