using System;

namespace pilha_csharp
{
    class Stack : IStack
    {
        private int control;
        private Object[] stack;
        private int constant;

        private void updateStack(Object[] oldStack, int newLength) {
          this.stack = new Object[newLength];
          for (int i = 0; i < oldStack.Length; i++) {
            this.stack[i] = oldStack[i];
          }
        }

        private void handleFull() {
          if (this.control < this.stack.Length) {
            return;
          }
          int newLength;
          if (this.constant > 0) {
            newLength = this.stack.Length + this.constant;
          } else {
            newLength = this.stack.Length * 2;
          }
          this.updateStack(this.stack, newLength);
        }

        public Stack(int constant = 0) {
          this.control = 0;
          this.constant = constant;
          this.stack = new Object[20];
        }

        public void Push(Object o) {
          this.handleFull();
          int i = this.control;
          this.stack[i] = o;
          this.control++;
        }

        public Object Pop() {
          if (this.IsEmpty()) {
            throw new Exception("Stack is empty! Pop() not allowed.");
          }
          Object o = this.stack[this.control - 1];
          this.stack[this.control - 1] = null;
          this.control--;
          return o;
        }

        public Object Top() {
          if (this.IsEmpty()) {
            throw new Exception("Stack is empty! Top() not allowed.");
          }
          return this.stack[this.control - 1];
        }

        public int GetSize() {
          return this.control;
        }

        public bool IsEmpty() {
          return this.control == 0;
        }
    }
}
