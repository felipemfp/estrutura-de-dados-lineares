
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

    public Object[] _sort(Object v[], Comparator c, int esquerda, int direita) {
        int esq = esquerda, dir = direita;
        Object pivo = v[rand.nextInt(direita - esquerda + 1) + esquerda], aux;

        while (esq <= dir) {
            while (c.compare(v[esq], pivo) < 0) {
                esq++;
            }
            while (c.compare(v[dir], pivo) > 0) {
                dir--;
            }
            if (esq <= dir) {
                aux = v[esq];
                v[esq] = v[dir];
                v[dir] = aux;
                esq++;
                dir--;
            }
        }

        if (dir > esquerda) {
            _sort(v, c, esquerda, dir);
        }
        if (esq < direita) {
            _sort(v, c, esq, direita);
        }

        return v;
    }

    @Override
    public Object[] sort(Object[] collection, Comparator comparator) {
        Object copy[] = new Object[collection.length];
        System.arraycopy(collection, 0, copy, 0, collection.length);
        return _sort(copy, comparator, 0, copy.length - 1);
    }

}
