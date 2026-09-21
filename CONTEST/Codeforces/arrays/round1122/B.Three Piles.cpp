#include<bits/stdc++.h>
using namespace std;




int main(){
    int t;
    cin >> t;
    while (t --> 0){

        long long a, b, c;
        cin >> a >> b >> c;
        long long score  = 0;

        if(a >= b){
            score = a + c  - b;
        }else if(a < b){
            long long d =  b - a;
            score = max(d , c - d);
        }
        cout << score << endl;
    }
    
    return 0;
}