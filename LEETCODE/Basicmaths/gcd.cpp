#include<bits/stdc++.h>
using namespace std;

int gcd(int n1, int n2){
    while (n2 != 0){
        /* code */
        int temp = n1 % n2;
        n1 = n2;
        n2 = temp;
    }
    return n1;
    
}

int main(){
    int n1;
    int n2;
    cin >> n1 >> n2;

    return 0;
}