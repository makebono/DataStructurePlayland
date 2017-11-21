package com.makebono.datastructures.matrix.matrix;

/** 
 * @ClassName: HungarianContainer 
 * @Description: Container for Hungarian algorithm. Includes a int as the cost and a boolean flag 
 * indicates if this entries is checked in the lines drawing part.
 * @author makebono
 * @date 2017年11月21日 上午10:05:15 
 *  
 */
public class HungarianContainer {
    private int value;
    private boolean checked;

    public HungarianContainer(final int value) {
        this.value = value;
        this.checked = false;
    }

    public void check() {
        this.checked = true;
    }

    public void uncheck() {
        this.checked = false;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isChecked() {
        return this.checked;
    }
}
