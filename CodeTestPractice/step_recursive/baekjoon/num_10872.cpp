#include <iostream>

using namespace std;

int fac(int num);

int main(){
    int num;
    cin>>num;

    int answer = fac(num);
    printf("%d", answer);

}
int fac(int num){
    if(num > 1){
        return fac(num - 1) * num;
    }else{
        return 1;
    }
}