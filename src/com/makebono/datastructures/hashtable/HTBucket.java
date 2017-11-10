package com.makebono.datastructures.hashtable;

import java.util.Comparator;

import com.makebono.datastructures.binarysearchtree.BinarySearchBonoTree;

/** 
 * @ClassName: HTBucket 
 * @Description: Buckets for hash table. Which just are binary search tree with a hash key.
 * @author makebono
 * @date 2017年11月8日 下午12:02:50 
 *  
 */
public class HTBucket<T> extends BinarySearchBonoTree<T> {
    private int hashKey;

    public HTBucket(final Comparator<T> sideKick) {
        super(sideKick);
    }

    protected void assignHashKey(final int hashKey) {
        this.hashKey = hashKey;
    }

    public int getHashKey() {
        return this.hashKey;
    }

}
