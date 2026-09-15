#include<bits/stdc++.h>
using namespace std;

int main(){
    int t; 
    cin >> t;

    while (t --> 0){
        int n;
        int m;
        cin >> n >> m;
        vector<long long> inp(n);
        for(int i  = 0; i  < n; i++){
            cin >> inp[i];
        }

        // n post draft kiye 
        // uska goal  is to farm pill emoji reacrion score rule is diff 
        // ratings [a1,a2,a3......] -ve also
        // publish krne hai m drafts in their original order so 
        //  n mei se m nikana h or order maintain krna hai to subsequece 
        // score start hua 0 se   jab uske ith index pe draft choose kiya to uski rating thi  bot n charge kiya  
        // i * bi - bi-1, jaha b0 = 0;
        // agar mera negative deuct points  and the score is allowe to become negative  
        //  i * bi - b i -1

        priority_queue<long long > q;
        long long sum = 0;

        for(int i = 0; i < m-1; i++){
            q.push(inp[i]);
            sum += inp[i];
        }
        long long ans = LLONG_MIN;

        for(int i = m-1; i < n; i++){
            long long c =  1LL * m * inp[i] - sum;
            ans = max(ans,c);

            q.push(inp[i]);
            sum += inp[i];

            if((int)q.size() > m-1){
                sum -= q.top();
                q.pop();
            }
        }
        cout << ans << endl;
    }
    
    return 0;
}