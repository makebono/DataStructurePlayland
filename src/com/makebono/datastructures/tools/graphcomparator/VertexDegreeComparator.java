package com.makebono.datastructures.tools.graphcomparator;

import java.util.Comparator;

import com.makebono.datastructures.graph.Vertex;

/** 
 * @ClassName: VertexDegreeComparator 
 * @Description: Compare the degree of vertices. In reversed order.
 * @author makebono
 * @param <T>
 * @date 2018年1月16日 下午3:20:04 
 *  
 */
public class VertexDegreeComparator<T> implements Comparator<Vertex<T>> {
    @Override
    public int compare(final Vertex<T> o1, final Vertex<T> o2) {
        if (o1.getEdges().size() > o2.getEdges().size()) {
            return -1;
        } else if (o1.getEdges().size() < o2.getEdges().size()) {
            return 1;
        }
        return 0;
    }

}
