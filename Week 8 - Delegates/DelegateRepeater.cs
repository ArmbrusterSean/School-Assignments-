using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DelegateRepeater
{
    class Program
    {

        public delegate void Caller();

        static void Main(string[] args)
        {
            Caller add, sub, mult, div, all;
            add = a;
            sub = s;
            mult = m;
            div = d;
            all = add + sub + mult + div;

            all();

            Console.ReadLine();
        }

        static void a()
        {
            int[,] holder = rand();
            for (int i = 0; i < 100; i++)
            {
                Console.WriteLine("{0} + {1} = {2}", holder[i, 0], holder[i, 1], holder[i, 0] + holder[i, 1]);
            }
        }


        static void s()
        {
            int[,] holder = rand();
            for (int i = 0; i < 100; i++)
            {
                Console.WriteLine("{0} - {1} = {2}", holder[i, 0], holder[i, 1], holder[i, 0] - holder[i, 1]);
            }
        }

        static void m()
        {
            int[,] holder = rand();
            for (int i = 0; i < 100; i++)
            {
                Console.WriteLine("{0} * {1} = {2}", holder[i, 0], holder[i, 1], holder[i, 0] * holder[i, 1]);
            }
        }

        static void d()
        {
            int[,] holder = rand();
            for (int i = 0; i < 100; i++)
            {
                Console.WriteLine("{0} / {1} = {2:f}", holder[i, 0], holder[i, 1], (double)holder[i, 0] / (double)holder[i, 1]);
            }
        }

        static int[,] rand()
        {
            Random rand = new Random();
            int[,] array = new int[100, 2];
            for (int i = 0; i < 100; i++)
            {
                int x = rand.Next(1, 51);
                int y = rand.Next(1, 51);
                if (x > y)
                {
                    array[i, 0] = x;
                    array[i, 1] = y;
                }
                else
                {
                    array[i, 0] = y;
                    array[i, 1] = x;
                }
            }
            return array;
        }


    }
}
