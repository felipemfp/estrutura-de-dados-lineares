/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystack;

/**
 *
 * @author guest-BJ2kKf
 */
public class Stack implements IStack{
    private int size;
    private Object[] stack;
    private int constant;

    public Stack() throws Exception {
        this(0);
    }
    
    public Stack(int constant) throws Exception {
        if (constant < 0) {
            throw new EInvalidConstant();
        }
        this.constant = constant;
        this.size = 0;
        this.stack = new Object[20];
    }
     
    @Override
    public Object pop() throws Exception {
        if (this.isEmpty()) {
            throw new EEmptyStack();
        }
        Object o = this.stack[--size];
        this.stack[size] = null;
        return o;
    }

    @Override
    public void push(Object o) {
        if (size == this.stack.length) {
            if (this.constant == 0) {
                this.duplicate();
            }
            else {
                this.expand();
            }
        }
        this.stack[size++] = o;
    }

    @Override
    public Object top() throws Exception {
        if (this.isEmpty()) {
            throw new EEmptyStack();
        }
        return this.stack[size];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    private void expand() {
        this.stack = this.makeStack(this.stack, this.size + this.constant);
    }
    
    private void duplicate() {
        this.stack = this.makeStack(this.stack, this.size * 2);
    }
    
    private Object[] makeStack(Object[] stack, int newSize) {
        Object[] s = new Object[newSize];
        for (int i = 0; i < stack.length; i++) {
            s[i] = stack[i];
        }
        return s;
    }
}
