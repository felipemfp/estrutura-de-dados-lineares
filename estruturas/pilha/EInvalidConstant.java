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
public class EInvalidConstant extends Exception {
    
    public EInvalidConstant() {
        super("Constant parameter should be greater than 0.");
    }
}
