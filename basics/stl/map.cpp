#include<iostream>
#include<map>
using namespace std;

int main(){
    map<string, int> m; // it is sorted 
    m["rahul"] = 100;
    m["ram"] = 100;
    m["rohan"] = 100;
    m["khushi"] = 100;
    m["palavi"] = 100;

    // iteration 
    for(auto x : m){// i will get in sorted order  O(logn)
        cout << x.first << " " << x.second;
    }
    m.insert({"gautam", 20});

    if(m.find("rahul") != m.end()){
        // it ---> rahul ? dedo : nhi hai to ye mera end ki taraf point krega it --> end 
    }


    return 0;
}