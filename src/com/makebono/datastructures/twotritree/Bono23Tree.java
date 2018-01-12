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
// Deal with the size.
// Add delete by key method.
@SuppressWarnings(value = { "unchecked", "unused" })
public class Bono23Tree<T> implements TwoTriTree<T> {
    private Bono23Node<T> root;
    // Size here is not the amount of nodes, but the amount of values contained in data structure. It makes more sense
    // by this way, because no one cares about anything but the actual data.
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
                final Bono23Node<T> newRoot = new Bono23Node<T>();
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
                // System.out.println("parent " + parent);
                // System.out.println("node " + node);
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
        final Bono23Node<T> newL = new Bono23Node<T>();
        final Bono23Node<T> newR = new Bono23Node<T>();

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

        // If node is not at bottom layer, don't forget to assign children to each divided node. This is mainly for not
        // assigning parent to null reference.
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
            this.size++;
            this.root = node;
        } else {
            this.size++;
            this.addNode(node, this.root);
        }
    }

    private void addNode(final Bono23Node<T> node, final Bono23Node<T> target) {
        if (target.isLeaf()) {
            // Target has only one value, directly add the new key in. No changes on size.
            if (target.type() == '2') {
                target.setRv(node.getLv());
                target.balance(target);
                // System.out.println("Target: " + target);
                // System.out.println("Parent: " + target.getP());
            }
            // Target is already full. Add new key to the middle position, balance it, then push up.
            else {
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

    @Override
    public void del(final T key) {
        final Bono23Node<T> target = this.search(key);
        Bono23Node<T> cursor;

        if (target == null) {
            return;
        }

        // Start all deletion from leaves to get more general cases to handle with. This is done by exchange the target
        // value with minimum value on its right tree. If it is the leaf, directly start from target node.
        if (target.isLeaf()) {
            cursor = target;
        } else {
            cursor = this.rMin(target, key);
            this.swap(target, key, cursor);
        }

        this.del(key, cursor);
        this.size--;
    }

    private boolean del(final T key, final Bono23Node<T> cursor) {
        // Base case for deleting up onto the root. This means the root is currently an empty node with a single child.
        // Set this one child as the new root and that's it.
        if (cursor == root) {
            // Although the sub-tree hanging on a yet-to-be legit node is constant by cases, I'm lazy to decide left or
            // right child it is. Use a simple conditional statement to get it covered. If the node to be dealt with is
            // a leaf, it's ok since a null will be passed out whatsoever.
            final Bono23Node<T> newRoot = cursor.getL() == null ? cursor.getR() : cursor.getL();
            this.root = newRoot;
            return true;
        }

        // If candidate leaf node to be dealt with has 2 values, just simply delete the one out of it.
        if (cursor.isLeaf() && cursor.type() == '3') {
            T remain;
            remain = key == cursor.getLv() ? cursor.getRv() : cursor.getLv();
            cursor.setLv(remain);
            cursor.setRv(null);
        }
        // Now get into the real part. Candidate leaf has only one value, after deletion it becomes a empty node.
        // Need to be handled around several cases.
        else {
            cursor.setLv(null);
            Bono23Node<T> adjacent;
            final Bono23Node<T> parent = cursor.getP();

            // Candidate's parent holds 1 value.
            if (cursor.getP().type() == '2') {

                // Candidate is the left child.
                if (cursor == parent.getL()) {
                    adjacent = parent.getR();

                    // If sibling has 1 value.
                    if (adjacent.type() == '2') {
                        final Bono23Node<T> t1 = cursor.getL() == null ? cursor.getR() : cursor.getL();
                        final Bono23Node<T> t2 = adjacent.getL();
                        final Bono23Node<T> t3 = adjacent.getR();

                        adjacent.setRv(adjacent.getLv());
                        adjacent.setLv(parent.getLv());
                        adjacent.setM(t2);
                        adjacent.setL(t1);
                        if (t1 != null) {
                            t1.setP(adjacent);
                        }

                        parent.setLv(null);
                        parent.setL(null);

                        return this.del(key, parent);
                    }
                    // if sibling has 2 values.
                    else {
                        // Unused variable left here intentionally. Give a clearer view of the scene.
                        final Bono23Node<T> t1 = cursor.getL() == null ? cursor.getR() : cursor.getL();
                        final Bono23Node<T> t2 = adjacent.getL();
                        final Bono23Node<T> t3 = adjacent.getM();
                        final Bono23Node<T> t4 = adjacent.getR();

                        cursor.setLv(parent.getLv());
                        cursor.setL(t1);
                        cursor.setR(t2);
                        if (t2 != null) {
                            t2.setP(cursor);
                        }

                        parent.setLv(adjacent.getLv());

                        adjacent.setLv(adjacent.getRv());
                        adjacent.setRv(null);
                        adjacent.setL(t3);
                        adjacent.setM(null);
                    }
                }
                // Candidate is the right child.
                else {
                    adjacent = parent.getL();

                    // Sibling has 1 value.
                    if (adjacent.type() == '2') {
                        final Bono23Node<T> t1 = adjacent.getL();
                        final Bono23Node<T> t2 = adjacent.getR();
                        final Bono23Node<T> t3 = cursor.getL() == null ? cursor.getR() : cursor.getL();

                        adjacent.setRv(parent.getLv());
                        adjacent.setM(t2);
                        adjacent.setR(t3);
                        if (t3 != null) {
                            t3.setP(adjacent);
                        }

                        parent.setLv(null);
                        parent.setR(null);

                        return this.del(key, parent);
                    }
                    // Sibling has 2 value.
                    else {
                        final Bono23Node<T> t1 = adjacent.getL();
                        final Bono23Node<T> t2 = adjacent.getM();
                        final Bono23Node<T> t3 = adjacent.getR();
                        final Bono23Node<T> t4 = cursor.getL() == null ? cursor.getR() : cursor.getL();

                        cursor.setLv(parent.getLv());
                        cursor.setL(t3);
                        cursor.setR(t4);
                        if (t3 != null) {
                            t3.setP(cursor);
                        }

                        parent.setLv(adjacent.getRv());

                        adjacent.setRv(null);
                        adjacent.setR(t2);
                        adjacent.setM(null);
                    }
                }
            }
            // Candidate's parent holds 2 values.
            else {
                // If candidate is the left child.
                if (cursor == parent.getL()) {
                    // If middle sibling has 2 values.
                    if (parent.getM().type() == '3') {
                        adjacent = parent.getM();

                        final Bono23Node<T> t1 = cursor.getL() == null ? cursor.getR() : cursor.getL();
                        final Bono23Node<T> t2 = adjacent.getL();
                        final Bono23Node<T> t3 = adjacent.getM();
                        final Bono23Node<T> t4 = adjacent.getR();

                        cursor.setLv(parent.getLv());
                        cursor.setL(t1);
                        cursor.setR(t2);
                        if (t2 != null) {
                            t2.setP(cursor);
                        }

                        parent.setLv(adjacent.getLv());

                        adjacent.setLv(adjacent.getRv());
                        adjacent.setRv(null);
                        adjacent.setL(t3);
                        adjacent.setM(null);
                    }
                    // If right sibling has 2 values.
                    else if (parent.getR().type() == '3') {
                        final Bono23Node<T> midSibling = parent.getM();
                        adjacent = parent.getR();

                        final Bono23Node<T> t1 = cursor.getL() == null ? cursor.getR() : cursor.getL();
                        final Bono23Node<T> t2 = midSibling.getL();
                        final Bono23Node<T> t3 = midSibling.getR();
                        final Bono23Node<T> t4 = adjacent.getL();
                        final Bono23Node<T> t5 = adjacent.getM();
                        final Bono23Node<T> t6 = adjacent.getR();

                        cursor.setLv(parent.getLv());
                        cursor.setL(t1);
                        cursor.setR(t2);
                        if (t2 != null) {
                            t2.setP(cursor);
                        }

                        parent.setLv(midSibling.getLv());

                        midSibling.setLv(parent.getRv());
                        midSibling.setL(t3);
                        midSibling.setR(t4);
                        if (t4 != null) {
                            t4.setP(midSibling);
                        }

                        parent.setRv(adjacent.getLv());

                        adjacent.setLv(adjacent.getRv());
                        adjacent.setRv(null);
                        adjacent.setL(t5);
                        adjacent.setM(null);
                    }
                    // If both of the siblings have only 1 value
                    else {
                        final Bono23Node<T> midSibling = parent.getM();
                        final Bono23Node<T> rightSibling = parent.getR();

                        final Bono23Node<T> t1 = cursor.getL() == null ? cursor.getR() : cursor.getL();
                        final Bono23Node<T> t2 = midSibling.getL();
                        final Bono23Node<T> t3 = midSibling.getR();

                        parent.setL(midSibling);
                        parent.setM(null);
                        cursor.setP(null);

                        midSibling.setRv(midSibling.getLv());
                        midSibling.setLv(parent.getLv());
                        midSibling.setM(t2);
                        midSibling.setL(t1);
                        if (t1 != null) {
                            t1.setP(midSibling);
                        }

                        parent.setLv(parent.getRv());
                        parent.setRv(null);
                    }
                }
                // Candidate is the middle child
                else if (cursor == parent.getM()) {
                    // Left sibling has 2 values
                    if (parent.getL().type() == '3') {
                        adjacent = parent.getL();

                        final Bono23Node<T> t1 = adjacent.getL();
                        final Bono23Node<T> t2 = adjacent.getM();
                        final Bono23Node<T> t3 = adjacent.getR();
                        final Bono23Node<T> t4 = cursor.getL() == null ? cursor.getR() : cursor.getL();

                        cursor.setLv(parent.getLv());
                        cursor.setL(t3);
                        cursor.setR(t4);
                        if (t3 != null) {
                            t3.setP(cursor);
                        }

                        parent.setLv(adjacent.getRv());

                        adjacent.setRv(null);
                        adjacent.setR(t2);
                        adjacent.setM(null);
                    }
                    // Right sibling has 2 values
                    if (parent.getR().type() == '3') {
                        adjacent = parent.getR();

                        final Bono23Node<T> t1 = cursor.getL() == null ? cursor.getR() : cursor.getL();
                        final Bono23Node<T> t2 = adjacent.getL();
                        final Bono23Node<T> t3 = adjacent.getM();
                        final Bono23Node<T> t4 = adjacent.getR();

                        cursor.setLv(parent.getRv());
                        cursor.setL(t1);
                        cursor.setR(t2);
                        if (t2 != null) {
                            t2.setP(cursor);
                        }
                        parent.setRv(adjacent.getLv());

                        adjacent.setLv(adjacent.getRv());
                        adjacent.setRv(null);
                        adjacent.setL(t3);
                        adjacent.setM(null);

                    }
                    // Both of the siblings have only 1 value
                    else {
                        final Bono23Node<T> leftSibling = parent.getL();
                        final Bono23Node<T> rightSibling = parent.getR();

                        final Bono23Node<T> t1 = cursor.getL() == null ? cursor.getR() : cursor.getL();
                        final Bono23Node<T> t2 = rightSibling.getL();
                        final Bono23Node<T> t3 = rightSibling.getR();

                        parent.setM(null);
                        cursor.setP(null);

                        rightSibling.setRv(rightSibling.getLv());
                        rightSibling.setLv(parent.getRv());
                        rightSibling.setM(t2);
                        rightSibling.setL(t1);
                        if (t1 != null) {
                            t1.setP(rightSibling);
                        }

                        parent.setRv(null);
                    }

                }
                // Candidate is the right child
                else {
                    // Middle sibling has 2 values
                    if (parent.getM().type() == '3') {
                        adjacent = parent.getM();

                        final Bono23Node<T> t1 = adjacent.getL();
                        final Bono23Node<T> t2 = adjacent.getM();
                        final Bono23Node<T> t3 = adjacent.getR();
                        final Bono23Node<T> t4 = cursor.getL() == null ? cursor.getR() : cursor.getL();

                        cursor.setLv(parent.getRv());
                        cursor.setL(t3);
                        cursor.setR(t4);
                        if (t3 != null) {
                            t3.setP(cursor);
                        }

                        parent.setRv(adjacent.getRv());

                        adjacent.setRv(null);
                        adjacent.setR(t2);
                        adjacent.setM(null);
                    }
                    // Left sibling has 2 values
                    else if (parent.getL().type() == '3') {
                        adjacent = parent.getL();
                        final Bono23Node<T> midSibling = parent.getM();

                        final Bono23Node<T> t1 = adjacent.getL();
                        final Bono23Node<T> t2 = adjacent.getM();
                        final Bono23Node<T> t3 = adjacent.getR();
                        final Bono23Node<T> t4 = midSibling.getL();
                        final Bono23Node<T> t5 = midSibling.getR();
                        final Bono23Node<T> t6 = cursor.getL() == null ? cursor.getR() : cursor.getL();

                        cursor.setLv(parent.getRv());
                        cursor.setL(t5);
                        cursor.setR(t6);
                        if (t5 != null) {
                            t5.setP(cursor);
                        }

                        parent.setRv(midSibling.getRv());

                        midSibling.setLv(parent.getLv());
                        midSibling.setL(t3);
                        midSibling.setR(t4);
                        if (t3 != null) {
                            t3.setP(midSibling);
                        }

                        parent.setLv(adjacent.getRv());

                        adjacent.setRv(null);
                        adjacent.setR(t2);
                        adjacent.setM(null);
                    }
                    // Both of the siblings have only 1 value
                    else {
                        final Bono23Node<T> middleSibling = parent.getM();

                        final Bono23Node<T> t1 = middleSibling.getL();
                        final Bono23Node<T> t2 = middleSibling.getR();
                        final Bono23Node<T> t3 = cursor.getL() == null ? cursor.getR() : cursor.getL();

                        parent.setR(middleSibling);
                        parent.setM(null);
                        cursor.setP(null);

                        middleSibling.setRv(parent.getRv());
                        middleSibling.setM(t2);
                        middleSibling.setR(t3);
                        if (t3 != null) {
                            t3.setP(middleSibling);
                        }

                        parent.setRv(null);
                    }
                }
            }
        }
        return true;
    }

    @Override
    public Bono23Node<T> search(final T key) {
        return this.search(key, this.root);
    }

    // Act identically as in BST, except a middle value should be considered here.
    private Bono23Node<T> search(final T key, final Bono23Node<T> cursor) {
        if (cursor == null) {} else if (cursor.type() == '2') {
            if (this.sideKick.compare(key, cursor.getLv()) == 0) {
                return cursor;
            } else if (cursor.isLeaf()) {} else if (this.sideKick.compare(key, cursor.getLv()) < 0) {
                return this.search(key, cursor.getL());
            } else {
                return this.search(key, cursor.getR());
            }
        } else {
            if (this.sideKick.compare(key, cursor.getLv()) == 0 || this.sideKick.compare(key, cursor.getRv()) == 0) {
                return cursor;
            } else if (cursor.isLeaf()) {} else if (this.sideKick.compare(key, cursor.getLv()) < 0) {
                return search(key, cursor.getL());
            } else if (this.sideKick.compare(key, cursor.getRv()) < 0) {
                return search(key, cursor.getM());
            } else {
                return search(key, cursor.getR());
            }
        }

        System.out.println("Key input is not in this data structure.");
        return null;
    }

    // As searching, this is pretty much similar as in any BST.
    @Override
    public ArrayList<Bono23Node<T>> bfs() {
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

    // Help method for deletion as in normal BST. lMax or rMin will do depends on your choice.
    private Bono23Node<T> rMin(final Bono23Node<T> node, final T key) {
        if (node.isLeaf()) {
            return node;
        } else {
            Bono23Node<T> cursor = node;
            if (key == node.getLv()) {
                if (node.type() == '2') {
                    cursor = cursor.getR();
                } else {
                    cursor = cursor.getM();
                }
                while (!cursor.isLeaf()) {
                    cursor = cursor.getL();
                }
                return cursor;
            } else {
                cursor = cursor.getR();
                while (!cursor.isLeaf()) {
                    cursor = cursor.getL();
                }
                return cursor;
            }
        }
    }

    // Swap the candidate value(to be removed) with it's rMin.lv then start from leaf onto the killzone.
    private void swap(final Bono23Node<T> node1, final T key1, final Bono23Node<T> node2) {
        if (key1 == node1.getLv()) {
            node1.setLv(node2.getLv());
            node2.setLv(key1);
        } else {
            node1.setRv(node2.getLv());
            node2.setLv(key1);
        }
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
    public void clear() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        if (this.root == null) {
            return "This tree is empty.";
        }

        final StringBuilder sb = new StringBuilder();

        sb.append("Showing traversal of 2-3 tree using BFS.\n    ");
        int i = 0;
        final ArrayList<Bono23Node<T>> bfs = this.bfs();

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

        sb.append("\nData size of this tree is: " + this.size + "\n");

        return sb.toString();
    }
}