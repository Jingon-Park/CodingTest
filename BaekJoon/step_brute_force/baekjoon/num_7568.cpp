#include<iostream>
#include<vector>
using namespace std;

int main(){
    int num;
    cin>>num;
    vector<pair<int, int>> arr;
    for(int i = 0; i < num; i++){
        int x,y;
        cin>>x>>y;
        arr.emplace_back(pair<int, int>(x, y));
    }
    for(int i = 0; i < arr.size(); i++){
        int counter = 0;
        for(int j = 0; j < arr.size(); j++){
            if((arr[i].first <= arr[j].first && arr[i].second < arr[j].second)){
                counter++;
            }
        }
        cout<<counter + 1<<" ";
    }
}