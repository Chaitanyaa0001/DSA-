#include<bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin >>  n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < i+1; j++){
            cout << j+1;
        }
        for(int k = 0; k < 2 * (n - i); k++){
            cout << " ";
        }
        for(int l = i; l >= 0; l--){
            cout << l+1;
        }
        cout << '\n';
    }
}