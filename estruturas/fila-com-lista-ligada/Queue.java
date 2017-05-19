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
    private QueueNode first;
    private QueueNode last;
    private int length;

    public Queue() {
        length = 0;
    }
    
    @Override
    public Object dequeue() throws EEmptyQueue {
        if (this.isEmpty()) {
            throw new EEmptyQueue();
        }
        
        QueueNode nodeFirst = this.first();
        
        Object o = nodeFirst.getValue();
        this.first = nodeFirst.getNext();
        
        nodeFirst.setNext(null);
        length--;
        return o;
    }

    @Override
    public void enqueue(Object o) {
        QueueNode enqueued = new QueueNode(o);
        
        if (this.isEmpty()) {
            this.first = enqueued;
        } else if (this.last == null) {
            this.last = enqueued;
            this.first.setNext(this.last);
        } else {
            this.last.setNext(enqueued);
            this.last = enqueued; 
        }
        length++;
    }

    @Override
    public Object getNext() throws EEmptyQueue {
        if (this.isEmpty()) {
            throw new EEmptyQueue();
        }
        
        return this.first.getValue();
    }

    @Override
    public int getSize() {
        return this.length;
    }

    @Override
    public boolean isEmpty() {
        return (this.first == null);
    }
    
}
