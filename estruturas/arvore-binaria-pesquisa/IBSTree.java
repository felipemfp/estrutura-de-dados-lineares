/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybinarysearchtree;

import java.util.Iterator;

/**
 *
 * @author felipemfp
 */
public interface IBSTree  {
    
    public int size();
    public boolean isEmpty();
    public int height();
    public int depth(Node n);
    public Iterator elements();
    public Iterator nodes();
    
    public Node root();
    public Node parent(Node n);
    public Node leftChild(Node n);
    public Node rightChild(Node n);
    public Node sibling(Node n);    
    
    public boolean isInternal(Node n);
    public boolean isExternal(Node n);
    public boolean isRoot(Node n);
    public boolean hasLeftChild(Node n);
    public boolean hasRightChild(Node n);
    public boolean hasSibling(Node n);
    
    public Node find(Object k);
    public void insert(Object k, Object o);
    public Object remove(Object k) throws InvalidKeyException;

}
