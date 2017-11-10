package com.makebono.datastructures.binarysearchtree;

import java.util.ArrayList;
import java.util.Comparator;

/** 
 * @ClassName: RedBlackBonoTree 
 * @Description: Red-Black tree
 * @author makebono
 * @date 2017年11月9日 上午11:06:33 
 *  
 */
public class RedBlackBonoTree<T> extends BinarySearchBonoTree<T> {
    private final BSTNode<T> sentinel = new BSTNode<T>(0, null, 'c');;

    public RedBlackBonoTree(final Comparator<T> sideKick) {
        super(sideKick);
        this.root = this.getSentinel();
    }

    public BSTNode<T> getSentinel() {
        return this.sentinel;
    }

    public boolean isSentinel(final BSTNode<T> node) {
        return node.getIndex() == this.getSentinel().getIndex();
    }

    private void setRoot(final BSTNode<T> node) {
        this.root = node;
    }

    @Override
    public void addNode(final BSTNode<T> node) {
        this.addNode(node, this.getRoot());
        this.size++;
    }

    private void addNode(final BSTNode<T> node, final BSTNode<T> root) {
        if (node.getIndex() == this.sentinel.getIndex()) {
            System.out.println("Index 0 is limited to the sentinel node. You can not add such node.");
            this.size--;
        } else {
            boolean success = true;
            if (this.getRoot() == this.getSentinel()) {
                this.root = node;
                this.root.setP(this.getSentinel());
                this.root.setL(this.getSentinel());
                this.root.setR(this.getSentinel());
            } else {
                if (this.getByIndex(node.getIndex()) != null) {
                    System.out.println("Index should be unique in this tree.");
                    this.size--;
                } else {
                    if (this.sideKick.compare(node.getData(), root.getData()) < 0) {
                        if (root.getL() == this.getSentinel()) {
                            root.setL(node);
                            node.setL(this.getSentinel());
                            node.setR(this.getSentinel());
                            node.setP(root);
                            node.setColor('r');
                        } else {
                            addNode(node, root.getL());
                        }
                    } else if (this.sideKick.compare(node.getData(), root.getData()) > 0) {
                        if (root.getR() == this.getSentinel()) {
                            root.setR(node);
                            node.setL(this.getSentinel());
                            node.setR(this.getSentinel());
                            node.setP(root);
                            node.setColor('r');
                        } else {
                            addNode(node, root.getR());
                        }
                    } else {
                        System.out.println("Data should be unique in this tree.");
                        success = false;
                        this.size--;
                    }
                }
            }
            if (success) {
                this.balancer(node);
            }
        }
    }

    @Override
    public void del(final T data) {
        if (this.size() == 0) {
            System.out.println("This is an empty tree.");
        } else {
            this.delete(data);
            size--;
        }
    }

    private void transPlant(final BSTNode<T> origin, final BSTNode<T> from) {
        if (origin.getP() == this.getSentinel()) {
            this.setRoot(from);
        } else if (origin == origin.getP().getL()) {
            origin.getP().setL(from);
        } else {
            origin.getP().setR(from);
        }
        from.setP(origin.getP());
    }

    private void leftSpin(final BSTNode<T> node) {
        final BSTNode<T> temp = node.getR();
        node.setR(temp.getL());

        if (temp.getL() != this.getSentinel()) {
            temp.setL(node);
        }

        temp.setP(node.getP());

        if (node.getP() == this.getSentinel()) {
            this.setRoot(temp);
        } else if (node == node.getP().getL()) {
            node.getP().setL(temp);
        } else {
            node.getP().setR(temp);
        }

        temp.setL(node);
        node.setP(temp);
    }

    private void rightSpin(final BSTNode<T> node) {
        final BSTNode<T> temp = node.getL();
        node.setL(temp.getR());

        if (temp.getR() != this.getSentinel()) {
            temp.setR(node);
        }

        temp.setP(node.getP());

        if (node.getP() == this.getSentinel()) {
            this.setRoot(temp);
        } else if (node == node.getP().getR()) {
            node.getP().setR(temp);
        } else {
            node.getP().setL(temp);
        }

        temp.setR(node);
        node.setP(temp);
    }

    private void balancer(final BSTNode<T> node) {
        BSTNode<T> uncle;
        BSTNode<T> temp = node;
        // System.out.println(temp.getP());
        while (temp.getP().getColor() == 'r') {
            // Newly inserted node's parent is the left child.
            if (temp.getP() == temp.getGP().getL()) {
                uncle = temp.getGP().getR();
                // Case 1: cursor's uncle node is red.
                if (uncle.getColor() == 'r') {
                    temp.getP().setColor('b');
                    uncle.setColor('b');
                    temp.getGP().setColor('r');
                    temp = temp.getGP();
                }
                // Case 2: Cursor is the right child and both of it and its parent are red.
                else if (temp == temp.getP().getR()) {
                    temp = temp.getP();
                    this.leftSpin(temp);
                }
                // Case 3: Cursor is the left child and both of it and its parent are red.
                else {
                    temp.getP().setColor('b');
                    temp.getGP().setColor('r');
                    this.rightSpin(temp.getGP());
                }
            }
            // Newly isertend node is a right child's child. Just do oposite manipulations against the way above.
            else {
                uncle = temp.getGP().getL();
                // Case 1: cursor's uncle node is red.
                if (uncle.getColor() == 'r') {
                    temp.getP().setColor('b');
                    uncle.setColor('b');
                    temp.getGP().setColor('r');
                    temp = temp.getGP();
                }
                // Case 2: Cursor is the right child and both of it and its parent are red.
                else if (temp == temp.getP().getL()) {
                    temp = temp.getP();
                    this.rightSpin(temp);
                }
                // Case 3: Cursor is the left child and both of it and its parent are red.
                else {
                    temp.getP().setColor('b');
                    temp.getGP().setColor('r');
                    this.leftSpin(temp.getGP());
                }
            }
        }

        this.getRoot().setColor('b');
    }

