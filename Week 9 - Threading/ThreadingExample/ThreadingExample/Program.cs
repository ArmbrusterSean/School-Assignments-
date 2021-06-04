using System;
using System.Threading;


namespace ThreadingExample
{
    class Program
    {
        static void Main(string[] args)
        {

            Task1 task1 = new Task1();
            Task2 task2 = new Task2();

            //pause 
            Console.ReadLine();

        }
    } // end main 

    public class Task1
    {
        // constructor
        public Task1()
        {
            Thread t1 = new Thread(new ThreadStart(doSomething));
            t1.Start();
            
        }

        void doSomething()
        {
            for (int i = 1; i < 100; i++)
                Console.WriteLine("Task 1 is running " + i + " times.");
        }
    } // end Task1

    public class Task2
    {
        // constructor
        public Task2()
        {
            Thread t2 = new Thread(new ThreadStart(doSomething));
            t2.Start();
        }

        void doSomething()
        {
            for (int i = 1; i < 100; i++)
                Console.WriteLine("Task 2 is running " + i + " times.");
        }
    } // end Task1


} // end namespace 
