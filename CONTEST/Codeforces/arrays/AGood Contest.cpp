#include<bits/stdc++.h>
using namespace std;

int main(){
    int t;
    cin >> t;

    while (t --> 0){
        int n;
        cin >>n; // participants can be form 1 to 9 

        vector<int> nums(3);
        for(int i = 0; i < 3; i++){
            cin >> nums[i];
        }
        // ek contest hai jisme 3 problems hai 
        // _ _ _ 
        // mera particpant weak is agar usne problem solve nhi kri 
        // array of len 3 in which ai = number of participant 
        // problem i  0- easy 1- medium 2 hard - as zero based indexing 
        int weak = 0;
        int a = n  - nums[0];
        int b = n - nums[1];
        int c = n - nums[2];

        weak = max(a,max(b,c));
        cout << weak << endl;
    }
    
    return 0;
}