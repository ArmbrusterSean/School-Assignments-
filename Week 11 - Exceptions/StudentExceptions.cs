using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudentExceptions
{
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, double> grades = new Dictionary<string, double>();

            double sum = 0;
            double min = 101;
            string minName = "";
            double max = 0;
            string maxName = "";

            try
            {
                StreamReader inputFile;

                inputFile = File.OpenText("input.txt");

                while (!inputFile.EndOfStream)
                {
                    string name = inputFile.ReadLine();
                    double grade = double.Parse(inputFile.ReadLine());

                    grades.Add(name, grade);

                }


            }
            catch (Exception e)
            {
                Console.WriteLine("Exception: {0}", e.Message);
                Console.WriteLine("Source: {0}", e.Source);
                Console.WriteLine("StackTrace: {0}", e.StackTrace);
                Console.WriteLine("TargetSite: {0}", e.TargetSite);
                Console.ReadLine();
            }


            try
            {
                foreach (string student in grades.Keys)
                {
                    if (grades[student] < 0)
                        throw new NegativeGrades();
                    else
                    {
                        sum += grades[student];
                        if (grades[student] > max)
                        {
                            max = grades[student];
                            maxName = student.ToString();

                        }

                        if (grades[student] < min)
                        {
                            min = grades[student];
                            minName = student;
                        }

                    }
                }

            }
            catch (NegativeGrades e)
            {
                e.LowerThan0();
            }

            try
            {
                double avg = sum / grades.Count;

                if (avg < 60)
                    throw new LowAverage();
                else
                {
                    using (StreamWriter sw = new StreamWriter("output.txt"))
                    {
                        sw.WriteLine("Class Average: {0}", avg);
                        sw.WriteLine("Highest Scoring Student: {0}", maxName);
                        sw.WriteLine("Highest Score: {0}", max);
                        sw.WriteLine("Lowest Scoring Student:  {0}", minName);
                        sw.WriteLine("Class Average: {0}", min);
                    }

                }

            }
            catch (LowAverage e)
            {
                e.LowerThan60();
            }


        } // end main
    } // end class

    // new exception Classes

    class LowAverage : Exception
    {
        public void LowerThan60()
        {
            Console.WriteLine("Average not up to NC State standards. Class is eliminated.");
        }
    }

    class NegativeGrades : Exception
    {
        public void LowerThan0()
        {
            Console.WriteLine("Invalid data. Please check file.");
        }
    }
}
