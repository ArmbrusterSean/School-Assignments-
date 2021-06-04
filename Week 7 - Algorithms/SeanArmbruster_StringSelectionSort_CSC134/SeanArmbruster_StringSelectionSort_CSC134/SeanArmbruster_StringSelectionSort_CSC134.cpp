/**
* Sean Armbruster 
* CSC 134 
* Ch. 7: String Selection Sort 
* 
* This program sorts the array of strings in alphabetical order using the selectino sort algorithm
**/

#include <iostream>
#include <string>

using namespace std;

//protoype 
void stringSort(string[], int size);
void swap(string&, string&);


int main()
{
    const int NUM_NAMES = 20;
    string names[NUM_NAMES] = { "Collins, Bill", "Smith, Bart", "Allen, Jim",
                               "Griffin, Jim", "Stamey, Marty", "Rose, Geri",
                               "Alison, Jeff", "Looney, Joe", "Wolfe, Bill",
                               "James, Jean", "Weaver, Jim", "Pore, Bob",
                               "Rutherford, Jean", "Javens, Renee",
                               "Harrison, Rose", "Setzer, Cathy",
                               "Pike, Gordon", "Holland, Beth" };
   
    cout << "Before the Sort: " << endl;
    for (int i = 0; i < NUM_NAMES; i++)
    {
        cout << names[i] << endl;
    } // end for 

    // sort the array of strings 
    stringSort(names, NUM_NAMES);

    cout << "After the Sort: " << endl;
    for (int i = 0; i < NUM_NAMES; i++)
    {
        cout << names[i] << endl;
    } // end for 

    return 0;

} // end main 

/**
* This function sorts the array of strings in alphabetical order using selection sort 
**/
void stringSort(string arr[], int size)
{
    int minI;
    string minV;

    for (int start = 0; start < (size - 1); start++)
    {
        minI = start;
        minV = arr[start];

        for (int i = start + 1; i < size; i++)
        {
            if (arr[i] < minV)
            {
                minV = arr[i];
                minI = i;
            } // end if 
        } // end nested for 

        swap(arr[minI], arr[start]);

    } // end for 
} // end stringSort

void swap(string& a, string& b)
{
    string temp = a;
    a = b;
    b = temp;
} // end swap





