
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chicobentojr
 */
public class InsertSort implements SortAlgorithm {

    private Object[] _sort(Object[] collection, Comparator comparator) {
        for (int i = 1; i < collection.length - 1; i++) {
            Object aux = collection[i];
            
            int j = i - 1;
            
            while(j>= 0 && comparator.compare(aux, collection[j]) < 0) {
                collection[j + 1] = collection[j];
                j--;
            }
            collection[j + 1] = aux;
        }
        return collection;
    }
    
    @Override
    public Object[] sort(Object[] collection, Comparator comparator) {
        Object copy[] = new Object[collection.length];
        System.arraycopy(collection, 0, copy, 0, collection.length);
        return _sort(copy, comparator);
    }
    
}
