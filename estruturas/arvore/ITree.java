/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytree;

import java.util.Iterator;

/**
 *
 * @author felipemfp
 */
public interface ITree  {
    
    public int size();
    public boolean isEmpty();
    public int height();
    public Iterator elements();
    public Iterator nodes();
    
    public Node root();
    public Node parent(Node n);
    public Iterator children(Node n);
    
    public boolean isInternal(Node n);
    public boolean isExternal(Node n);
    public boolean isRoot(Node n);
    public int depth(Node n);
    
    public void addChild(Node n, Object o);
    public Object replace(Node n, Object o);
    public Object remove(Node n) throws InvalidNodeException;
    public void swap(Node n, Node m);
    
}
