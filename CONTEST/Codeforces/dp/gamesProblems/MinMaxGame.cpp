#include<bits/stdc++.h>
using namespace std;





int main(){
    int t;
    cin >> t;

    while (t --> 0){
        int n;
        cin >> n;
        vector<int>  nums(n);
        int zero = 0;
        int one = 0;
        for(int i = 0; i < n; i++){
            cin >>  nums[i];
            if(nums[i] == 0){
                zero++;
            }else{
                one++;
            }
        }
        
        if(one >= zero){
            cout<< "Bessie\n";
        }else{
            cout << "Elsie\n";
        }
    }
    
    return 0;
}