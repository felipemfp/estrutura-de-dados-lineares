/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhashtable;

import java.util.Iterator;

/**
 *
 * @author felipemfp
 */
public interface IHashtable {

    public Object findElement(Object k) throws NoSuchKeyException;

    public void insertIElement(Object k, Object o) throws FullTableException;

    public Object removeElement(Object k) throws NoSuchKeyException;

    public int size();

    public boolean isEmpty();

    public Iterator keys();

    public Iterator elements();

}
