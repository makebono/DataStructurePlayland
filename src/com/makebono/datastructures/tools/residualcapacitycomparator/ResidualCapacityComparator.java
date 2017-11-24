package com.makebono.datastructures.tools.residualcapacitycomparator;

import java.util.Comparator;

import com.makebono.datastructures.graph.Edge;

/** 
 * @ClassName: ResidualCapacityComparator 
 * @Description: Comparator for residual capacity
 * @author makebono
 * @date 2017年11月24日 上午10:54:20 
 *  
 */
public class ResidualCapacityComparator<T> implements Comparator<Edge<T>> {

    @Override
    public int compare(final Edge<T> e1, final Edge<T> e2) {
        if (e1.getResidualCapacity() > e2.getResidualCapacity()) {
            return 1;
        } else if (e1.getResidualCapacity() < e2.getResidualCapacity()) {
            return -1;
        }
        return 0;
    }

}
