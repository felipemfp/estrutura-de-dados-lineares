/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystack;

/**
 *
 * @author Felipe Pontes <felipemfpontes@gmail.com>
 */
public class MyStack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Stack s = new Stack();
        
        for (int i = 0; i < 55; i++) {
            s.push(i);
        }
        
        System.out.println("My stack: " + s.size());
        
        while (!s.isEmpty()) {
            int r = (int) s.pop();
            System.out.println("Returns from stack: " + r);
        }
        
        System.out.println("My stack: " + s.size());
    }
    
}
