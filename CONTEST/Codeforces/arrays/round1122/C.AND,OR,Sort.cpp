#include<bits/stdc++.h>
using namespace std;


int main(){

    int t;
    cin >> t;
    while (t --> 0){
        long long  n;
        string s;
        cin >> n;  // len of binary string 
        cin >> s;

        int ans = 0;
        if(s[0] == '1'){
            int zeros = count(s.begin(), s.end(),'0');
            cout << zeros << endl;
        }else{
            int total_one = count(s.begin(), s.end(), '1');
            int ans = total_one;  // one

            int ones = 0;
            int zeros = count(s.begin(), s.end(), '0'); 
            for (int i = 0; i < n; i++) {
                if (s[i] == '1') {
                    // Try making this the first 1 of the final string
                    ans = min(ans, ones + zeros);
                    ones++;
                } else {
                    zeros--;
                }
            }
            cout << ans << endl;
        }
    }
    
    return 0;
}