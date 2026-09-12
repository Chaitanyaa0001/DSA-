#include<bits/stdc++.h>
using namespace std;

int fibonachi(int n){
    if(n == 0 || n == 1){
        return n;
    }
    return fibonachi(n-1) + fibonachi(n-2);
}
int main(){
    int n;
    cin >> n;
    auto result = fibonachi(n);

    cout << result;

    return 0;
}