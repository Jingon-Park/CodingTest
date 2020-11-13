#include <iostream>
using namespace std;

int main() {
  int num;
  cin >> num;
  for(int i = 0; i < num; i++){
    int high, with, count;
    cin >> high >> with >> count;
    int number = count % high;
    int floor = count / high;
    if(number > 0){
      floor++;
    }else{
      number = high;
    }
    cout <<(number * 100 + floor)<<"\n";
    
    }
    
}
