
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
public class SelectSort implements SortAlgorithm {
    
    private Object[] _sort(Object[] collection, Comparator comparator) {
        for (int i = 0; i < collection.length - 2; i++) {
            for (int j = i + 1; j < collection.length - 1; j++) {
                if (comparator.compare(collection[j], collection[i]) < 0) {
                    Object aux = collection[j];
                    collection[j] = collection[i];
                    collection[i] = aux;
                }
            }
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
