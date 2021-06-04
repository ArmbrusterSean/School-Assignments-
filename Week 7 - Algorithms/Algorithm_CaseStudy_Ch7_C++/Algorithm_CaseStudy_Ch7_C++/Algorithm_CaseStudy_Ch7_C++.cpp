// This program produces a sales repoty for DLC, Inc. 
#include <iostream>
using namespace std;
#include<iomanip>

// prototypes 
void calcSales(const int[], const double[], double[], int);
void showOrder(const double[], const int[], int);
void dualSort(int[], double[], int);
void showTotals(const double[], const int[], int);
void swap(double&, double&);
void swap(int&, int&);

int main()
{
	// NUM_PRODS is the number of products produced
	const int NUM_PRODS = 9;

	// array with product ID numbers 
	int id[NUM_PRODS] = { 914, 915, 916, 917, 918,
						  919, 920, 921, 922 };

	// Array with number of units sold for each product
	int units[NUM_PRODS] = { 842, 416, 127, 514, 437,
							 919, 97, 492, 212 };

	// Array with product prices 
	double prices[NUM_PRODS] = { 12.95, 14.95, 18.95, 16.95, 12.95,
								 31.95, 14.95, 14.95, 16.95 };

	// Array to hold the computed sales amounts
	double sales[NUM_PRODS];

	// calculate each product's sales
	calcSales(units, prices, sales, NUM_PRODS);

	// sort the elements in the sales array in descending order
	// order and shuffle the ID numbers in the id array to keep them parallel
	dualSort(id, sales, NUM_PRODS);

	//set the numeric output formatting 
	cout << setprecision(2) << fixed << showpoint;

	// display the products and sales ammounts
	showOrder(sales, id, NUM_PRODS);

	// display total units sold and total sales
	showTotals(sales, units, NUM_PRODS);

	return 0;
} // end main 

/** 
Difinition of calcSales - Accepts units, prices, and sales arrays of arguments. 
The size of these arrays is passed into the num parameter. This function caluculates each 
product's sales by multiplying its units sold by each unit's price. The result is stored in the sales array.
**/
void calcSales(const int units[], const double prices[], double sales[], int num)
{
	for (int i = 0; i < num; i++)
		sales[i] = units[i] * prices[i];

} // end calcSales 

/**
* Definition of function dualSort - Accepts id and sales arrays as arguments. 
The size of these arrays is passed into size. Thois function calculates each product's sale by multiplying
its units sold by each unit's price. The result is stored in the sales array.
**/
void dualSort(int id[], double sales[], int size)
{
	int start,
		maxIndex,
		tempid;
	double maxValue;

	for (start = 0; start < (size - 1); start++)
	{
		maxIndex = start;
		maxValue = sales[start];
		tempid = id[start];
		for (int i = start + 1; i < size; i++)
		{
			if (sales[i] > maxValue)
			{
				maxValue = sales[i];
				tempid = id[i];
				maxIndex = i;
			} // end if 
		} // end nested for 

		swap(sales[maxIndex], sales[start]);
		swap(id[maxIndex], id[start]);

	} // end for 
} // end dualSort 

// The swap function swaps doubles a & b in memory 
void swap(double& a, double& b)
{
	double temp = a;
	a = b;
	b = temp;
} // end swap 

// the swap function swaps ints a & b in memory 
void swap(int& a, int& b)
{
	int temp = a;
	a = b; 
	b = temp;
} // end swap 

/**
* Definition of showOrder function - Accepts sales and id arrays as arguments. The size of these arrays 
* is passed into num. The function first displays a heading, then the sorted list od product numbers and sales
**/
void showOrder(const double sales[], const int id[], int num)
{
	cout << "Product Number\tSales\n";
	cout << "---------------------------------\n";
	for (int i = 0; i < num; i++)
	{
		cout << id[i] << "\t\t$";
		cout << setw(8) << sales[i] << endl;
	} // end for 
	cout << endl;
} // end showOrder 

/**
* Definition of showTotals function - Accepts sales and id arrays as arguments
* The size of these arrays is passed into num. 
* The function first calculates the total units (of all products) sold and the totals sales.
* It displays these ammounts. 
**/
void showTotals(const double sales[], const int units[], int num)
{
	int totalUnits = 0;
	double totalSales = 0.0;

	for (int i = 0; i < num; i++)
	{
		totalUnits += units[i];
		totalSales += units[i];
	} // end for 
	cout << "Total units sold: " << totalUnits << endl;
	cout << "Total saels:	$" << totalSales << endl;
} // end showTotals 