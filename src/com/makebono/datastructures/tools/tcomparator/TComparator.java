package com.makebono.datastructures.tools.tcomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/** 
 * @ClassName: TComparator 
 * @Description: Comparator for T type, but it will only handle simple cases like int, string, etc.
 * @author makebono
 * @date 2017年11月7日 上午10:41:05 
 *  
 */
public class TComparator<T> implements Comparator<T> {

    @Override
    public int compare(final T o1, final T o2) {
        final ArrayList<T> l = new ArrayList<T>();
        l.add(o1);
        l.add(o2);
        Collections.sort(l, null);
        if (o1.equals(o2)) {
            return 0;
        } else if (l.get(0) == o1) {
            return -1;
        } else {
            return 1;
        }
    }
}