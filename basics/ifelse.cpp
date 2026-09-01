#include<iostream>
using namespace std;

void hello(int age){
  
    if(age > 18){
        cout << "adult";
    }else{
        cout << " not adult";
    }
}

int main(){
    int age ;
    cin >> age; 
    hello(age);
    return 0;

}
