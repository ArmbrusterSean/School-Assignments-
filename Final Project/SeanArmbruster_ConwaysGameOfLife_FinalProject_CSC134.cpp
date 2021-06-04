/**
* Sean Armbruster 
* CSC 134 
* 
* Final Project 
* Conway's Game of Life 
**/

#include <iostream>

using namespace std;

// inner board dimensions 20x20
const int WIDTH = 20,
HEIGHT = 20;

// This function displays the board 
void displayBoard(int board[HEIGHT][WIDTH])
{
	for (int i = 0; i < HEIGHT; i++)
	{
		for (int j = 0; j < WIDTH; j++)
		{
			if (board[i][j] == 1)
				cout << "*";
			else
				cout << " ";
		}
		cout << endl;
	}
}

// this funciton makes a copy of the board 
void copyBoard(int board1[HEIGHT][WIDTH], int board2[HEIGHT][WIDTH])
{
	for (int i = 0; i < HEIGHT; i++)
	{
		for (int j = 0; j < WIDTH; j++)
		{
			board2[i][j] = board1[i][j];
		}
	}
}

// This function performs the calculations for the cell interaction on the board. 
void newBoard(int board[HEIGHT][WIDTH])
{
	int tempBoard[HEIGHT][WIDTH];
	int neighbor;

	for (int i = 0; i < HEIGHT; i++)	
	{
		for (int j = 0; j < WIDTH; j++)
		{
			// if cell is dead, element is 0
			if (i == 0 || j == 0)
				tempBoard[i][j] = 0;

			// else count the neighboring cells 
			else
			{
				neighbor = board[i - 1][j - 1] +
					       board[i - 1][j] +
					       board[i - 1][j + 1] +
					       board[i][j - 1] + 
					       board[i][j + 1] + 
					       board[i + 1][j - 1] + 
					       board[i + 1][j] +
					       board[i + 1][j + 1];	

				// if cell is overcrowded or doesn't have enough neighboring cells, it dies.
				if (board[i][j] == 1)
				{
					if (neighbor < 2 || neighbor > 3)
						tempBoard[i][j] = 0;
					else
						tempBoard[i][j] = 1;
				}
				// when cell has three neighbors, create cell. 
				else
				{
					if (neighbor == 3)
						tempBoard[i][j] = 1;
					else
						tempBoard[i][j] = 0;
				}
			}
		}
	}
	// copy the resutls 
	copyBoard(tempBoard, board);
}

int main()
{
	char next;
	int count = 0;

	//live cells = 1
	//dead cells = 0
	int board[HEIGHT][WIDTH] = {
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
	};

	// Each time user presses Enter/Return, the new board which derives from the copied board with the added changes of cell structure will be displayed. 
	do
	{
		displayBoard(board);
		cin.get(next);		// read by char 
		newBoard(board);
		count += 1;
		cout << "Generation # " << count << endl;
	} while (next == '\n');

	return 0;
}




