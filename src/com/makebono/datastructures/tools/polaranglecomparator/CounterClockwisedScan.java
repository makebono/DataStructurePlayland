package com.makebono.datastructures.tools.polaranglecomparator;

import java.util.Comparator;

import com.makebono.datastructures.graph.Vertex;

/** 
 * @ClassName: Counter clockwised scan 
 * @Description: Comparator of polar angle for vertices, counter clockwisely scan the graph, using minimumY vertex as its origin. 
 * @author makebono
 * @date 2017年11月16日 下午4:36:38 
 *  
 */
public class CounterClockwisedScan<T> implements Comparator<Vertex<T>> {
    private final Vertex<T> minimumY;

    public CounterClockwisedScan() {
        this.minimumY = new Vertex<T>(1, null, 0, 0);
    }

    public CounterClockwisedScan(final Vertex<T> minimumY) {
        this.minimumY = minimumY;
    }

    @Override
    public int compare(final Vertex<T> v1, final Vertex<T> v2) {
        final double angle1 = Math.atan2(this.minimumY.getY() - v1.getY(), this.minimumY.getX() - v1.getX());
        final double angle2 = Math.atan2(this.minimumY.getY() - v2.getY(), this.minimumY.getX() - v2.getX());

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
