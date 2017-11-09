package com.makebono.datastructures.tools.roundrobincomparator;

import java.util.Comparator;

/** 
 * @ClassName: RoundRobinComparator 
 * @Description: Comparator for Round Robin scheduling. Accept int[] i as input. i[0] is data and i[1] is considered job load(time).
 * @author makebono
 * @date 2017年11月9日 上午9:48:19 
 *  
 */
public class RoundRobinComparator implements Comparator<int[]> {

    @Override
    public int compare(final int[] arg0, final int[] arg1) {
        if (arg0[0] > arg1[0]) {
            return 1;
        } else if (arg0[0] < arg1[0]) {
            return -1;
        }
        return 0;
    }

}
