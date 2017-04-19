/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myqueue;

/**
 *
 * @author guest-krsp21
 */
public interface IQueue {
    Object dequeue() throws EEmptyQueue;
    void enqueue(Object o);
    Object next() throws EEmptyQueue;
    int size();
    boolean isEmpty();
}
