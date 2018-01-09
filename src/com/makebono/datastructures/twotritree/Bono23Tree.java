package com.makebono.datastructures.twotritree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.makebono.datastructures.tools.tcomparator.TComparator;
import com.makebono.datastructures.twotritree.twotritreeinterface.TwoTriTree;

/** 
 * @ClassName: Bono23Tree 
 * @Description: Implementation of 2-3 tree
 * @author makebono
 * @date 2017年12月22日 上午9:36:59 
 *  
 */
@SuppressWarnings(value = { "unchecked" })
public class Bono23Tree<T> implements TwoTriTree<T> {
    private Bono23Node<T> root;
    int size;
    TComparator<T> sideKick;

    public Bono23Tree() {
        this.root = null;
        this.size = 0;
        this.sideKick = new TComparator<T>();
    }

    private Bono23Node<T> pushUp(final Bono23Node<T> node) {
        final Bono23Node<T> parent = node.getP();
        final Bono23Node<T>[] newLR = this.divide(node);
        final Bono23Node<T> newL = newLR[0];
        final Bono23Node<T> newR = newLR[1];
        // System.out.println("node: " + node + " parent: " + parent);

        if (parent == null) {
            // System.out.println("new root! " + node);

            if (node.type() <= 3) {

                return node;
            } else {
                final Bono23Node<T> newRoot = new Bono23Node<T>(this.size() + 1);
                /* if (newL.getLv().equals(1) && newR.getLv().equals(6)) {
                    System.out.println("Check it out");
                    System.out.println(newL.getL().getP());
                    System.out.println(newL.getR().getP());
                    System.out.println(newR.getL().getP());
                    System.out.println(newR.getR().getP());
                }
                */
                newRoot.setLv(node.getMv());
                newRoot.setL(newL);
                newRoot.setR(newR);
                newL.setP(newRoot);
                newR.setP(newRoot);

                // this.root = newRoot;
                this.size += 2;
                return newRoot;
            }
        }

        // System.out.println("newL! " + newL + " newR! " + newR);
        if (parent.type() == '2') {
            if (node == parent.getL()) {
                parent.setRv(parent.getLv());
                parent.setLv(node.getMv());
                parent.setL(newL);
                parent.setM(newR);
                newL.setP(parent);
                newR.setP(parent);
            } else {
                parent.setRv(node.getMv());
                parent.setR(newR);
                parent.setM(newL);
                newL.setP(parent);
                newR.setP(parent);
            }
            this.size++;
            return this.root;
        } else {
            if (node == parent.getL()) {
                parent.setMv(parent.getLv());
                parent.setLv(node.getMv());
                parent.setL(newL);
                parent.setMt(newR);
                newL.setP(parent);
                newR.setP(parent);
            } else if (node == parent.getM()) {
                // System.out.println("parent!!!! " + parent);
                // System.out.println("node!!!! " + node);
                parent.setMv(node.getMv());
                parent.setMt(newL);
                parent.setM(newR);
                newL.setP(parent);
                newR.setP(parent);
                // System.out.println(parent.getL());
                // System.out.println(parent.getMt());
                // System.out.println(parent.getM());
                // System.out.println(parent.getR());
            } else if (node == parent.getR()) {
                parent.setMv(parent.getRv());
                parent.setRv(node.getMv());
                parent.setMt(parent.getM());
                parent.setM(newL);
                parent.setR(newR);
                newL.setP(parent);
                newR.setP(parent);
            }
            return this.pushUp(parent);
        }

    }

    public Bono23Node<T>[] divide(final Bono23Node<T> node) {
        final Bono23Node<T> newL = new Bono23Node<T>(node.getIndex());
        final Bono23Node<T> newR = new Bono23Node<T>(this.size + 1);

        final Bono23Node<T> ll = node.getL();
        final Bono23Node<T> lr = node.getMt();
        final Bono23Node<T> rl = node.getM();
        final Bono23Node<T> rr = node.getR();

        newL.setLv(node.getLv());
        newL.setL(ll);
        newL.setR(lr);
        newR.setLv(node.getRv());
        newR.setL(rl);
        newR.setR(rr);

        // If node is not at bottom layer, don't forget to sign children to each divided node.
        if (ll != null) {
            ll.setP(newL);
            lr.setP(newL);
            rl.setP(newR);
            rr.setP(newR);
        }

        return new Bono23Node[] { newL, newR };
    }

    @Override
    public void addNode(final Bono23Node<T> node) {
        if (this.isEmpty()) {
            // System.out.println("boo!");
            this.root = node;
            this.size++;
        } else {
            this.addNode(node, this.root);
        }
    }

    private void addNode(final Bono23Node<T> node, final Bono23Node<T> target) {
        if (target.isLeaf()) {
            if (target.type() == '2') {
                target.setRv(node.getLv());
                target.balance(target);
                // System.out.println("Target: " + target);
                // System.out.println("Parent: " + target.getP());
            } else {
                // System.out.println("boo!: node.getLv(): " + node.getLv());

                target.setMv(node.getLv());
                target.balance(target);
                // System.out.println("Target: " + target);
                // System.out.println("Parent: " + target.getP());
                this.root = this.pushUp(target);
            }
        } else {
            // System.out.println("node: " + node);
            // System.out.println("root: " + target);
            if (target.type() == '2') {
                if (this.sideKick.compare(node.getLv(), target.getLv()) <= 0) {
                    this.addNode(node, target.getL());
                } else {
                    this.addNode(node, target.getR());
                }
            } else {
                if (this.sideKick.compare(node.getLv(), target.getLv()) <= 0) {
                    this.addNode(node, target.getL());
                } else if (this.sideKick.compare(node.getLv(), target.getRv()) <= 0) {
                    this.addNode(node, target.getM());
                } else {
                    this.addNode(node, target.getR());
                }
            }
        }
    }

    // Since index means nothing here. Use key for the deletion.
    public void del(final int key) {

    }

    @Override
    public ArrayList<Bono23Node<T>> bfs23() {
        final ArrayList<Bono23Node<T>> bfsResult = new ArrayList<Bono23Node<T>>();
        final Queue<Bono23Node<T>> queue = new LinkedList<Bono23Node<T>>();
        queue.add(this.getRoot());
        Bono23Node<T> temp;

        while (!queue.isEmpty()) {
            temp = queue.poll();
            bfsResult.add(temp);
            if (temp.getL() != null) {
                queue.add(temp.getL());
            }

            if (temp.getM() != null) {
                queue.add(temp.getM());
            }

            if (temp.getR() != null) {
                queue.add(temp.getR());
            }
        }

        return bfsResult;
    }

    public Bono23Node<T> getRoot() {
        return this.root;
    }

    @Override
    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append("Showing traversal of 2-3 tree using BFS.\n    ");
        int i = 0;
        final ArrayList<Bono23Node<T>> bfs = this.bfs23();

        for (final Bono23Node<T> cursor : bfs) {
            if (cursor == bfs.get(bfs.size() - 1)) {
                sb.append(cursor);
                continue;
            }

            if (i++ < 6) {
                sb.append(cursor + ", ");
            }

            if (i == 6) {
                i = 0;
                sb.append("\n    ");
            }
        }

        return sb.toString();
    }
}