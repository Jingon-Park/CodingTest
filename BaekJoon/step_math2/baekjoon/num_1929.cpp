#include <iostream>
#include <vector>
using namespace std;

int main(){
    long long start, end;
    cin>>start>>end;
    vector<int> arr;
    for(long long i = start; i <= end; i++){
        bool checker = true;
        for(int j = 2; j * j <= i; j++){
            if(i % j == 0){
                checker = false;
                break;
            }
        }
        if(checker){
            arr.push_back(i);
        }
    }
    for(int i = 0; i < arr.size(); i++){
        printf("%d\n", arr[i]);
    }
}