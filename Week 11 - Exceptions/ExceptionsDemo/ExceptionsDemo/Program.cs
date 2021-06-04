using System;

namespace ExceptionsDemo
{
    class Program
    {
        static void Main(string[] args)
        {
            int value;

            try
            {
                value = 1 / int.Parse("0");     // this will throw an exception 
                Console.WriteLine(value);

            }
            catch (Exception e)
            {
                Console.WriteLine("Messge is {0}", e.Message);          //Default message
                Console.WriteLine("Source is {0}", e.Source);           // Source of Bug 
                Console.WriteLine("Stack trace is {0}", e.StackTrace);  // Location of Bug 
                Console.WriteLine("TargetSite is {0}", e.TargetSite);   // target site of bug 
            }

            Console.WriteLine("--------------------------------\n");

            // array out of bounds exceptions 
            int[] numbers = { 23, 33, 42 };

            try
            {
                foreach (int i in numbers)
                {
                    Console.WriteLine(i);
                }
                Console.WriteLine(numbers[3]);      // out of bounds 
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
            finally
            {
                Console.WriteLine("Executes every time");
            }


            Console.WriteLine("--------------------------------\n");

            // user input exception 
            int grade = 0;

            try
            {
                Console.WriteLine("Enter numeric grade: ");
                grade = int.Parse(Console.ReadLine());
            } 
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                Console.WriteLine(grade + " a new number! Really!?");
            }

            Console.WriteLine(grade);


            Console.WriteLine("--------------------------------\n");


            //custom exceptions 
            int newGrade = 101;

            try
            {
                if (newGrade > 100)
                    throw new MyException1();
                else
                    Console.WriteLine("Grade is valid so far ");

                if (newGrade < 0)
                    throw new MyException2();
                else
                    Console.WriteLine("Grade is valid so far ");
            }
            catch (MyException1 e)
            {
                e.GreaterThan();
            }
            catch (MyException2 e)
            {
                e.LessThan();
            }

            // pause 
            Console.ReadLine();

        }// end main 
    } // end class 

    // new exception class 
    class MyException1: Exception
    {
        public void GreaterThan()
        {
            Console.WriteLine("Error! Grade cannot be greater than 100");
        } // end greatherthan function 
    } // end MyException1 class 


    class MyException2 : Exception
    {
        public void LessThan()
        {
            Console.WriteLine("Error! Grade cannot be less than 0");
        } // end lessthan function 
    } // end MyException2 class 





} // end namespace 