    // Errors exist. Needs to be modified.
    public void delete(final T data) {
        if (data == null) {
            System.out.println("You cannot delete the sentinel node.");
            this.size++;
        } else {
            final BSTNode<T> node = this.get(data);
            BSTNode<T> temp = node;
            BSTNode<T> temp2;
            char colorBuffer = temp.getColor();

            if (node.getL() == this.getSentinel()) {
                temp2 = node.getR();
                this.transPlant(node, node.getR());
            } else if (node.getR() == this.getSentinel()) {
                temp2 = node.getL();
                this.transPlant(node, node.getL());
            } else {
                temp = this.rMin(node);
                // System.out.println(temp);
                colorBuffer = temp.getColor();
                temp2 = temp.getR();

                if (temp.getP() == node) {
                    temp2.setP(temp);
                } else {
                    this.transPlant(temp, temp.getR());
                    temp.setR(node.getR());
                    temp.getR().setP(temp);
                }

                this.transPlant(node, temp);
                temp.setL(node.getL());
                temp.getL().setP(temp);
                temp.setColor(node.getColor());
            }

            if (colorBuffer == 'b') {
                enforcer(temp2);
            }
        }
    }

    private void enforcer(final BSTNode<T> node) {
        BSTNode<T> cursor = node;
        while (cursor != this.getRoot() && cursor.getColor() == 'b') {
            if (cursor == cursor.getP().getL()) {
                BSTNode<T> sibling = cursor.getP().getR();

                if (sibling.getColor() == 'r') {
                    sibling.setColor('b');
                    cursor.getP().setColor('r');
                    this.leftSpin(cursor.getP());
                    sibling = cursor.getP().getR();
                }

                if (sibling.getL().getColor() == 'b' && sibling.getR().getColor() == 'b') {
                    sibling.setColor('r');
                    cursor = cursor.getP();
                } else if (sibling.getR().getColor() == 'b') {
                    sibling.getL().setColor('b');
                    sibling.setColor('r');
                    this.rightSpin(sibling);
                    sibling = cursor.getP().getR();
                } else {
                    sibling.setColor(cursor.getP().getColor());
                    cursor.getP().setColor('b');
                    sibling.getR().setColor('b');
                    this.leftSpin(cursor.getP());
                    cursor = this.getRoot();
                }
            } else {
                BSTNode<T> sibling = cursor.getP().getL();

                if (sibling.getColor() == 'r') {
                    sibling.setColor('b');
                    cursor.getP().setColor('r');
                    this.rightSpin(cursor.getP());
                    sibling = cursor.getP().getL();
                }

                if (sibling.getR().getColor() == 'b' && sibling.getL().getColor() == 'b') {
                    sibling.setColor('r');
                    cursor = cursor.getP();
                } else if (sibling.getL().getColor() == 'b') {
                    sibling.getR().setColor('b');
                    sibling.setColor('r');
                    this.leftSpin(sibling);
                    sibling = cursor.getP().getL();
                } else {
                    sibling.setColor(cursor.getP().getColor());
                    cursor.getP().setColor('b');
                    sibling.getL().setColor('b');
                    this.rightSpin(cursor.getP());
                    cursor = this.getRoot();
                }
            }

        }
        cursor.setColor('b');
    }

    @Override
    public ArrayList<BSTNode<T>> bfs() {
        final ArrayList<BSTNode<T>> result = super.bfs();
        result.removeIf(s -> s.getIndex() == 0);
        return result;
    }

    @Override
    public ArrayList<BSTNode<T>> dfs() {
        final ArrayList<BSTNode<T>> result = super.dfs();
        result.removeIf(s -> s.getIndex() == 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        if (this.getRoot() == null) {
            sb.append("This is an empty tree.");
            return sb.toString();
        }

        sb.append("This is a " + this.getClass().getName() + ".\n\nThe BFS traversal for this tree goes like below:\n");
        for (final BSTNode<T> node : this.bfs()) {
            sb.append("Node(" + node.getIndex() + ", " + node.getData() + ", " + node.getColor() + ") ");
        }

        sb.append("\n\nThe DFS traversal for this tree goes like below:\n");
        for (final BSTNode<T> node : this.dfs()) {
            sb.append("Node(" + node.getIndex() + ", " + node.getData() + ", " + node.getColor() + ") ");
        }
        sb.append("\n\nIts size is: " + this.size() + ".");
        return sb.toString();
    }
}
