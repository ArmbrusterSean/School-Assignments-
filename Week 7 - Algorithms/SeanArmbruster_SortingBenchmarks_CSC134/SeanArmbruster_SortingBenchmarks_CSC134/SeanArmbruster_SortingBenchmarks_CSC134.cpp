/**
* Sean Armbruster 
* CSC 143 
* Ch 8: Sorting Benchmarks 
* 
* This program uses two sorting algorithms for two identical strings and compares the exchanges 
* 
**/

#include <iostream>
#include <iomanip>
using namespace std;

// prototypes 
void bubbleSort(int[], int, int &);
void selectionSort(int[], int, int &);
void swap(int&, int&);

int main()
{
    // this will store the values exchanges from the algorithms 
    int NUMS_EXCHANGE = 0;

    // arrays and size declaration 
    const int SIZE_NUMS = 20;
    int nums1[SIZE_NUMS] = { 4,7,2,3,7,
                             11,72,23,43,66,
                             12,8,88,4,6,
                             100,22,61,5,4};

    int nums2[SIZE_NUMS] = { 4,7,2,3,7,
                             11,72,23,43,66,
                             12,8,88,4,6,
                             100,22,61,5,4 };


    // call the bubbleSort function and display the results 
    bubbleSort(nums1, SIZE_NUMS, NUMS_EXCHANGE);
    cout << "The number of exchanges for Bubble Sort was: "<< NUMS_EXCHANGE << endl;
    for (int i = 0; i < SIZE_NUMS; i++)
    {
        cout << nums1[i] << endl;
    } // end for 

    cout << "-----------------------------------------------------------" << endl;

    // call the selectionSort function and display the results 
    selectionSort(nums2, SIZE_NUMS, NUMS_EXCHANGE);
    cout << "The number of exchanges for Selection Sort was: " << NUMS_EXCHANGE << endl;
    for (int i = 0; i < SIZE_NUMS; i++)
    {
        cout << nums1[i] << endl;
    } // end for 



} // end main 

void bubbleSort(int array[], int size, int &NUMS_EXCHANGE)
{
    int max;
    int i;

    for (max = size - 1; max > 0; max--)
    {
        for (i = 0; i < max; i++)
        {
            if (array[i] > array[i + 1])
            {
                swap(array[i], array[i + 1]);
                NUMS_EXCHANGE++;

            } // end if
        } // end nested for 
    } // end for 
} // end bubblesort

void selectionSort(int array[], int size, int &NUMS_EXCHANGE)
{
    int minI,
        minV;

    for (int start = 0; start < (size - 1); start++)
    {
        minI = start;
        minV = array[start];
        for (int i = start + 1; i < size; i++)
        {
            if (array[i] < minV)
            {
                minV = array[i];
                minI = i;
                NUMS_EXCHANGE++;

            } // end if 
        } // end nested for 
        swap(array[minI], array[start]);
    } // end for 
}// end selection sort 

void swap(int& a, int& b) 
{
    int temp = a;
    a = b;
    b = temp;
} // end swap 



