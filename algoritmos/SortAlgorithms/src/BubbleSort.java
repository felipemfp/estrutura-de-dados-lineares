
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author felipe
 */
public class BubbleSort implements SortAlgorithm {

    private void swap(Object[] a, int i, int j) {
        Object aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }

    private Object[] _sort(Object[] collection, Comparator comparator) {
        for (int i = 0; i < collection.length - 1; i++) {
            for (int j = 0; j < collection.length - 1 - i; j++) {
                if (comparator.compare(collection[j], collection[j + 1]) > 0) {
                    swap(collection, j, j + 1);
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
