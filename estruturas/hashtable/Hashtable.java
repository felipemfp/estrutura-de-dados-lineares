/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhashtable;

import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author felipemfp
 */
public class Hashtable implements IHashtable {

    private int size;
    private Item table[];

    public Hashtable() {
        size = 0;
        table = new Item[13];
    }

    private int hash(Object k) {
        int y = k.hashCode();
        return y % table.length;
    }

    @Override
    public Object findElement(Object k) throws NoSuchKeyException {
        return table[findIndex(k)].getElement();
    }
    
    private int findIndex(Object k) throws NoSuchKeyException {
        Item c;
        int i = hash(k);
        int p = 0;

        while (p != table.length) {
            c = table[i];
            if (c == null) {
                throw new NoSuchKeyException();
            } else if (c.getKey() == k) {
                return i;
            } else {
                i = (i + 1) % table.length;
                p++;
            }
        }

        throw new NoSuchKeyException();
    }

    @Override
    public void insertIElement(Object k, Object o) throws FullTableException {
        if (size == table.length) {
            throw new FullTableException();
        }
        
        int i = hash(k);
        
        while (table[i] != null && table[i].getClass() != ItemAvailable.class) {
            i = (i + 1) % table.length;            
        }
        
        table[i] = new Item(k, o);
        size++;
    }

    @Override
    public Object removeElement(Object k) throws NoSuchKeyException {
        int i = findIndex(k);
        Object o = table[i].getElement();
        table[i] = new ItemAvailable();
        size--;
        return o;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator keys() {
        Vector v = new Vector();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                v.add(table[i].getKey());
            }
        }
        return v.iterator();
    }

    @Override
    public Iterator elements() {
        Vector v = new Vector();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                v.add(table[i].getElement());
            }
        }
        return v.iterator();
    }
    
    @Override
    public String toString() {
        String s = "";
        
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null || table[i].getClass() == ItemAvailable.class) {
                s += "-- | ";
            } else {
                s += table[i].getKey() + " | ";    
            }            
        }
        
        return s.substring(0, s.length() - 3);
    }
}
