package com.makebono.datastructures.hungariantree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/** 
 * @ClassName: HungarianTree 
 * @Description: A tree for Hungarian algorithm, do BFS in this tree to find probable solution.
 * @author makebono
 * @date 2017年11月21日 上午10:37:11 
 *  
 */
public class HungarianTree {
    private final int layers;
    private int size;
    private final HungarianNode root;
    private ArrayList<HungarianNode> leaves;

    public HungarianTree(final int layers) {
        this.layers = layers;
        this.size = 0;

        // Dummy root deployed since there maybe mutiple available assignments in the first row.
        this.root = new HungarianNode(-1, -1, Integer.MAX_VALUE);

        // Keep tracking the leaves for attaching available assignments in next row to every available assignment
        // in current row. Layer by layer.
        this.leaves = new ArrayList<HungarianNode>();
        this.leaves.add(this.root);
    }

    // build the tree by inputing matrix.
    public void buildTree(final int[][] matrix) {
        // Actually m and n are the same in size.
        final int m = matrix.length;
        final int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            // A temporal ArrayList for new added leaves, update the leaves after attaching a whole layer.
            final ArrayList<HungarianNode> newLeaves = new ArrayList<HungarianNode>();
            final int leafSize = leaves.size();

            // System.out.println("leaves size: " + leafSize);

            for (int o = 0; o < n; o++) {
                for (int q = 0; q < leafSize; q++) {
                    // System.out.println(matrix[i][o]);

                    final HungarianNode cursor = this.leaves.get(q);

                    if (matrix[i][o] == 0) {
                        // System.out.println("boo!");

                        final HungarianNode newChild = new HungarianNode(i, o, matrix[i][o]);
                        cursor.addChild(newChild);
                        newLeaves.add(newChild);
                        this.size++;
                    }
                }
                // System.out.println(leaves.size());
            }
            // Update the leaves.
            leaves = newLeaves;
        }
    }

    // BFS here, any tree search is okay though.
    public ArrayList<HungarianNode> findSolution() {
        final ArrayList<HungarianNode> result = new ArrayList<HungarianNode>();
        final Queue<HungarianNode> queue = new LinkedList<HungarianNode>();

        queue.add(this.root);
        HungarianNode cursor = null;

        while (!queue.isEmpty()) {
            cursor = queue.poll();
            for (final HungarianNode temp : cursor.getChild()) {
                boolean valid = true;
                HungarianNode tempCursor = temp;

                // Back track until hit its first ancestor. Check for conflict.
                while (valid && tempCursor.parent() != this.root) {
                    if (temp.getN() == tempCursor.parent().getN()) {
                        // System.out.println("boo!");
                        valid = false;
                    } else {
                        tempCursor = tempCursor.parent();
                    }
                }

                // Ignore the invalid assignments.
                if (valid) {
                    temp.setValid();
                    queue.add(temp);
                }
            }
        }

        /*
        System.out.println("Leaves:");
        for (final HungarianNode temp : this.getLeaves()) {
            System.out.println("(" + temp.getM() + ", " + temp.getN() + ")");
        }
        */

        // Find the first legit path(solution) from bottom to top. If its found, break the loop.
        for (final HungarianNode temp : this.getLeaves()) {
            // If there's valid leaf, it's guarantee to be legit path. If not, an empty solution will be returned.
            if (temp.isValid()) {
                result.add(temp);
                cursor = temp;
                while (cursor.parent().isValid()) {
                    result.add(cursor.parent());
                    cursor = cursor.parent();
                }
                break;
            }
        }
        return result;
    }

    public int size() {
        return this.size;
    }

    public int layers() {
        return this.layers;
    }

    public ArrayList<HungarianNode> getLeaves() {
        return this.leaves;
    }
}
