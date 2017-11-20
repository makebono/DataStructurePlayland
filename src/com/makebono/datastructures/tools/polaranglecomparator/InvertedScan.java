package com.makebono.datastructures.tools.polaranglecomparator;

import java.util.Comparator;

import com.makebono.datastructures.graph.Vertex;

/** 
 * @ClassName:  Inverted
 * @Description: When reach the top, invert the graph and do counter clockwised scan. 
 * @author makebono
 * @date 2017年11月16日 下午4:36:38 
 *  
 */
public class InvertedScan<T> implements Comparator<Vertex<T>> {
    private final Vertex<T> minimumY;

    public InvertedScan() {
        this.minimumY = new Vertex<T>(1, null, 0, 0);
    }

    public InvertedScan(final Vertex<T> minimumY) {
        this.minimumY = new Vertex<T>(minimumY.getIndex(), minimumY.getData(), minimumY.getX() * (-1),
                minimumY.getY() * (-1));;
    }

    @Override
    public int compare(final Vertex<T> o1, final Vertex<T> o2) {
        // Invert the input.
        final Vertex<T> v1 = new Vertex<T>(o1.getIndex(), o1.getData(), o1.getX() * (-1), o1.getY() * (-1));
        final Vertex<T> v2 = new Vertex<T>(o2.getIndex(), o2.getData(), o2.getX() * (-1), o2.getY() * (-1));

        if (this.quadrant(v1) == this.quadrant(v2)) {
            if ((v1.getX() - this.minimumY.getX()) * (v2.getY() - this.minimumY.getY())
                    - (v2.getX() - this.minimumY.getX()) * (v1.getY() - this.minimumY.getY()) < 0) {
                return 1;
            } else if ((v1.getX() - this.minimumY.getX()) * (v2.getY() - this.minimumY.getY())
                    - (v2.getX() - this.minimumY.getX()) * (v1.getY() - this.minimumY.getY()) > 0) {
                return -1;
            } else {
                final double distance1 = Math.sqrt(
                        Math.pow(v1.getX() - this.minimumY.getX(), 2) + Math.pow(v1.getY() - this.minimumY.getY(), 2));
                final double distance2 = Math.sqrt(
                        Math.pow(v2.getX() - this.minimumY.getX(), 2) + Math.pow(v2.getY() - this.minimumY.getY(), 2));

                if (distance1 < distance2) {
                    return 1;
                } else if (distance1 > distance2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        } else if (this.quadrant(v1) > this.quadrant(v2)) {
            return 1;
        } else {
            return -1;
        }
    }

    private int quadrant(final Vertex<T> v) {
        if (v.getX() - this.minimumY.getX() > 0 && v.getY() - this.minimumY.getY() >= 0) {
            return 1;
        } else if (v.getX() - this.minimumY.getX() <= 0 && v.getY() - this.minimumY.getY() >= 0) {
            return 2;
        } else if (v.getX() - this.minimumY.getX() <= 0 && v.getY() - this.minimumY.getY() < 0) {
            return 3;
        } else {
            return 4;
        }
    }
}
