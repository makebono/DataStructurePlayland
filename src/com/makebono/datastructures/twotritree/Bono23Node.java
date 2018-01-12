package com.makebono.datastructures.twotritree;

import com.makebono.datastructures.binarysearchtree.BSTNode;
import com.makebono.datastructures.tools.tcomparator.TComparator;

/** 
 * @ClassName: Bono23Node 
 * @Description: Node for 2-3 tree. mtChild is a temporary node.
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
    private Bono23Node<T> mtChild;
    private Bono23Node<T> parent;
    private final TComparator<T> sideKick = new TComparator<T>();

    public Bono23Node() {
        this.lChild = null;
        this.rChild = null;
        this.mChild = null;
        this.mtChild = null;
        this.parent = null;
        this.color = ' ';
    }

    @SafeVarargs
    public Bono23Node(final T... v) {
        this.lChild = null;
        this.rChild = null;
        this.mChild = null;
        this.mtChild = null;
        this.parent = null;
        this.color = ' ';
        if (v.length >= 1) {
            this.lv = v[0];
        }
        if (v.length == 2) {
            this.rv = v[1];
            balance(this);
        } else if (v.length == 3) {
            this.mv = v[1];
            this.rv = v[2];
            balance(this);
        }
    }

    public void balance(final Bono23Node<T> node) {
        final T v1 = node.getLv();
        final T v2 = node.getMv();
        final T v3 = node.getRv();
        T temp = null;

        if (sideKick.compare(v1, v3) > 0) {
            temp = node.rv;
            node.rv = node.lv;
            node.lv = temp;
        }

        if (v2 != null) {
            if (sideKick.compare(v2, v3) > 0) {
                temp = node.rv;
                node.rv = node.mv;
                node.mv = temp;
            }
            if (sideKick.compare(v1, v2) > 0) {
                temp = node.lv;
                node.lv = node.mv;
                node.mv = temp;
            }
        }
    }

    public void setM(final Bono23Node<T> mChild) {
        this.mChild = mChild;
    }

    public void setMt(final Bono23Node<T> mtChild) {
        this.mtChild = mtChild;
    }

    public void setL(final Bono23Node<T> lChild) {
        this.lChild = lChild;
    }

    public void setR(final Bono23Node<T> rChild) {
        this.rChild = rChild;
    }

    @Override
    public void setP(final BSTNode<T> parent) {
        this.parent = (Bono23Node<T>) parent;
    }

    public void setLv(final T lv) {
        this.lv = lv;
    }

    public void setMv(final T mv) {
        this.mv = mv;
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

    public Bono23Node<T> getMt() {
        return this.mtChild;
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

    public char type() {
        int type = 1;

        if (this.getLv() != null) {
            type++;
        }

        if (this.getMv() != null) {
            type++;
        }

        if (this.getRv() != null) {
            type++;
        }

        this.color = Character.forDigit(type, 10);

        return this.color;
    }

    @Override
    public String toString() {
        return "Node" + "(" + this.lv + ", " + this.mv + ", " + this.rv + ")";
    }
}
