package com.makebono.datastructures.matrix.matrix;

import com.makebono.datastructures.matrix.matrixinterface.Matrix;

/** 
 * @ClassName: BonoMatrix2D 
 * @Description: 2D Matrix 
 * @author makebono
 * @date 2017年11月20日 下午4:05:40 
 *  
 */
public class BonoMatrix2D implements Matrix {
    private final HungarianContainer[][] entries;
    int m;
    int n;

    public BonoMatrix2D(final int m, final int n) {
        this.entries = new HungarianContainer[m][n];
        this.m = m;
        this.n = n;
    }

    @Override
    public HungarianContainer get(final int m, final int n) {
        return this.entries[m][n];
    }

    @Override
    public void checkAt(final int m, final int n) {
        this.entries[m][n].check();
    }

    @Override
    public void uncheckAt(final int m, final int n) {
        this.entries[m][n].uncheck();
    }

    @Override
    public void set(final int m, final int n, final int input) {
        this.entries[m][n] = new HungarianContainer(input);
    }

    @Override
    public int[][] cloneMatrix() {
        final int[][] temp = new int[this.m][this.n];
        for (int i = 0; i < this.m; i++) {
            for (int o = 0; o < this.n; o++) {
                temp[i][o] = this.entries[i][o].getValue();
            }
        }

        return temp;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("This is a " + this.m + "x" + this.n + " " + this.getClass().getName()
                + "\nIt's entries go like:\n    [");

        for (int i = 0; i < this.m; i++) {
            for (int o = 0; o < this.n; o++) {
                sb.append(this.get(i, o).getValue());
                if (o != this.n - 1) {
                    sb.append(", ");
                }
            }
            if (i != this.m - 1) {
                sb.append("]\n    [");
            }
        }
        sb.append("]");

        return sb.toString();
    }

}
