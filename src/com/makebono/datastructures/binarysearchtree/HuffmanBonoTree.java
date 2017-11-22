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
        final HuffmanTreeComparator sideKick = new HuffmanTreeComparator();
        ArrayList<HTNode> result = new ArrayList<HTNode>();
        final Queue<HTNode> queue = new PriorityQueue<HTNode>(sideKick);
        queue.addAll(input);
        input.sort(sideKick);
        HTNode newNode = null;

        for (int i = 0; i < input.size() - 1; i++) {
            final HTNode tempL = queue.poll();
            final HTNode tempR = queue.poll();
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
        this.root.setCode("");

        while (!queue.isEmpty()) {
            final HTNode cursor = queue.poll();
            // Each node will either has a left/right child or it's the leaf.
            if (cursor.getL() != null && cursor.getR() != null) {
                cursor.getL().setCode(0 + cursor.getCode());
                cursor.getR().setCode(1 + cursor.getCode());
                queue.add(cursor.getL());
                queue.add(cursor.getR());
            } else {
                result.add(cursor);
            }
        }

        return result;
    }
}
