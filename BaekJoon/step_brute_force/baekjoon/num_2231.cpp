#include <iostream>

using namespace std;

int  main(){
    int target;
    int answer = 0;
    cin>>target;

    for(int i = 0; i < target ; i++){
        int sum = i;
        int num = i;
        while (num > 0)
        {
            sum += (num % 10);
            num /= 10;
        }
        if(sum == target){
            answer = i;
            break;
        }
    }
    printf("%d", answer);
}