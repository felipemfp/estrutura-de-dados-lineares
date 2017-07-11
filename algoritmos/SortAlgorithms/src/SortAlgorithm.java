
import java.util.Comparator;
import java.util.concurrent.Callable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author felipe
 */
interface SortAlgorithm {
    public Object[] sort(Object[] collection, Comparator comparator);
}
