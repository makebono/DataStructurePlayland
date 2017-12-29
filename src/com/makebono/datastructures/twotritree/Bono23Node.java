package com.makebono.datastructures.twotritree;

import com.makebono.datastructures.binarysearchtree.BSTNode;

/** 
 * @ClassName: Bono23Node 
 * @Description: Node for 2-3 tree. mChild is a temporary node.
 * @author makebono
 * @date 2017年12月22日 上午11:19:24 
 *  
 */
public class Bono23Node<T> extends BSTNode<T> {
    private T lv;
    private T mv;
    private T rv;
    private Bono23Node<T> lChild;
    private Bono23Node<T> rChild;
    private Bono23Node<T> mChild;
    private Bono23Node<T> parent;

    public Bono23Node() {
        super();
        this.lChild = null;
        this.rChild = null;
        this.mChild = null;
        this.parent = null;
        this.color = ' ';
    }

    public Bono23Node(final int index, final T... v) {
        this.index = index;
        this.lChild = null;
        this.rChild = null;
        this.mChild = null;
        this.parent = null;
        this.color = ' ';
        if (v.length >= 1) {
            this.lv = v[0];
        }
        if (v.length == 2) {
            this.rv = v[1];
        }
    }

    @Override
    public void setL(final BSTNode<T> lChild) {
        this.lChild = (Bono23Node<T>) lChild;
    }

    @Override
    public void setR(final BSTNode<T> rChild) {
        this.rChild = (Bono23Node<T>) rChild;
    }

    public void setM(final BSTNode<T> mChild) {
        this.mChild = (Bono23Node<T>) mChild;
    }

    @Override
    public void setP(final BSTNode<T> parent) {
        this.parent = (Bono23Node<T>) parent;
    }

    public void setLv(final T lv) {
        this.lv = lv;
    }

    public void setMv(final T mv) {
        this.mv = lv;
    }

    public void setRv(final T rv) {
        this.rv = rv;
    }

    public T getLv() {
        return this.lv;
    }

    public T getMv() {
        return this.mv;
    }

    public T getRv() {
        return this.rv;
    }

    @Override
    public Bono23Node<T> getL() {
        return this.lChild;
    }

    @Override
    public Bono23Node<T> getR() {
        return this.rChild;
    }

    public Bono23Node<T> getM() {
        return this.mChild;
    }

    @Override
    public Bono23Node<T> getP() {
        return this.parent;
    }

    public Bono23Node<T> removeM() {
        final Bono23Node<T> temp = this.getM();
        this.setM(null);
        return temp;
    }

    @Override
    public boolean isLeaf() {
        return this.getR() == null && this.getL() == null;
    }

    public boolean isLegit() {
        return this.getM() == null;
    }
}
