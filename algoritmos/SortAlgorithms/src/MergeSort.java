
import java.util.Arrays;
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
public class MergeSort implements SortAlgorithm {

    private Object[][] partition(Object[] s, int i) {
        Object[] s1 = new Object[i];
        Object[] s2 = new Object[s.length - i];

        int k = 0;
        for (int j = 0; j < s.length; j++) {
            if (j < i) {
                s1[k] = s[j];
            } else {
                s2[k] = s[j];
            }
            k = (k + 1) % i;
        }

        return new Object[][]{s1, s2};
    }

    private Object[] merge(Object[] s1, Object[] s2, Comparator c) {
        Object[] s = new Object[s1.length + s2.length];

        int k;
        int k1;
        int k2 = k1 = k = 0;

        while (k1 < s1.length && k2 < s2.length) {
            if (c.compare(s1[k1], s2[k2]) < 0) {
                s[k++] = s1[k1++];
            } else {
                s[k++] = s2[k2++];
            }
        }

        while (k1 < s1.length) {
            s[k++] = s1[k1++];
        }

        while (k2 < s2.length) {
            s[k++] = s2[k2++];
        }

        return s;
    }

    private Object[] _sort(Object[] collection, Comparator comparator) {
        if (collection.length > 1) {
            Object[][] s = partition(collection, (int) Math.ceil(collection.length / 2.0));
            s[0] = _sort(s[0], comparator);
            s[1] = _sort(s[1], comparator);
            collection = merge(s[0], s[1], comparator);
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
