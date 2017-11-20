package com.makebono.datastructures.tools.polaranglecomparator;

import java.util.Comparator;

import com.makebono.datastructures.graph.Vertex;

/** 
 * @ClassName: CrossProductComparator 
 * @Description: Counter clockwised polar angle comparator by comparing cross product
 * @author makebono
 * @date 2017年11月20日 上午11:20:39 
 *  
 */

// Error exists. Need to be fixed.
public class CrossProductComparator<T> implements Comparator<Vertex<T>> {
    private final Vertex<T> minimumY;

    public CrossProductComparator() {
        this.minimumY = new Vertex<T>(1, null, 0, 0);
    }

    public CrossProductComparator(final Vertex<T> minimumY) {
        this.minimumY = minimumY;
    }

    @Override
    public int compare(final Vertex<T> v1, final Vertex<T> v2) {
        if (this.quadrant(v1) == this.quadrant(v2)) {
            if ((v1.getX() - this.minimumY.getX()) * (v2.getY() - this.minimumY.getY())
                    - (v2.getX() - this.minimumY.getX()) * (v1.getY() - this.minimumY.getY()) < 0) {
                return 1;
            } else if ((v1.getX() - this.minimumY.getX()) * (v2.getY() - this.minimumY.getY())
                    - (v2.getX() - this.minimumY.getX()) * (v1.getY() - this.minimumY.getY()) > 0) {
                return -1;
            } else {
                return 0;
            }
        } else if (this.quadrant(v1) > this.quadrant(v2)) {
            return 1;
        } else {
            return -1;
        }
    }

    private int quadrant(final Vertex<T> v) {
        if (v.getX() > 0 && v.getY() >= 0) {
            return 1;
        } else if (v.getX() <= 0 && v.getY() > 0) {
            return 2;
        } else if (v.getX() <= 0 && v.getY() <= 0) {
            return 3;
        } else {
            return 4;
        }

    }

}
