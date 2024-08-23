#include<iostream>
using namespace std;

int cal(int a, int b){
    if(b == 1){
        return 1;
    }
    if(a == 0){
        return b;
    }
    return (cal(a - 1, b) + cal(a, b -1));
}

int main(){
    int num;
    cin >> num;
    for(int i = 0; i < num; i++){
        int floor, number;
        cin>> floor>>number;
        int count = cal(floor, number);
        cout<<count<< "\n";
    }
}