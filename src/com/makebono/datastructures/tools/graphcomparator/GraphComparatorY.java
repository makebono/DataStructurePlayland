package com.makebono.datastructures.tools.graphcomparator;

import java.util.Comparator;

import com.makebono.datastructures.graph.Vertex;

/** 
 * @ClassName: GraphComparatorY 
 * @Description: Compare vertices in a graph by their y coordinates.
 * @author makebono
 * @date 2017年12月21日 下午3:02:39 
 *  
 */
public class GraphComparatorY<T> implements Comparator<Vertex<T>> {
    @Override
    public int compare(final Vertex<T> o1, final Vertex<T> o2) {
        if (o1.getY() > o2.getY()) {
            return 1;
        } else if (o1.getY() < o2.getY()) {
            return -1;
        }
        return 0;
    }
}