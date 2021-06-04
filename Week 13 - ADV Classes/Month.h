/**
* 
* Sean Armbruster 
* CSC 134 
* Ch 14 Month Class 
* 
* This is the header file that contains the Month class
**/

#pragma once


#ifndef MONTH_H
#define MONTH_H

#include <string>
#include <iostream>

using namespace std;

// Month class declaration
class Month
{
private:
    string name;
    int monthNumber;

    // static array to hold month numbers 
    static string monthNames[12];

public:

    // default constructor

    Month() {
        name = "January";
        monthNumber = 1;
    }

    // Overloaded constructor that accepts name of each month 
    Month(string n) {
        // loop through all monthNames in static array
        for (int i = 0; i < 12; i++) {
            // check for match between input and month name 
            if (n == monthNames[i]) {
                name = n;
                monthNumber = i + 1;
                break;
            }

            // check if loop has been broken 
            if (i == 11) {
                cout << "Not a valid month name!" << endl;
            }
        }
    }

    // Overloaded constructor that accepts the number of the month 
    Month(int num) {
        if (num < 1 || num > 12)
        {
            cout << "Not a valid month number!" << endl;
        }
        //if input is valid 
        else {
            // set monthNumber to input 
            monthNumber = num;
            name = monthNames[num - 1];
        }
    }

    // getter functions for name
    string getName() const {
        return name;
    }
    // getter function for monthNumber 
    int getMonthNumber() const {
        return monthNumber;
    }

    // setter function for name 
    void setName(string n) {
        // loop monthNames in static array 
        for (int i = 0; i < 12; i++) {
            //check for match, if so then set name and monthNumber 
            if (n == monthNames[i]) {
                name = n;
                monthNumber = i + 1;
                break;
            }

            // check if loop has broken 
            if (i == 11) {
                cout << "Not a valid month name!" << endl;
            }
        }
    }

    // setter function for monthNumber 
    void setMonthNumber(int num) {
        // input validation 
        if (num < 1 || num > 12) {
            cout << "Not a valid month number!" << endl;
        }
        else {
            monthNumber = num;
            name = monthNames[num - 1];
        }
    }

    // overload prefix ++ operator
    Month operator++() {
        // check if last month 
        if (monthNumber == 12) {
            // set to first month 
            monthNumber = 1;
            name = monthNames[0];
        }
        else {
            // pre-increment month number 
            ++monthNumber;
            name = monthNames[monthNumber - 1];
        }

        // return modified calling object 
        return *this;
    }

    // overloaded postfix ++ operator 
    Month operator++(int) {
        // check for last month 
        if (monthNumber == 12) {
            // set to first month 
            monthNumber = 1;
            name = monthNames[0];
        }
        else {
            // post increment monthNumber
            monthNumber++;
            name = monthNames[monthNumber - 1];
        }

        // return modified calling object 
        return *this;
    }

    // overloaded prefix -- operator 
    Month operator--() {
        //check for fisrt month 
        if (monthNumber == 1) {
            //set to last month 
            monthNumber = 12;
            name = monthNames[11];
        }
        else {
            // pre decrement monthNumber 
            --monthNumber;
            name = monthNames[monthNumber - 1];
        }

        //return modified calling object 
        return *this;
    }

    // overloaded postfix -- operator 
    Month operator--(int) {
        // check for first month 
        if (monthNumber == 1) {
            // set to last month 
            monthNumber = 12;
            name = monthNames[11];
        }
        else {
            // post decrement monthNumber 
            monthNumber--;
            name = monthNames[monthNumber - 1];
        }

        //return modified caller object 
        return *this;
    }

    // overload cout << operator 
    friend ostream &operator  << (ostream &strm, const Month &obj) {
        strm << "Month: " << obj.monthNumber << ", " << obj.name;
        return strm;
    }

    // overload cin >> operator 
    friend istream &operator >> (istream &strm, Month &obj) {
        // prompt for month number 
        cout << "Month Number: ";
        strm >> obj.monthNumber;

        // input validation 
        if (obj.monthNumber < 1 || obj.monthNumber > 12) {
            cout << "Not a valid month number!" << endl;
        }

        // set month name 
        obj.name = monthNames[obj.monthNumber - 1];

        // return strm object 
        return strm;
    }

};

// static array monthNames declaration 
string Month::monthNames[12] = { "January", "February", "March",
                                "April", "May", "June",
                                "July", "August", "September",
                                "October", "November", "December" };


#endif 

