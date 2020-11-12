#include <iostream>
using namespace std;

int main() {
  int input;
  cin >> input;

  int counter = 0;
  int threeCounter = 0;

  while(input % 5 != 0 && (input > 0)){
    input -= 3;
    threeCounter++;
  }
  int answer = (input >= 0) ? threeCounter + (input / 5) : -1;
  printf("%d", answer); 

}
