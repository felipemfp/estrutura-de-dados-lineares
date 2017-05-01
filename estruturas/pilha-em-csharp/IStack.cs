using System;

namespace pilha_csharp
{
    interface IStack
    {
        void Push(Object o);
        Object Pop();
        Object Top();
        int GetSize();
        bool IsEmpty();
    }
}
