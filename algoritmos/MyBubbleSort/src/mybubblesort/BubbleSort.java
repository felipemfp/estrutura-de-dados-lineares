/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybubblesort;

import java.util.Comparator;
import java.util.concurrent.Callable;

/**
 *
 * @author felipe
 */
public class BubbleSort implements Callable<Object[]> {

    private Object a[];
    private Comparator c;

    public BubbleSort(Object[] a, Comparator c) {
        this.a = a;
        this.c = c;
    }

    @Override
    public Object[] call() throws Exception {
        Object b[] = new Object[a.length];
        System.arraycopy(a, 0, b, 0, a.length);

        for (int i = 0; i < b.length - 1; i++) {
            for (int j = 0; j < b.length - 1 - i; j++) {
                if (c.compare(b[j], b[j + 1]) > 0) {
                    swap(b, j, j + 1);
                }
            }
        }

        return b;
    }

    private void swap(Object[] a, int i, int j) {
        Object aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }

}
