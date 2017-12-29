package com.makebono.datastructures.binarysearchtree.bstinterface;

import java.util.ArrayList;

import com.makebono.datastructures.binarysearchtree.BSTNode;

/** 
 * @ClassName: BinarySearchTree 
 * @Description: Interface for BST
 * @author makebono
 * @date 2017年11月9日 上午10:49:07 
 *  
 */
public interface BinarySearchTree<T> {
    int size();

    BSTNode<T> getRoot();

    void destroy();

    void addNode(BSTNode<T> node);

    ArrayList<BSTNode<T>> bfs();

    ArrayList<BSTNode<T>> dfs();

    BSTNode<T> getByIndex(int i);

    BSTNode<T> get(T data);

    BSTNode<T> lMax();

    BSTNode<T> rMin();

    void delByIndex(int index);

    void del(T data);

    String printBFS();

    String printDFS();

    boolean isEmpty();
}
