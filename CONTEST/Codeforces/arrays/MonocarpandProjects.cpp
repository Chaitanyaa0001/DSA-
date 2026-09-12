#include<bits/stdc++.h>
using namespace std;
// Monocarp's work in month i = d % (x + i)
// where d = y - x (constant difference)

// Once employees exceed the difference (d),
// Monocarp completes exactly d projects every month!
int main(){
    int t;
    cin >> t;
    while(t --> 0){
        long long x, y, k;
        cin >> x >> y >> k;
        // the sum of y does not excedd 10^5
        // x = employes 
        // y = projects 
        // k = months

        long long monocrap = 0;
        long long d = y - x;

        // brute 
        // for(int i = 1; i <=k; i++){
        //     long long  p = (y / x) * x;  
        //     monocrap +=  y - p;
        //     x++;
        //     y++;
        // }
        // cout << monocrap << endl;

        int i = 0; 
        while(i < k && x+ i <= d){
            monocrap += d % (x + i);
            i++;
        }
        if(i < k){
            monocrap += d * (k - i); 
        }
        cout << monocrap << endl;
        
    }
    return 0;
}
