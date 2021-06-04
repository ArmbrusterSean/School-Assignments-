using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdvancedLINQ
{
    class Program
    {
        static void Main(string[] args)
        {

            List<Student> studentList = new List<Student>() {
            new Student() { StudentID = 101, StudentName = "Roy", Age = 18, StandardID = 1 } ,
            new Student() { StudentID = 202, StudentName = "Steve",  Age = 21, StandardID = 1 } ,
            new Student() { StudentID = 303, StudentName = "Carrie",  Age = 18, StandardID = 2 } ,
            new Student() { StudentID = 404, StudentName = "Rob" , Age = 20, StandardID = 2 } ,
            new Student() { StudentID = 505, StudentName = "Evelyn" , Age = 21, StandardID = 3 }
            };

            List<Standard> standardList = new List<Standard>() {
            new Standard(){ StandardID = 1, StandardName="Excellent"},
            new Standard(){ StandardID = 2, StandardName="Good"},
            new Standard(){ StandardID = 3, StandardName="Not Recommended"}
            };

            // Example of multiple WHERE clauses
            // => are lambda expressions - 
            // https://docs.microsoft.com/en-us/dotnet/csharp/programming-guide/statements-expressions-operators/lambda-expressions

            var studentNames = studentList.Where(s => s.Age > 19)
                              .Select(s => s)
                              .Where(st => st.StandardID > 1)
                              .Select(s => s.StudentName);

            Console.WriteLine("Multiple WHERE clauses:");

            foreach (var name in studentNames)
            {
                Console.WriteLine(name);
            }

            Console.WriteLine("--------------------------");
            Console.ReadLine();

            ////////////////////// Using && in Where clause
            var teenStudentsName = from s in studentList
                                   where s.Age > 12 && s.Age < 20
                                   select new { StudentName = s.StudentName };

            Console.WriteLine("List of students between 13 - 19:");
            teenStudentsName.ToList().ForEach(s => Console.WriteLine(s.StudentName));

            Console.WriteLine("--------------------------");
            Console.ReadLine();


            /////////////////////////////// example of order by
            var sortedStudents = from s in studentList
                                 orderby s.StandardID, s.Age
                                 select new
                                 {
                                     StudentName = s.StudentName,
                                     Age = s.Age,
                                     StandardID = s.StandardID
                                 };

            Console.WriteLine("Order by Standard ID and Age:");
            sortedStudents.ToList().ForEach(s => Console.WriteLine("Student Name: {0}, Age: {1}, StandardID: {2}", s.StudentName, s.Age, s.StandardID));

            Console.WriteLine("--------------------------");
            Console.ReadLine();



            ///////////////////////////// Example of grouping
            var studentsGroupByStandard = from s in studentList
                                          group s by s.StandardID into sg
                                          orderby sg.Key
                                          select new { sg.Key, sg };   // this will create 3 groups - standard ID

            Console.WriteLine("List of students group by standard:");
            foreach (var group in studentsGroupByStandard)
            {
                Console.WriteLine("StandardID {0}:", group.Key);  // this will display the standard

                group.sg.ToList().ForEach(st => Console.WriteLine(st.StudentName));  // this will display student name(s) 
            }

            Console.WriteLine("--------------------------");
            Console.ReadLine();

            //////////////////////////////// Example of left outer join to group like example above but with standards
            var studentsGroup = from stan in standardList
                                join s in studentList
                                on stan.StandardID equals s.StandardID
                                    into sg
                                select new
                                {
                                    StandardName = stan.StandardName,
                                    Students = sg
                                };

            Console.WriteLine("Left outer join:");
            foreach (var group in studentsGroup)
            {
                Console.WriteLine(group.StandardName + ":");  // display standard

                group.Students.ToList().ForEach(st => Console.WriteLine(st.StudentName)); // display name(s) with standard
            }

            Console.WriteLine("--------------------------");
            Console.ReadLine();

            //////////////////////////////////////////// example of inner join
            var studentWithStandard = from s in studentList
                                      join stad in standardList
                                      on s.StandardID equals stad.StandardID
                                      select new
                                      {
                                          StudentName = s.StudentName,
                                          StandardName = stad.StandardName
                                      };

            Console.WriteLine("Inner Join:");
            studentWithStandard.ToList().ForEach(s => Console.WriteLine("{0} has a standard of {1}", s.StudentName, s.StandardName));

            Console.WriteLine("--------------------------");
            Console.ReadLine();

 

        } // end main
    } // end class

    class Student
    {
        public int StudentID { get; set; }
        public string StudentName { get; set; }
        public int Age { get; set; }
        public int StandardID { get; set; }
    } // end class

    class Standard
    {
        public int StandardID { get; set; }
        public string StandardName { get; set; }
    } // end class
} // end namespace

