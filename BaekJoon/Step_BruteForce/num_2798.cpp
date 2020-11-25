#include <iostream>
#include <cstdio>
#include <vector>

using namespace std;

int main(){
    int num, max,answer;
    cin>>num>>max;
    answer = 0;
    int list[100] = {0,};

    for(int i = 0; i < num; i++){
        cin>>list[i];
    }    
    for(int i = 0; i < num - 2; i++){
        for(int k = i + 1; k < num - 1; k++){
            for(int j = k + 1; j < num; j++){
                int sum = list[i] + list[j] + list[k];
                if(sum > answer && sum <= max){
                    answer = sum;
                }
            }
        }
    }
    printf("%d", answer);
}