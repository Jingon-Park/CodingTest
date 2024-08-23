#include <iostream>

using namespace std;

void hanoi(int num, int from, int to, int pass);

int main(){
    int num;
    cin>>num;
    cout<<(1<<num) - 1<<"\n";
    hanoi(num, 1,3,2);
}


void hanoi(int num, int from, int to, int pass){
    if(num == 1)
        printf("%d %d\n", from, to);
    else{
        hanoi(num - 1, from, pass, to);
        printf("%d %d\n", from, to);
        hanoi(num - 1, pass, to, from);
    }
}

