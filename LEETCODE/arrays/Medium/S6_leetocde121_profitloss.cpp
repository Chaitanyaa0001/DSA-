#include<bits/stdc++.h>
using namespace std;

int profitlossques(vector<int> nums){
        int maxprofit = 0;;
        int buyprice = INT_MAX;
        int n = nums.size();
        int profit = 0;
        for(int i = 0; i < n; i++){
            if( buyprice > nums[i]){
                buyprice = nums[i];
                profit = nums[i] - buyprice;
                maxprofit = max(maxprofit, profit);
            }else{
                buyprice = nums[i];
            }
        }
        return maxprofit;
}
int main(){
    int n;
    cin >> n;
    vector<int> v(n);
    for(int i = 0; i < n;i++){
        cin >> v[i];
    }
    return 0;
}


    
 