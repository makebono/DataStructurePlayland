package com.makebono.datastructures.tools.graphcomparator;

import java.util.Comparator;

import com.makebono.datastructures.graph.Edge;

/** 
 * @ClassName: GraphComparator 
 * @Description: Comparator for edges' weight, put in priority queue and poll for MST generating.
 * @author makebono
 * @param <T>
 * @date 2017年11月13日 下午1:54:27 
 *  
 */
public class GraphComparator<T> implements Comparator<Edge<T>> {

    @Override
    public int compare(final Edge<T> o1, final Edge<T> o2) {
        if (o1.getWeight() > o2.getWeight()) {
            return 1;
        } else if (o1.getWeight() < o2.getWeight()) {
            return -1;
        }
        return 0;
    }

}
