package com.makebono.datastructures.tools.polaranglecomparator;

import java.util.Comparator;

import com.makebono.datastructures.graph.Vertex;

/** 
 * @ClassName: PolarAngleComparator 
 * @Description: Comparator of polar angle for vertices 
 * @author makebono
 * @date 2017年11月16日 下午4:36:38 
 *  
 */
public class PolarAngleComparator<T> implements Comparator<Vertex<T>> {
    private final Vertex<T> minimumY;

    public PolarAngleComparator() {
        this.minimumY = new Vertex<T>(1, null, 0, 0);
    }

    public PolarAngleComparator(final Vertex<T> minimumY) {
        this.minimumY = minimumY;
    }

    @Override
    public int compare(final Vertex<T> v1, final Vertex<T> v2) {
        final double angle1 = Math.atan2(-v1.getY(), -v1.getX());
        final double angle2 = Math.atan2(-v2.getY(), -v2.getX());

        if (angle1 < angle2) {
            return -1;
        } else if (angle1 > angle2) {
            return 1;
        } else {
            final double distance1 = Math.sqrt(
                    Math.pow(v1.getX() - this.minimumY.getX(), 2) + Math.pow(v1.getY() - this.minimumY.getY(), 2));
            final double distance2 = Math.sqrt(
                    Math.pow(v2.getX() - this.minimumY.getX(), 2) + Math.pow(v2.getY() - this.minimumY.getY(), 2));

            if (distance1 < distance2) {
                return -1;
            } else if (distance1 > distance2) {
                return 1;
            } else {
                return 0;
            }
        }
    }

}
