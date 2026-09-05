#include<bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin >>  n;
    for(int i = 0; i < n; i++){
        int change;

        if((i & 1) == 0){
            change = 0;
        }else{
            change = 1;
        }
        for(int  j = 0; j < i+1; j++ ){
            change = 1- change;
            cout << change;
        };
        cout  << '\n';
    }
    
   
}