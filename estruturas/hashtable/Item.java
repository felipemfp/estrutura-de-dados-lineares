/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhashtable;

/**
 *
 * @author felipemfp
 */
public class Item {

    private Object key;
    private Object element;

    public Item(Object key, Object element) {
        this.key = key;
        this.element = element;
    }

    /**
     * Get the value of key
     *
     * @return the value of key
     */
    public Object getKey() {
        return key;
    }

    /**
     * Get the value of element
     *
     * @return the value of element
     */
    public Object getElement() {
        return element;
    }

}
