/**   
 * @Title: HTBucket.java 
 * @Package com.makebono.datastructures.hashtable 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author tangxj
 * @date 2017年11月8日 下午12:02:50  
 */
package com.makebono.datastructures.hashtable;

import java.util.Comparator;

import com.makebono.datastructures.binarysearchtree.BSTNode;
import com.makebono.datastructures.binarysearchtree.BinarySearchTree;

/** 
 * @ClassName: HTBucket 
 * @Description: Buckets for hash table. Which just are binary search tree with a hash key.
 * @author makebono
 * @date 2017年11月8日 下午12:02:50 
 *  
 */
public class HTBucket<T> extends BinarySearchTree<T> {
    private int hashKey;

    public HTBucket(final Comparator<T> sideKick) {
        super(sideKick);
    }

    public HTBucket(final BSTNode<T> root, final Comparator<T> sideKick) {
        super(root, sideKick);
    }

    protected void assignHashKey(final int hashKey) {
        this.hashKey = hashKey;
    }

    public int getHashKey() {
        return this.hashKey;
    }

}
