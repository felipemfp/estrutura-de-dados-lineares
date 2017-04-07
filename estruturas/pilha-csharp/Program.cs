using System;

namespace pilha_csharp
{
    class Program
    {
        static void Main(string[] args)
        {
            Stack s = new Stack(5);
            for (int i=0; i < 25; i++) {
              s.Push(i);
            }
            Console.WriteLine("Current size of stack: " + s.GetSize());
            for (int i=0; i < 10; i++) {
              s.Pop();
            }
            Console.WriteLine("Current size of stack: " + s.GetSize());
            for (int i=0; i < 150; i++) {
              s.Push(i);
            }
            Console.WriteLine("Current size of stack: " + s.GetSize());
            for (int i=0; i < 165; i++) {
              s.Pop();
            }
            Console.WriteLine("Current size of stack: " + s.GetSize());
            try {
              s.Pop();
            }
            catch (Exception e) {
              Console.WriteLine("Looks like it is empty already..");
            }
        }
    }
}
