#include<bits/stdc++.h>
using namespace std;

int main(){
    int t;
    cin >> t;
    
    while (t --> 0){
        int n ;
        cin >> n;
        vector<int> problems(n);
        int zeros = 0;
        for(int i = 0; i < n; i++){
            cin >> problems[i];
            if(problems[i] == 0){
                zeros++;
            }
        }
        if(zeros < 2){
           cout << -1 << '\n';    
           continue;
        }
        int o = 0;

        if(problems[0] == 1 && problems[n-1] == 1){
            o = 2;
        }else if( problems[0] == 1 && problems[n-1] == 0){
            o = 1;
        }else if(problems[0] == 0 && problems[n-1] == 1){
            o = 1;
        }
        cout << o << endl;
    }
    return 0;

}