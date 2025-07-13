using System;

class Program {
    static void Main()
    {
        Func<int> helloWorld = () =>
        {
            string word = "Hello, World!";

            for (int i = 1; i <= word.Length; i++)
            {
                Thread.Sleep(1000);
                Console.WriteLine(word.Substring(0, i));
            }

            return -1;
        };

        helloWorld();
    }
}
