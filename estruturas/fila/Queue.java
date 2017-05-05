/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myqueue;

/**
 *
 * @author Felipe Pontes <felipemfpontes@gmail.com>
 */
public class Queue implements IQueue {
    
    private int start;
    private int end;
    private Object[] elements;
    
    public Queue() {
        this(20);
    }
    
    public Queue(int initialLength) {
        start = 0;
        end = 0;
        elements = new Object[initialLength];
    }
    
    private void handleFull() {
        if (size() < elements.length - 1) {
            return;
        }
        
        Object[] elementsCopy = elements;
        elements = new Object[elementsCopy.length * 2];
        
        int ii = start;
        
        for (int ff=0; ff < size(); ff++) {
            elements[ff] = elementsCopy[ii];
            ii = (++ii) % elementsCopy.length;
        }
        
        start = 0;
        end = ff;
    }
    
    @Override
    public Object dequeue() throws EEmptyQueue {
        if (isEmpty()) {
            throw new EEmptyQueue();
        }
        Object o = elements[start];
        elements[start] = null;
        start = (++start) % elements.length;
        return o;
    }

    @Override
    public void enqueue(Object o) {
        handleFull();
        elements[end] = o;
        end = (++end) % elements.length;
    }

    @Override
    public Object next() throws EEmptyQueue {
        if (isEmpty()) {
            throw new EEmptyQueue();
        }
        return elements[start];
    }

    @Override
    public int size() {
        int length = elements.length;
        return (length - start + end) % length;
    }

    @Override
    public boolean isEmpty() {
        return (start == end);
    }
    
}
