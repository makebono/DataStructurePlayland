package com.makebono.datastructures.binarysearchtree;

import com.makebono.datastructures.tools.genericnode.GenericNode;

/** 
 * @ClassName: TreeNode 
 * @Description: Node for BST
 * @author makebono
 * @param <T>
 * @date 2017年11月7日 上午10:04:27 
 *  
 */
public class BSTNode<T> extends GenericNode<T> {
    private char color;
    private BSTNode<T> lChild;
    private BSTNode<T> rChild;

    public BSTNode() {
        super();
        lChild = null;
        rChild = null;
        this.color = ' ';
    }

    public BSTNode(final int index, final T value) {
        super(index, value);
        this.lChild = null;
        this.rChild = null;
        this.color = ' ';
    }

    public BSTNode(final int index, final T value, final BSTNode<T> lChild, final BSTNode<T> rChild) {
        super(index, value);
        this.lChild = lChild;
        this.rChild = rChild;
        this.color = ' ';
    }

    public void setL(final BSTNode<T> lChild) {
        this.lChild = lChild;
    }

    public void setR(final BSTNode<T> rChild) {
        this.rChild = rChild;
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

    public char getColor() {
        return this.color;
    }

    public boolean isLeaf() {
        return this.getR() == null && this.getL() == null;
    }
}
