/**
 *  Various exxamples on how to use Delegates 
 *  
 *  REMEMBER: To use a delegate: 
 *  1: Declare
 *  2: Initialize 
 *  3: Invoke 
 *  
 **/

using System;

namespace DelegatesExample
{
    class Program
    {
        // declare delegates 

        //example 1 
        public delegate void ShowMessage(string text);

        // example 2 
        public delegate int AddTwoNumbers(int x, int y);

        // example 3 
        public delegate void MyMultiDelegate();

        // example 4 
        public delegate void Print(int value);

        // example 5 - HW Example 
        public delegate void RandomMessage();





        static void Main(string[] args)
        {

            //instance of example 1 
            ShowMessage d = new ShowMessage(ShowText);
            d("Hello World!");

            //example 2 
            AddTwoNumbers e = new AddTwoNumbers(Sum);
            Console.WriteLine(e.Invoke(12, 15));

            // example 3 
            MyMultiDelegate f = null;
            f += Method1;
            f += Method2;
            f.Invoke();

            // example 4 
            PrintHelper(PrintNumber, 1000);
            PrintHelper(PrintMoney, 1000);

            // example 5 - hw example 
            RandomMessage g = new RandomMessage(Message);
            g.Invoke();

            // pause
            Console.ReadLine();
            
        } // end main 

        // example 1 
        public static void ShowText( string text)
        {
            Console.WriteLine(text);
        }

        // example 2 
        public static int Sum(int x, int y)
        {
            return x + y;
        }

        //example 3
        public static void Method1()
        {
            Console.WriteLine("Printing from Method1");
        }
        public static void Method2()
        {
            Console.WriteLine("Printing from Method2");
        }

        // example 4 
        public static void PrintHelper( Print delegateFunc, int numToPrint)
        {
            delegateFunc(numToPrint);
        }

        public static void PrintNumber(int num)
        {
            Console.WriteLine("Number: {0}", num);
        }

        public static void PrintMoney(int num)
        {
            Console.WriteLine("Number: {0:C}", num);
        }

        // example 5 - HW example 
        public static void Message()
        {
            Random r = new Random();
            for(int i = 1; i <= 5; i++)
            {
                int x = r.Next(0, 2);
                if(x == 0)
                {
                    Console.WriteLine("Heads");
                }
                else
                {
                    Console.WriteLine("Tails");
                }
            }
        }
    } // end class Program
} // end namespace 
