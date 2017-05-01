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
public class QueueNode {
    private Object value;
    private QueueNode next;
    
    public QueueNode(Object value) {
        this.value = value;        
    }
    
    public Object getValue() {
        return this.value;
    }
    
    public void setNext(QueueNode node) {
        this.next = node;
    }
    
    public QueueNode getNext() {
        return this.next;
    }
}
