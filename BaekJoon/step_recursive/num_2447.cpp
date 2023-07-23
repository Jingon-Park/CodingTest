#include <iostream>

using namespace std;

void startPrint(int x, int y, int num);
int main(){
    int num;
    cin>>num;

    for(int x = 0; x < num;x++){
        for(int y = 0; y < num;y++){
            startPrint(x, y, num);
        }
        cout<<"\n";
    }
}

void startPrint(int x, int y, int num){
    if((x / num) % 3 == 1 && (y / num) % 3 == 1){
        cout<<" ";
    }else
    {
        if(num / 3 == 0)
            cout<<"*";
        else
            startPrint(x, y, num / 3);
    }
    
}