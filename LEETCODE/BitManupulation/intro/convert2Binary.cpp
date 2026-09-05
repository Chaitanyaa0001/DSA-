#include<bits/stdc++.h>
using namespace std;

void convert_to_binary(int n) {
    if (n == 0) {
        cout << "0";
        return;
    }
    string binary;
    while (n > 0) {
        int bit = n & 1; // bit = n % 2
        binary += (bit + '0');
        n = n >> 1;  // n = n / 2
    }
    reverse(binary.begin(), binary.end());
    cout << binary;
}

int convert_int(int n){

    int res = 0;
    int power = 1;

    while (n > 0)
    {
        int bit = n & 1;
        res = res + (bit * power);
        power = power * 10;
    }
    return res;
}


int main(){
    int n;
    cin >> n;
    convert_to_binary(n);
    return 0;
}