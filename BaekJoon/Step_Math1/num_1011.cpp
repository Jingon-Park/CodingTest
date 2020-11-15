#include <iostream>
#include <cmath>
#include <cstdio>

using namespace std;

int main(){
    int num;
    scanf("%d", &num);

    for (int i = 0; i < num; i++){
        long long start, end;
        long long move, max = 0;
        cin >>start>>end;
        
        while(max * max <= end - start){
            max++;
        }
        max--;
        move = (2 * max) - 1;
        long long rest = end - start - (max * max);
        rest = (long long)ceil((double)rest / (double)max);
        move += rest;
        printf("%lld\n",move);
    }
}