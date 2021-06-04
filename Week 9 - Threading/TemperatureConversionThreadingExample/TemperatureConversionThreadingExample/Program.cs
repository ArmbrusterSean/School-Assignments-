using System;
using System.Threading;

namespace TemperatureConversionThreadingExample
{
    class Program
    {
        static void Main(string[] args)
        {
            Task1 t1 = new Task1();
            Task2 t2 = new Task2();

            // pause 
            Console.ReadLine();
        } // end main 
    } // end Class 

    public class Task1
    {
        // constructor
        public Task1()
        {
            Thread t1 = new Thread(new ThreadStart(fahr2Cel));
            t1.Start();
            t1.Join(); // finish before you start the next thread 
        } // end Constructor 

        void fahr2Cel()
        {
            for (int f = 10; f <= 100; f++)
            {
                Console.WriteLine(f + " degrees fahrenheit is " + ((f - 32) / 1.8) + " degrees Celsius");
            }
        } // end void method 

    } // end Task1 Class 


    public class Task2
    {
        // constructor
        public Task2()
        {
            Thread t2 = new Thread(new ThreadStart(fahr2Kel));
            t2.Start();
        } // end Constructor 

        void fahr2Kel()
        {
            for (int f = 10; f <= 100; f++)
            {
                Console.WriteLine(f + " degrees fahrenheit is " + ((f + 459.67) / 1.8) + " degrees Kelvin");
            }
        } // end void method 

    } // end Task1 Class 




} // end namespace
