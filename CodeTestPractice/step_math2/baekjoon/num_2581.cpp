#include <iostream>
#include <vector>

using namespace std;
int main() {
  int start, end;
  cin>>start>>end;
  vector<int> answer;
  for(int i = start; i <= end; i++){
    vector<int> checker;
    for(int j = 1; j <= i; j++){
      if(i % j == 0){
        checker.push_back(j);
      }
    }
    if(checker.size() == 2){
      answer.push_back(i);
    }
  }
  int sum = 0;
  for(int i = 0; i < answer.size(); i++){
    sum += answer[i]; 
  }
  if(answer.size() > 0){
    cout<<sum<<"\n"<<answer.front();
  }else{
    cout<<-1;
  }
}