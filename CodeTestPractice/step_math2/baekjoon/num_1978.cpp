#include <iostream>
#include <vector>
using namespace std;

int main() {
  int num;
  vector<int> answer;
  cin >> num;
  for (int i= 0; i < num; i ++){
    int number;
    cin>> number;
    vector<int> vec;
    for(int j = 1; j <= number; j++){
      if(number % j == 0){
        vec.push_back(j);
      }
    }
    if(vec.size() == 2){
      answer.push_back(vec.back());
    }

  }
  cout << answer.size();
}