//////////////////////////////////////////////////////////////////                                              //
// CSC 253 - HW - enumeration                            //                                           //
//                                                              //
//  This program:                                               //
//      Defines a HelpDeskCall class                            //
//      Defines a Status enum                                   //
//      Defines a Priority enum                                 //
//                                                              //
//      The main method:                                        //
//          Creates a list of HelpDeskCalls                     //
//          Assigns a note for the call based on the status     //
//          Prints the list of HelpDeskCalls sorted by priority //
//////////////////////////////////////////////////////////////////



using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HelpDeskCallApp
{
    class Program
    {
        /// <summary>
        /// The main method creates a help desk call list, assigns notes based on status, and prints the list
        /// </summary>
        /// <param name="args"></param>
        static void Main(string[] args)
        {
            // create list of help desk calls
            List<HelpDeskCall> helpDeskCallList = new List<HelpDeskCall>()
            {
                new HelpDeskCall {ProblemDesc = "Blue screen of death", DateReported = "2/1/19", Status = Status.Completed,
                    Priority = Priority.High, PersonReported = "Mickey Mouse", Notes = ""},
                new HelpDeskCall {ProblemDesc = "Needs updates", DateReported = "2/2/19", Status = Status.InProg,
                    Priority = Priority.Low, PersonReported = "Minnie Mouse", Notes = ""},
                new HelpDeskCall {ProblemDesc = "Computer keeps crashing", DateReported = "2/3/19", Status = Status.NotStarted,
                    Priority = Priority.Medium, PersonReported = "Donald Duck", Notes = ""},
                new HelpDeskCall {ProblemDesc = "Smoke coming out of tower", DateReported = "2/4/19", Status = Status.Unresolved,
                    Priority = Priority.High, PersonReported = "Daffy Duck", Notes = ""},
                new HelpDeskCall {ProblemDesc = "Monitor flickering", DateReported = "2/5/19", Status = Status.NotStarted,
                    Priority = Priority.Medium, PersonReported = "Road Runner", Notes = ""}
            }; // end help desk call list

            // assign notes for each help desk call in the help desk call list
            AssignNotes(helpDeskCallList);

            // print help desk call list sorted by priority
            Console.WriteLine("Help Desk Call List Sorted By Priority:");
            helpDeskCallList.OrderByDescending(p => p.Priority)
                .ToList()
                .ForEach(p => PrintCallItem(p));

            // pause console
            Console.ReadLine();
        } // end Main method

        /// <summary>
        /// The AssignNotes helper method loops through a help desk call list and assigns 
        /// a note based on the status of the help desk call item
        /// </summary>
        /// <param name="helpDeskCallList">The helpDeskCallList parameter is a list of HelpDeskCall items</param>
        private static void AssignNotes(List<HelpDeskCall> helpDeskCallList)
        {
            foreach (var call in helpDeskCallList)
            {
                switch (call.Status)
                {
                    case Status.NotStarted:
                        call.Notes = "Just reported";
                        break;
                    case Status.InProg:
                        call.Notes = "Help Desk personnel on scene";
                        break;
                    case Status.Completed:
                        call.Notes = "Ticket is complete";
                        break;
                    case Status.Unresolved:
                        call.Notes = "Ongoing investigation";
                        break;
                    default:
                        break;
                }
            }
        } // end AssignNotes method

        /// <summary>
        /// The GetExtraComment helper method returns a comment based on the priority of the HelpDeskCall item
        /// </summary>
        /// <param name="myPriority">The parameter myPriority is the priority of a HelpDeskCall item</param>
        /// <returns>A comment is returned based on the priority of the HelpDeskCall item</returns>
        private static string GetExtraComment(Priority myPriority)
        {
            switch (myPriority)
            {
                case Priority.Low:
                    return "The problem is on the back-burner";
                case Priority.Medium:
                    return "The problem is important";
                case Priority.High:
                    return "The problem is critical";
                default:
                    return "";
            }
        } // end GetExtraComment method

        /// <summary>
        /// The PrintCallItem helper method writes to the console all the attributes of a help desk call item 
        /// plus an extra comment based on priority
        /// </summary>
        /// <param name="myCall">The parameter myCall is a single HelpDeskCall item</param>
        private static void PrintCallItem(HelpDeskCall myCall)
        {
            Console.WriteLine("\n\nProblem Description: " + myCall.ProblemDesc
                    + "\nDate Reported: " + myCall.DateReported
                    + "\nStatus: " + myCall.Status
                    + "\nPriority: " + myCall.Priority
                    + "\nPerson Reporting Problem: " + myCall.PersonReported
                    + "\nNotes: " + myCall.Notes
                    + "\nComment: " + GetExtraComment(myCall.Priority));
        } // end PrintCallItem method
    } // end Program class


    /// <summary>
    /// The HelpDeskCall class contains information to track help desk calls
    /// </summary>
    class HelpDeskCall
    {
        public string ProblemDesc { get; set; }
        public string DateReported { get; set; }
        public Status Status { get; set; }
        public Priority Priority { get; set; }
        public string PersonReported { get; set; }
        public string Notes { get; set; }
    } // end HelpDeskCall class

    /// <summary>
    /// The Status enum is used to support the HelpDeskCall class
    /// </summary>
    enum Status
    {
        NotStarted,
        InProg,
        Completed,
        Unresolved
    } // end Status enum

    /// <summary>
    /// The Priority enum is used to support the HelpDeskCall class
    /// </summary>
    enum Priority
    {
        Low,
        Medium,
        High
    } // end Priority enum
} // end HelpDeskCallApp namespace