#include <iostream>
#include <limits> // needed for numeric_limits on some compilers
using namespace std;

// error handling demo

int get_num() { // get an integer number from user
  int n;
  while (!(cin >> n)) { // NOT (! cin >> n) 
    cout << "not a valid number, re-enter ";
    cin.clear();
    cin.ignore(999,'\n');
    //cin.ignore(numeric_limits<streamsize>::max(),'\n'); // correct but ugly
  }
  return n;
}

int get_num_in_range(int low,int high) { // get number, validate range
  int n;
  for (n = get_num(); n < low || n > high ; n = get_num())
    cout << "out of range, re-enter ";
  return n;
}

int main() {
  int num;
  cout << "enter number ";
  num = get_num();
  //num = get_num_in_range(0,10);
  cout << "number is "<<num << endl;
}

/*
test cases
small number
out-of-range number
non-number
 */
