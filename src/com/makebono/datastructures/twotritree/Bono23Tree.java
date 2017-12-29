package com.makebono.datastructures.twotritree;

import java.util.ArrayList;

import com.makebono.datastructures.binarysearchtree.BSTNode;
import com.makebono.datastructures.binarysearchtree.BinarySearchBonoTree;
import com.makebono.datastructures.tools.tcomparator.TComparator;
import com.makebono.datastructures.twotritree.twotritreeinterface.TwoTriTree;

/** 
 * @ClassName: Bono23Tree 
 * @Description: Implementation of 2-3 tree
 * @author makebono
 * @date 2017年12月22日 上午9:36:59 
 *  
 */
public class Bono23Tree<T> extends BinarySearchBonoTree<T> implements TwoTriTree<T> {
    private Bono23Node<T> root;

    public Bono23Tree() {
        this.root = null;
        this.size = 0;
        this.sideKick = new TComparator<T>();
    }

    private void pushUp(final Bono23Node<T> node) {
        final Bono23Node<T> parent = node.getP();
        if (parent.getRv() == null) {
            parent.setRv(parent.getLv());
            parent.setLv(node.getMv());
            node.setMv(null);
        }
    }

    public void addNode(final Bono23Node<T> node) {
        if (this.isEmpty()) {
            this.root = node;
        }
    }

    public ArrayList<Bono23Node<T>> bfs23() {
        // TODO Auto-generated method stub
        return null;
    }

    public ArrayList<Bono23Node<T>> dfs23() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BSTNode<T> getByIndex(final int i) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Bono23Node<T> get(final T data) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delByIndex(final int index) {
        // TODO Auto-generated method stub

    }

    public void del23(final T data) {
        // TODO Auto-generated method stub

    }

    @Override
    public String printBFS() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String printDFS() {
        // TODO Auto-generated method stub
        return null;
    }

}
