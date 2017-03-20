package com.lj8;

import java.util.function.Function;

/**
 * Created by halfont on 3/20/2017.
 */


public class FunctionClass {
    private static Integer invert(Integer value) {
        return -value;
    }

    private static Integer compute(Function<Integer, Integer> function, Integer value) {
        return function.apply(value);
    }

    public static Integer invertTheNumber(Integer toInvert){
        Function<Integer, Integer> invertFunction = FunctionClass::invert;
        return compute(invertFunction, toInvert);
    }
}
