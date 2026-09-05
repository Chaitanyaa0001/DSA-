#include<bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin >>  n;
    for(int i = n -1 ; i >=0 ; i--){
        char s = 'A';
        for(int j = 0; j < i+1; j++){
            cout << s << " ";
            s++;
        }
        cout << '\n';
    }
}