/**
* 
* Sean Armrbuster 
* CSC 134 
* Ch 16 # 7
* Test Scores Class Program 
**/


#include <iostream>
#include <string>
using namespace std;

class TestScores {
private:
	double* ptr;		// pointer to array 
	int arraySize;		// hold the size of array 

public:
	// Constructor 
	// accepts an array of test scores as arguments. 
	TestScores(double a[], int s) {
		arraySize = s;					// assign number of elements 

		// input validation 
		for (int i = 0; i < arraySize; i++) {
			// initialize exception string 
			string error = "Not a valid test score for test #: ";
			if (a[i] < 0 || a[i] > 100) {
				// update exception string 
				error += to_string(i + 1);
				throw error;
			}
		}

		// if exception not thrown, get values of object array 
		ptr = new double[arraySize];
		for (int i = 0; i < arraySize; i++) {
			*(ptr + i) = a[i];
		}
	}

	// this funcitno gets average of the object array 
	double getAverage() {
		double total = 0.0;

		for (int i = 0; i < arraySize; i++) {
			total += *(ptr + i);
		}

		return (double)total / arraySize;
	}
};

int main()
{
	// each scores array holds five test score values
	double scores1[5] = { 88, 88, 80, 91, 68 };
	double scores2[5] = { 71, 68, 90, 81, 88 };

	// display contents of each array 
	cout << "Student 1 Grades: " << endl;
	for (int i = 0; i < 5; i++) {
		cout << scores1[i] << endl;
	}

	cout << "------------------------" << endl;

	cout << "Student 2 Grades : " << endl;
	for (int i = 0; i < 5; i++) {
		cout << scores2[i] << endl;
	}

	cout << "------------------------" << endl;

	// try creating TestScores Objects and initializing them to scores array. 
	// If scores contain a grade out of bounds the exception will be thrown
	try {
		TestScores test1(scores1, sizeof(scores1) / sizeof(double));
		cout << "Student 1 Test Average: " << test1.getAverage() << endl;

		TestScores test2(scores2, sizeof(scores2) / sizeof(double));
		cout << "Student 2 Test Average: " << test2.getAverage() << endl;
	}
	catch (string msg) {
		cout << "Error! " << endl;
		cout << msg << endl;
	}

	return 0;
}
