package com.makebono.datastructures.tools.graphcomparator;

import java.util.Comparator;

import com.makebono.datastructures.graph.Vertex;

/** 
 * @ClassName: VertexIndexComparator 
 * @Description: Compare the index of vertices.
 * @author makebono
 * @param <T>
 * @date 2018年1月16日 下午3:20:04 
 *  
 */
public class VertexIndexComparator<T> implements Comparator<Vertex<T>> {
    @Override
    public int compare(final Vertex<T> o1, final Vertex<T> o2) {
        // System.out.println("がおーココアさん、食べちゃいますよー");
        if (o1.getIndex() > o2.getIndex()) {
            return 1;
        } else if (o1.getIndex() < o2.getIndex()) {
            return -1;
        }
        return 0;
    }

}
