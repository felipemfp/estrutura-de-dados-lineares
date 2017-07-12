
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lucas de Lima Rodrigues
 */
public class QuickSort implements SortAlgorithm {

    Random rand = new Random();

    public Object[] _sort(Object v[], Comparator c, int length) {
        if (length > 1) {
            Object[] lowers = new Object[length], equals = new Object[length], biggers = new Object[length];
            Object pivo = v[rand.nextInt(length)];
            int k = 0, kl = 0, ke = 0, kb = 0;

            while (k < length) {
                if (c.compare(pivo, v[k]) == 0) {
                    equals[ke++] = v[k++];
                } else if (c.compare(pivo, v[k]) > 0) {
                    lowers[kl++] = v[k++];
                } else {
                    biggers[kb++] = v[k++];
                }
            }

            lowers = _sort(lowers, c, kl);
            biggers = _sort(biggers, c, kb);

            return merge(lowers, kl, equals, ke, biggers, kb);
        }

        return v;
    }

    private Object[] merge(Object[] l, int ll, Object[] e, int el, Object[] b, int bl) {
        int k = 0;
        Object[] s = new Object[ll + el + bl];
        for (int i = 0; i < ll; i++) {
            s[k++] = l[i];
        }
        for (int i = 0; i < el; i++) {
            s[k++] = e[i];
        }
        for (int i = 0; i < bl; i++) {
            s[k++] = b[i];
        }
        return s;
    }

    @Override
    public Object[] sort(Object[] collection, Comparator comparator) {
        Object copy[] = new Object[collection.length];
        System.arraycopy(collection, 0, copy, 0, collection.length);
        return _sort(copy, comparator, copy.length);
    }

}
