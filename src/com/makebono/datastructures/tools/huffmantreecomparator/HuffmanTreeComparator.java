package com.makebono.datastructures.tools.huffmantreecomparator;

import java.util.Comparator;

import com.makebono.datastructures.binarysearchtree.HTNode;

/** 
 * @ClassName: HuffmanTreeComparator 
 * @Description: Comparator for HTNode
 * @author makebono
 * @date 2017年11月22日 下午4:26:31 
 *  
 */
public class HuffmanTreeComparator implements Comparator<HTNode> {

    @Override
    public int compare(final HTNode arg0, final HTNode arg1) {
        if (arg0.getData() > arg1.getData()) {
            return 1;
        }
        if (arg0.getData() < arg1.getData()) {
            return -1;
        }
        return 0;
    }

}
