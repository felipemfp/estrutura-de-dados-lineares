/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysequence;

/**
 *
 * @author felipe
 */
public interface ISequence {
    public Node atRank(int r);
    public int rankOf(Node n);
    
    public int size();
    public boolean isEmpty();    
    
    public boolean isFirst(Node n);
    public boolean isLast(Node n);
    
    public Object first();
    public Object last();
    public Object before(Node n);
    public Object after(Node n);
    
    public Object elemAtRank(int r);
    
    public Object replaceAtRank(int r, Object o);    
    public void replaceElement(Node n, Object o);
    public void swapElements(Node n, Node q);
    
    public void insertBefore(Node n, Object o);
    public void insertAfter(Node n, Object o);
    
    public void insertFirst(Object o);
    public void insertLast(Object o);
    
    public void insertAtRank(int r, Object o);
    
    public Object remove(Node n);    
    public Object removeAtRank(int r);
}
