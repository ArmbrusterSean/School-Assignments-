/**
* Sean Armbruster 
* CSC 134 
* 
* Ch. 16 # 5 
* Total Template Program 
* 
**/

#include <iostream>
using namespace std;

template<class T> 
T total(int numValues) {
    T runningT = 0,         // running total variable 
        value;

    //loop however many times neccessary 
    while (numValues > 0) { 
        cin >> value;
        runningT += value;      // increment running total 
        numValues--;            // decrement counter 
    }

    // return running total 
    return runningT;

}

int main()
{
    cout<< "Int Example: " << total<int>(3) << endl;
    cout << "Double Example: " << total<double>(3) << endl;
    
    return 0;
}

