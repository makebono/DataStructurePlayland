package com.makebono.datastructures.matrix.matrixinterface;

import com.makebono.datastructures.matrix.matrix.HungarianContainer;

/** 
 * @ClassName: Matrix 
 * @Description: Matrix interface
 * @author makebono
 * @date 2017年11月20日 下午4:02:48 
 *  
 */
public interface Matrix {
    HungarianContainer get(int m, int n);

    void set(final int m, final int n, int input);

    void checkAt(int m, int n);

    void uncheckAt(int m, int n);

    int[][] cloneMatrix();
}
