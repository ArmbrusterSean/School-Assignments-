
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace AvgGradeThreading
{
    class Program
    {
        static void Main(string[] args)
        {
            // declare variables
            double avg1 = 0;
            double avg2 = 0;
            string file1 = "student1.txt";
            string file2 = "student2.txt";

            // create new threads using an anonymous delegate (function pointer)
            Thread thread1 = new Thread(delegate () { avg1 = GetAvg(file1); });
            Thread thread2 = new Thread(delegate () { avg2 = GetAvg(file2); });

            // start the threads
            thread1.Start();
            thread2.Start();

            // wait for threads to finish
            thread1.Join();
            thread2.Join();

            // compare results from the 2 threads and display the person with highest average
            if (Math.Max(avg1, avg2) == avg1)
            {
                Console.WriteLine("\nStudent 1 had the highest average.");
            }
            else
            {
                Console.WriteLine("\nStudent 2 had the highest average.");
            }

            // pause console
            Console.ReadLine();
        }

        public static double GetAvg(string myFileName)
        {
            // declare variables
            int grade;
            int sum = 0;
            int numGrades = 0;
            double avg;

            // open file for reading
            StreamReader myFile = new StreamReader(myFileName);

            // read file
            while (!myFile.EndOfStream)
            {
                // if line has data
                if (int.TryParse(myFile.ReadLine(), out grade))
                {
                    // add grade to running total
                    sum = sum + grade;

                    // increment number of grades
                    numGrades++;
                }
            }

            // calc avg grade
            avg = (double)sum / (double)numGrades;

            // display average
            Console.WriteLine("Student " + myFileName[13] + "'s average is {0:F2}.", avg);

            // return average grade
            return avg;
        }
    }
}