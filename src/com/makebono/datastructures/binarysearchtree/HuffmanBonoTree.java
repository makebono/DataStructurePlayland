package com.makebono.datastructures.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import com.makebono.datastructures.tools.huffmantreecomparator.HuffmanTreeComparator;

/** 
 * @ClassName: HuffmanBonoTree 
 * @Description: Huffman tree for Huffman coding uses. Nothing specials.
 * @author makebono
 * @date 2017年11月22日 下午4:09:15 
 *  
 */
public class HuffmanBonoTree {
    private HTNode root;
    private final int size;

    public HuffmanBonoTree() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public HTNode root() {
        return this.root;
    }

    public ArrayList<HTNode> buildTree(final ArrayList<HTNode> input) {
        ArrayList<HTNode> result = new ArrayList<HTNode>();
        final HuffmanTreeComparator sideKick = new HuffmanTreeComparator();
        final Queue<HTNode> queue = new PriorityQueue<HTNode>(sideKick);
        queue.addAll(input);
        HTNode newNode = null;

        for (int i = 0; i < input.size() - 1; i++) {
            final HTNode tempL = queue.poll();
            final HTNode tempR = queue.poll();
            // Dummy node.
            newNode = new HTNode(-(i - 1), tempL.getData() + tempR.getData(), ' ');
            newNode.setL(tempL);
            newNode.setR(tempR);
            queue.add(newNode);
        }

        this.root = queue.poll();

        result = this.BFS();
        return result;
    }

    private ArrayList<HTNode> BFS() {
        final ArrayList<HTNode> result = new ArrayList<HTNode>();
        final Queue<HTNode> queue = new LinkedList<HTNode>();
        queue.add(this.root);

        // Assign empty code to the root. Make it convenient to append relative codes. 1 append to right child and 0
        // append to left child, as per search going down to the leaves.
        this.root.setCode("");

        while (!queue.isEmpty()) {
            final HTNode cursor = queue.poll();
            // Each node will either has a left/right child or it's the leaf.
            if (cursor.getL() != null) {
                // Append code. Remeber to append to its tail, not in front of it.
                cursor.getL().setCode(cursor.getCode() + 0);
                cursor.getR().setCode(cursor.getCode() + 1);
                queue.add(cursor.getL());
                queue.add(cursor.getR());
            } else {
                // Leaf reached. Add it to the result.
                result.add(cursor);
            }
        }

        return result;
    }
}
