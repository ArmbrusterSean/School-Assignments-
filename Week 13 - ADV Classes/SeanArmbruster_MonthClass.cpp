/**
* Sean Armbruster 
* CSC 134 
*
* Ch. 14 Month Class Program 
* 
* this is the main Main file 
*
**/

#include <iostream>
#include <string>
#include "Month.h"
using namespace std;

int main()
{
    // month objects
    Month myMonthOne;              // default constructor - sets to 1, January 
    Month myMonthTwo("October");   // overloaded constructor - sets to 8, August
    Month myMonthThree(4);        // overloaded constructor - sets to March, 3  

    cout << "-----------------Getter Functions----------------------" << endl;

    // output values using getter functions 
    cout << "Object myMonthOne: " << myMonthOne.getMonthNumber() << ", " << myMonthOne.getName() << endl;       // first object 
    cout << "Object myMonthTwo: " << myMonthTwo.getMonthNumber() << ", " << myMonthTwo.getName() << endl;       // second object
    cout << "Object myMonthThree: " << myMonthThree.getMonthNumber() << ", " << myMonthThree.getName() << endl;     // third object 
    
    cout << "------------------------------------------" << endl;

    // change values with the setter functions
    myMonthOne.setName("October");
    myMonthTwo.setMonthNumber(7);

    cout << "------------------Overloaded << operator --------------------" << endl;

    // output using overloaded << operator 
    cout << myMonthOne << endl;     // myMonthOne Object
    cout << myMonthTwo << endl;     // myMonthTwo object
    cout << myMonthThree << endl;   // myMonthThree object 

    cout << "-----------------Overloaded >> operator----------------------" << endl;

    // output using overloaded >> operator 
    // myMonthOne Input & Ouput    
    cin >> myMonthThree;
    cout << myMonthThree << endl;

    cout << "---------------Overloaded pre and postfix ++ operators------------------------" << endl;

    // overloaded prefix operator 
    ++myMonthOne;
    cout << myMonthOne << endl;
 
    // overloaded postfix operator 
    myMonthTwo++;
    cout << myMonthTwo << endl;

    cout << "---------------Overloaded pre and postfix -- operators ------------------------" << endl;

    // overloaded prefix -- operator 
    --myMonthOne;
    cout << myMonthOne << endl;

    // overloaded postfix -- operator 
    --myMonthTwo;
    cout << myMonthTwo << endl;

    return 0;
}

