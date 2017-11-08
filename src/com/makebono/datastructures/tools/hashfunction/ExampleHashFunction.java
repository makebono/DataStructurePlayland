package com.makebono.datastructures.tools.hashfunction;

import com.makebono.datastructures.tools.hashfunction.hashfunctioninterface.HashFunction;

/** 
 * @ClassName: ExampleHashFunction 
 * @Description: A example of an easy hash function. Write your own if needed.
 * @author makebono
 * @date 2017年11月8日 下午1:39:40 
 *  
 */
public class ExampleHashFunction implements HashFunction {
    @Override
    public int hash(final int input) {
        return input % 4;
    }
}
