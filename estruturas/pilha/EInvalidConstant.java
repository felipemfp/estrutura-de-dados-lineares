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
public class EInvalidConstant extends Exception {
    
    public EInvalidConstant() {
        super("Constant parameter should be greater than 0.");
    }
}
