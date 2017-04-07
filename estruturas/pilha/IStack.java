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
public interface IStack {
    Object pop() throws Exception;
    void push(Object o);
    Object top() throws Exception;
    int size();
    boolean isEmpty();
}
