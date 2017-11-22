package com.makebono.datastructures.binarysearchtree;

import com.makebono.datastructures.tools.genericnode.GenericNode;

/** 
 * @ClassName: TreeNode 
 * @Description: Node for BST and features added for RB trees. Althogh I don't have plan to add parent node for BST implementation.
 * @author makebono
 * @param <T>
 * @date 2017年11月7日 上午10:04:27 
 *  
 */
public class BSTNode<T> extends GenericNode<T> {
    protected char color;
    protected BSTNode<T> lChild;
    protected BSTNode<T> rChild;
    protected BSTNode<T> parent;

    public BSTNode() {
        super();
        this.lChild = null;
        this.rChild = null;
        this.parent = null;
        this.color = ' ';
    }

    public BSTNode(final int index, final T value) {
        super(index, value);
        this.lChild = null;
        this.rChild = null;
        this.parent = null;
        this.color = ' ';
    }

    public BSTNode(final int index, final T value, final char color) {
        super(index, value);
        this.lChild = null;
        this.rChild = null;
        this.parent = null;
        this.color = color;
    }

    public void setL(final BSTNode<T> lChild) {
        this.lChild = lChild;
    }

    public void setR(final BSTNode<T> rChild) {
        this.rChild = rChild;
    }

    public void setP(final BSTNode<T> parent) {
        this.parent = parent;
    }

    public void setColor(final char color) {
        this.color = color;
    }

    public BSTNode<T> getL() {
        return this.lChild;
    }

    public BSTNode<T> getR() {
        return this.rChild;
    }

    public BSTNode<T> getP() {
        return this.parent;
    }

    public BSTNode<T> getGP() {
        return this.getP().getP();
    }

    public char getColor() {
        return this.color;
    }

    public boolean isLeaf() {
        return this.getR() == null && this.getL() == null;
    }
}
