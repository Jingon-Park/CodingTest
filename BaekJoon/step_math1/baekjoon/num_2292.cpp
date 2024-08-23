#include <iostream>
using namespace std;

int main() {
  int input = 0;
  cin >> input;
  int num = 1;
  int jump = 0;
  int counter = 1;

  while(input > num){
    counter++;
    jump +=6;
    num += jump;
  }
  
  cout <<counter;
}
