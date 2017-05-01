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
public class MyQueue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EEmptyQueue {
        Queue queue = new Queue();
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        
        System.out.println("Next: " + queue.getNext());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Next: " + queue.getNext());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Next: " + queue.getNext());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Next: " + queue.getNext());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Amount of values: " + queue.getSize());
        System.out.println("Next: " + queue.getNext());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Next: " + queue.getNext());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Next: " + queue.getNext());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Amount of values: " + queue.getSize());
    }
    
}
