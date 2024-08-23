#include <iostream>
using namespace std;

int main() {
  int input;
  cin >> input;
  int num = 1;
  int layer = 1;
  for(int i = 2; num < input; i++){
    layer++;
    num += i;
  }
  if(layer % 2 == 0){
    printf("%d/%d", layer - (num - input), 1 + (num - input));  
  }else{
    printf("%d/%d", 1 + (num - input), layer - (num - input));
  }
}
