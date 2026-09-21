#include<bits/stdc++.h>
using namespace std;

int bruetforce(vector<int>a, int k){
    int count = 0; 
    for(int i = 0; i < a.size(); i++){
        int sum = 0;
        for(int j = i;  j < a.size(); j++){
            sum += a[j];
            if(sum == k){
                count++;
            }
        }
    }
    return count;
}

int optimal(vector<int> a, int k){
    int n = a.size();
    unordered_map<int,int> map;
    int sum = 0;
    int count = 0;
    map[0] = 1;

    for(int i  = 0; i < n; i++){
        sum += a[i];
        int rem = sum - k;
        if(map.find(rem) != map.end()){
            int j = map[rem];
            count += j;
        }
        map[sum]++;
    }
}

int main(){

    return 0;
}
